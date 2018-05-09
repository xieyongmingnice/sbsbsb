package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.SysWhitelistModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.SysWhitelist;
import com.xunyu.xunyu_tactics.service.FileService;
import com.xunyu.xunyu_tactics.service.SysWhitelistService;
import org.apache.poi.ss.usermodel.CellType;
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
import java.util.regex.Pattern;

/**
 * @author xym
 * @description 系统白名单控制器
 * @date 2018/5/3 17:06
 */
@RestController
@RequestMapping("/syswhitelist")
public class SysWhitelistController {

    private static final Logger logger = LoggerFactory.getLogger(SysWhitelistController.class);

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysWhitelistService whitelistService;

    @Autowired
    FileService fileService;



    /**
     * 添加白名单号码
     */
    @RequestMapping(value = "/addwhitelist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addWhitelist(SysWhitelistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        int success = 0;
        try {
            success = whitelistService.insertWhitelist(model);
        }catch (Exception e){
            catchExcpetion(e,result);
            return result;
        }
        if (success > 0 ){
            operationSuccess(result);
        }else {
            operationFailed(result);
            result.setMessage("操作失败，请检查手机号是否已存在系统白名单中");
        }
        return result;
    }


    /**
     * 删除白名单号码
     */
    @RequestMapping(value = "/delwhitelist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteWhiteList(SysWhitelistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        if (model.getPhoneNumber() == null || ("").equals(model.getPhoneNumber())){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setRes(TacticsConstants.CompleteStatus.FAILED);
            return result;
        }
        int success = whitelistService.deleteWhitelist(model);
        if (success > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }


    /**
     * 查询白名单号码列表
     */
    @RequestMapping(value = "/getwhitelist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<List<SysWhitelist>> getWhitelist(SysWhitelistModel model){
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

            int totalRows = whitelistService.selectTotalRows(model);
            if (totalRows <= 0){
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setMessage(ResultMessage.Message.NO_VALUE);
                return result;
            }
            List<SysWhitelist> list = whitelistService.selectWhitelist(model);
            if (list != null && list.size() > 0){
                operationSuccess(result);
                result.setRes(list);
                result.setTotalRows(totalRows);
            }
        return result;
    }


    /**
     * 导入添加白名单号码列表
     */
    @RequestMapping(value = "/exceladdwhitelist" ,method = RequestMethod.POST)
    public Result<String> excelAddWhiteList(String sessionId, HttpServletRequest request)  throws Exception{
        Result result = checkLogin(new Result(),sessionId);
        if (result.getMessage() != null){
            return result;
        }
        Map map = fileService.getWorkBook(request);
        String fileType = (String)map.get("filetype");
        Workbook workbook = (Workbook)map.get("workbook");

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
        List<SysWhitelist> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        StringBuffer sb = new StringBuffer("");
        for (Row row : sheet){
            if(row.getRowNum()<1){
                continue;
            }
            SysWhitelist whitelist = new SysWhitelist();
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
            whitelist.setPhoneNumber(String.valueOf(phoneNumber));
            whitelist.setIsabled(TacticsConstants.Isabled.ENABLED);
            list.add(whitelist);
        }
        if ( list.size() <= 0 ){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("文件中没有数据，请完善表格后再导入");
            return result;
        }
        int count = whitelistService.excelInsertWhitelist(list);
        if (count > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        if (!"".equals(sb.toString())){
            result.setRes(sb.toString());
        }
        return result;
    }


    /**
     * 批量删除白名单
     */
    @RequestMapping(value = "/batchdelwhitelist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteWhitelist(SysWhitelistModel model) throws Exception{
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null){
            return result;
        }
        List<String> idList = model.getIdList();
        if (idList == null || idList.size() <= 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        int count = whitelistService.batchDeleteWhitelist(model);
        if (count == idList.size()){
            operationSuccess(result);
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

    private void catchExcpetion(Exception e,Result result){
        result.setCode(ResultMessage.Code.ERROR);
        result.setMessage(ResultMessage.Message.ERROR);
        logger.info("系统异常");
        e.printStackTrace();
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
