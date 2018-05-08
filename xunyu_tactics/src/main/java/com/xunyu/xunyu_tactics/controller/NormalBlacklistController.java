package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.NormalBlacklistModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.NormalBlacklist;
import com.xunyu.xunyu_tactics.service.ExcelService;
import com.xunyu.xunyu_tactics.service.NormalBlacklistService;
import com.xunyu.xunyu_tactics.vo.NormalBlacklistVO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author xym
 * @description 普通黑名单控制器
 * @date 2018/5/4 16:54
 */
@RestController
@RequestMapping("/blacklist")
public class NormalBlacklistController {

    private static final Logger logger = LoggerFactory.getLogger(NormalBlacklistController.class);

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ExcelService excelService;

    @Autowired
    NormalBlacklistService blacklistService;

    /**
     * 新增
     */
    @RequestMapping(value = "/addblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addBlacklist(NormalBlacklistModel model) throws Exception{
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        if (model.getPhoneNumber() == null){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        model.setBlacklistSource(TacticsConstants.RedlistSource.MANUAL_ADD);
        model.setRemarks("手动添加");
        int success = blacklistService.addBlacklist(model);
        if (success>0){
            operationSuccess(result);
        }else {
            operationFailed(result);
            result.setMessage("操作失败，请检查手机号是否已存在黑名单中");
        }
        return result;
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/deleteblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteBlacklist(NormalBlacklistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        int success = blacklistService.deleteBlacklist(model);
        if (success>0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 查询列表
     */
    @RequestMapping(value = "/getblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<NormalBlacklistVO>> getBlacklist(NormalBlacklistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        int currPage = model.getCurrPage();
        if (currPage == 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        model.setOffset(model.getStartRows());
        int totalRows = blacklistService.selectTotalRows(model);
        if (totalRows <= 0){
            result.setMessage(ResultMessage.Message.NO_VALUE);
            result.setCode(ResultMessage.Code.SUCCESS);
            return result;
        }
        List<NormalBlacklistVO> list = blacklistService.selectBlacklist(model);
        if (list != null && list.size() > 0){
            operationSuccess(result);
            result.setRes(list);
            result.setTotalRows(totalRows);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 批量删除
     */
    @RequestMapping(value = "/batchdeleteblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteBlacklist(NormalBlacklistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        List<String> idList = model.getIdList();
        if (idList == null || idList.size() <= 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        int count = blacklistService.batchDeleteBlacklist(model);
        if (count > 0 ){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }

    /**
     * 导入excel 新增
     */
    @RequestMapping(value = "/exceladdblacklist",method = RequestMethod.POST)
    public Result<String> excelAddBlacklist(HttpServletRequest request,String sessionId) throws Exception{
        Result result = checkLogin(new Result(),sessionId);
        if (result.getMessage() != null){
            return result;
        }
        Map map = excelService.getWorkBook(request);
        String fileType = (String)map.get("filetype");
        Workbook workbook = (Workbook)map.get("workbook");

        if (!(TacticsConstants.Suffix.XLS).equals(fileType.toLowerCase()) &&  !(TacticsConstants.Suffix.XLSX).equals(fileType.toLowerCase())){
            operationFailed(result);
            result.setMessage("文件格式错误");
            return result;
        }
        if (workbook == null){
            operationFailed(result);
            return result;
        }
        List<NormalBlacklist> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet){
            if(row.getRowNum()<1){
                continue;
            }
            NormalBlacklist blacklist = new NormalBlacklist();
            long phoneNumber = (long) row.getCell(0).getNumericCellValue();
            blacklist.setPhoneNumber(String.valueOf(phoneNumber));
            blacklist.setIsabled(TacticsConstants.Isabled.ENABLED);
            blacklist.setBlacklistSource(TacticsConstants.BlacklistSource.MANNUAL);
            blacklist.setRemarks("手动导入");
            list.add(blacklist);
        }
        if ( list.size() <= 0 ){
            operationFailed(result);
            result.setMessage("文件中没有数据，请完善表格后再导入");
            return result;
        }
        int count = blacklistService.excelAddBlacklist(list);
        if (count > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 导入excel 删除
     */
    @RequestMapping(value = "/exceldelblacklist",method = RequestMethod.POST)
    public Result<String> excelDeleteBlacklist(HttpServletRequest request,String sessionId) throws Exception{
        //TODO 判断文件中的数据是否为电话号码
        Result result = checkLogin(new Result(),sessionId);
        if (result.getMessage() != null){
            return result;
        }
        Map map = excelService.getWorkBook(request);
        String fileType = (String)map.get("filetype");
        Workbook workbook = (Workbook)map.get("workbook");

        if (!(TacticsConstants.Suffix.XLS).equals(fileType.toLowerCase()) &&  !(TacticsConstants.Suffix.XLSX).equals(fileType.toLowerCase())){
            result.setMessage("文件格式错误");
            result.setCode(ResultMessage.Code.FAILED);
            return result;
        }
        if (workbook == null){
            operationFailed(result);
            return result;
        }
        List<NormalBlacklist> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet){
            if(row.getRowNum()<1){
                continue;
            }
            NormalBlacklist blacklist = new NormalBlacklist();
            long phoneNumber = (long) row.getCell(0).getNumericCellValue();
            blacklist.setPhoneNumber(String.valueOf(phoneNumber));
            list.add(blacklist);
        }
        if ( list.size() <= 0 ){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("文件中没有数据，请完善表格后再导入");
            return result;
        }

        int count = blacklistService.excelDeleteBlacklist(list);
        if(count > 0 ){
            operationSuccess(result);
            result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
        }else {
            operationFailed(result);
        }

        return result;
    }

    private Result checkLogin(Result r, String sessionId){
        boolean flag = redisUtil.sessionStatus(sessionId);
        if (!flag) {
            r.setCode(ResultMessage.Code.NOT_FOUND);
            r.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return r;
    }

    private void operationSuccess(Result result){
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
        result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
    }

    private void operationFailed(Result result){
        result.setCode(ResultMessage.Code.FAILED);
        result.setMessage(ResultMessage.Message.FAILED);
        result.setRes(TacticsConstants.CompleteStatus.FAILED);
    }
}
