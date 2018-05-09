package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.SysRedlist;
import com.xunyu.xunyu_tactics.service.FileService;
import com.xunyu.xunyu_tactics.service.SysRedlistService;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author xym
 * @description 系统级红名单controller
 * @date 2018/4/28 11:21
 */
@RestController
@RequestMapping("/sysredlist")
public class SysRedlistController {

    private static final Logger logger = LoggerFactory.getLogger(SysRedlistController.class);

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysRedlistService sysRedlistService;

    @Autowired
    FileService fileService;

    /**
     * 新增红名单
     */
    @RequestMapping(value = "/addredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addRedlist(SysRedlistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        if (model.getPhoneNumber() == null || ("").equals(model.getPhoneNumber())){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setRes(TacticsConstants.CompleteStatus.FAILED);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            return result;
        }
        try{
            model.setRedlistSource(TacticsConstants.RedlistSource.MANUAL_ADD);
            model.setIsabled(TacticsConstants.Isabled.ENABLED);
            model.setRemarks("手动添加");
            int success = sysRedlistService.addSysRedlist(model);
            if (success>0){
                operationSuccess(result);
                result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
            }else {
                operationFailed(result);
                result.setMessage("操作失败，请检查手机号是否已存在红名单中");
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 查询
     */
    @RequestMapping(value = "/getredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<List<SysRedlistVO>> getRedlist(SysRedlistModel model){
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
        try{
            int totalRows = sysRedlistService.selectTotalRows(model);
            List<SysRedlistVO> redlist = sysRedlistService.selectSysRedlist(model);
            if (redlist != null && redlist.size() > 0){
                result.setRes(redlist);
                operationSuccess(result);
                result.setTotalRows(totalRows);
            }else {
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setMessage(ResultMessage.Message.NO_VALUE);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteRedlist(SysRedlistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        if (model.getPhoneNumber() == null || ("").equals(model.getPhoneNumber())){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setRes("FAILED");
            return result;
        }
        try{
            int success = sysRedlistService.deleteSysRedlist(model);
            if (success>0){
                operationSuccess(result);
                result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
            }else {
                operationFailed(result);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 清空
     */
    @RequestMapping(value = "/clearredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result clearRedlist(){
        Result result = new Result();
        return result;
    }

    /**
     * 批量删除红名单
     */
    @RequestMapping(value = "/batchdelredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteRedlist(SysRedlistModel model) throws Exception{
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        if (model.getIdList() == null || model.getIdList().size() == 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        int count = sysRedlistService.batchDeleteRedlist(model);
        if (count > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
        }else {
            operationFailed(result);
        }
        return result;
    }

    /**
     * 导入添加
     */
    @RequestMapping(value = "/exceladdredlist" ,method = RequestMethod.POST)
    public Result<String> excelAddRedlist(HttpServletRequest request, String sessionId){
        Result result = checkLogin(new Result(),sessionId);
        if (result.getMessage() != null){
            return result;
        }
        String fileType = "";
        Workbook workbook = null;
        try {
            Map map = fileService.getWorkBook(request);
            fileType = (String)map.get("filetype");
            workbook = (Workbook)map.get("workbook");
        }catch (Exception e){
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        if (!(TacticsConstants.Suffix.XLS).equals(fileType.toLowerCase()) &&  !(TacticsConstants.Suffix.XLSX).equals(fileType.toLowerCase())){
            result.setMessage("文件格式错误");
            result.setCode(ResultMessage.Code.FAILED);
            return result;
        }
        if (workbook == null){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage(ResultMessage.Message.FAILED);
            return result;
        }
        List<SysRedlist> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        StringBuffer sb = new StringBuffer("");
        for (Row row : sheet){
            if (row.getRowNum() < 1){
                continue;
            }
            SysRedlist redlist = new SysRedlist();
            if (row.getCell(0).getCellTypeEnum()!= CellType.NUMERIC){
                sb.append("第"+(row.getRowNum()+1) + "行不是正确的手机号格式"+TacticsConstants.Separator.COMMA);
                continue;
            }
            long phoneNumber =  (long)row.getCell(0).getNumericCellValue();
            String phoneNumberStr = String.valueOf(phoneNumber).trim();
            Pattern pattern = Pattern.compile(TacticsConstants.Regex.PHONE_NUMBER);
            if (phoneNumberStr.length() != 11 || !pattern.matcher(phoneNumberStr).matches() ){
                sb.append("第"+(row.getRowNum()+1) + "行不是正确的手机号格式"+TacticsConstants.Separator.COMMA);
                continue;
            }
            redlist.setPhoneNumber(String.valueOf(phoneNumber));
            redlist.setRemarks("手动导入");
            redlist.setRedlistSource(TacticsConstants.RedlistSource.MANUAL_ADD);
            list.add(redlist);
        }
        if ( list.size() <= 0 ){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("表中没有数据，请完善表格后再导入");
            return result;
        }
        try {
            int count = sysRedlistService.excelAddRedlist(list);
            if(count > 0){
                result.setMessage(ResultMessage.Message.SUCCESS);
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
            }else {
                operationFailed(result);
                result.setMessage("操作失败，请检查手机号是否已存在红名单中");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        if (!"".equals(sb.toString())){
            result.setRes(sb.toString());
        }
        return result;
    }
    /**
     * 导入删除
     */
    @RequestMapping(value = "/exceldelredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result excelDeleteRedlist(HttpServletRequest request,SysRedlistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        String fileType = "";
        Workbook workbook = null;
        try {
            Map map = fileService.getWorkBook(request);
            fileType = (String)map.get("filetype");
            workbook = (Workbook)map.get("workbook");
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.getMessage());
        }
        if (!(TacticsConstants.Suffix.XLS).equals(fileType.toLowerCase()) &&  !(TacticsConstants.Suffix.XLSX).equals(fileType.toLowerCase())){
            result.setMessage("文件格式错误");
            result.setCode(ResultMessage.Code.FAILED);
            return result;
        }
        if (workbook == null){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage(ResultMessage.Message.FAILED);
            return result;
        }
        List<SysRedlist> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        StringBuffer sb = new StringBuffer("");
        for (Row row : sheet){
            if(row.getRowNum()<1){
                continue;
            }
            SysRedlist redlist = new SysRedlist();
            if (row.getCell(0).getCellTypeEnum()!= CellType.NUMERIC){
                sb.append("第"+(row.getRowNum()+1) + "行不是正确的手机号格式"+TacticsConstants.Separator.COMMA);
                continue;
            }
            long phoneNumber =  (long)row.getCell(0).getNumericCellValue();
            String phoneNumberStr = String.valueOf(phoneNumber).trim();
            Pattern pattern = Pattern.compile(TacticsConstants.Regex.PHONE_NUMBER);
            if (phoneNumberStr.length() != 11 || !pattern.matcher(phoneNumberStr).matches() ){
                sb.append("第"+(row.getRowNum()+1) + "行不是正确的手机号格式"+TacticsConstants.Separator.COMMA);
                continue;
            }
            redlist.setPhoneNumber(String.valueOf(phoneNumber));
            list.add(redlist);
        }
        if ( list.size() <= 0 ){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("文件中没有数据，请完善表格后再导入");
            return result;
        }
        try {
            int count = sysRedlistService.excelDeleteRedlist(list);
            if(count > 0 ){
                operationSuccess(result);
                result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
            }else {
                operationFailed(result);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        if (!"".equals(sb.toString())){
          result.setRes(sb.toString());
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

    private void catchExcpetion(Exception e,Result result){
        result.setCode(ResultMessage.Code.ERROR);
        result.setMessage(ResultMessage.Message.ERROR);
        logger.info("系统异常");
        e.printStackTrace();
    }

    private void operationSuccess(Result result){
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
    }

    private void operationFailed(Result result){
        result.setCode(ResultMessage.Code.FAILED);
        result.setMessage(ResultMessage.Message.FAILED);
    }
}
