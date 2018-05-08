package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.SysAuditKeywordModel;
import com.xunyu.model.tactics.SysWhitelistKeywordModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.SysAuditKeyword;
import com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword;
import com.xunyu.xunyu_tactics.service.ExcelService;
import com.xunyu.xunyu_tactics.service.SysAuditKeywordService;
import com.xunyu.xunyu_tactics.service.SysWhitelistKeywordService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
 * @description 系统审核关键字管理控制器
 * @date 2018/5/8 17:31
 */
@RestController
@RequestMapping("/auditkeyword")
public class SysAuditKeywordController {


    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysAuditKeywordService keywordService;

    @Autowired
    ExcelService excelService;

    /**
     * 添加白名单关键字
     * @param model
     * @return Result<String>
     */
    @RequestMapping(value = "/addkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addKeyword(SysAuditKeywordModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        if(model.getKeyword() == null || "".equals(model.getKeyword())){
            checkParamDefeat(result);
            return result;
        }
        model.setIsabled(TacticsConstants.Isabled.ENABLED);
        int success = keywordService.insertKeyword(model);
        if (success > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 删除白名单关键字
     * @param model
     * @return Result<String>
     */
    @RequestMapping(value = "/delkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteKeyword(SysAuditKeywordModel model){
        Result result = checkLogin(new Result(), model.getSessionId());
        if (result.getMessage() != null) {
            return result;
        }
        if(model.getKeyword() == null || "".equals(model.getKeyword())){
            checkParamDefeat(result);
            return result;
        }
        int success = keywordService.deleteKeyword(model);
        if (success > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 查询白名单关键字列表
     * @param model
     * @return Result<String>
     */
    @RequestMapping(value = "/getkeywordlist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> getKeywordList(SysAuditKeywordModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        if (model.getCurrPage() == 0){
            checkParamDefeat(result);
            return result;
        }
        model.setOffset(model.getStartRows());
        int totalRows = keywordService.selectTotalRows(model);
        if (totalRows <= 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.NO_VALUE);
            return result;
        }
        List<SysAuditKeyword> list = keywordService.selectKeywordList(model);
        if (list != null && list.size() > 0){
            operationSuccess(result);
            result.setTotalRows(totalRows);
            result.setRes(list);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 批量删除白名单关键字
     */
    @RequestMapping(value = "/batchdelkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteKeyword(SysAuditKeywordModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        if (model.getIdList() == null || model.getIdList().size() <= 0){
            checkParamDefeat(result);
            return result;
        }
        int success = keywordService.batchDeleteKeyword(model);
        if (success > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 导入添加白名单关键字
     * @param request
     * @param sessionId
     * @return Result<String>
     */
    @RequestMapping(value = "/exceladdkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> excelAddKeyword(HttpServletRequest request,String sessionId) throws Exception{
        Result result = checkLogin(new Result(),sessionId);
        if(result.getMessage() != null ){
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
        List<SysAuditKeyword> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet){
            if(row.getRowNum()<1){
                continue;
            }
            SysAuditKeyword sysInterceptKeyword = new SysAuditKeyword();
            String keyword = row.getCell(0).getStringCellValue();
            sysInterceptKeyword.setKeyword(keyword);
            sysInterceptKeyword.setIsabled(TacticsConstants.Isabled.ENABLED);
            list.add(sysInterceptKeyword);
        }
        if ( list.size() <= 0 ){
            operationFailed(result);
            result.setMessage("文件中没有数据，请完善表格后再导入");
            return result;
        }
        int success = keywordService.excelAddKeyword(list);
        if (success > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }

    /**
     * 导入删除拦截关键词
     */
    @RequestMapping(value = "/exceldelkeyword" ,method = RequestMethod.POST)
    public Result<String> excelDelKeyword(HttpServletRequest request,String sessionId) throws Exception{
        Result result = checkLogin(new Result(), sessionId);
        if (result.getMessage() != null) {
            return result;
        }
        Map map = excelService.getWorkBook(request);
        Workbook workbook = (Workbook)map.get("workbook");
        String fileType = (String)map.get("filetype");
        if (!(TacticsConstants.Suffix.XLS).equals(fileType.toLowerCase()) &&  !(TacticsConstants.Suffix.XLSX).equals(fileType.toLowerCase())){
            operationFailed(result);
            result.setMessage("文件格式错误");
            return result;
        }
        if (workbook == null){
            operationFailed(result);
            return result;
        }
        List<SysAuditKeyword> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet){
            //文件第一行为抬头，不读取
            if(row.getRowNum()<1){
                continue;
            }
            SysAuditKeyword sysInterceptKeyword = new SysAuditKeyword();
            String keyword = row.getCell(0).getStringCellValue();
            sysInterceptKeyword.setKeyword(keyword);
            list.add(sysInterceptKeyword);
        }
        if ( list.size() <= 0 ){
            operationFailed(result);
            result.setMessage("文件中没有数据，请完善表格后再导入");
            return result;
        }
        int success = keywordService.excelDeleteKeyword(list);
        if (success > 0){
            operationSuccess(result);
        }else {
            operationFailed(result);
            result.setMessage("文件中的关键字在库中不存在");
        }
        return result;
    }


    /**
     * 检查内容关键字
     * @param model
     * @return Result<String>
     */
    @RequestMapping(value = "/checkkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> checkKeyword(SysAuditKeywordModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        if (model.getContent() == null || "".equals(model.getContent())){
            checkParamDefeat(result);
            return result;
        }
        List<String> list = keywordService.checkKeyword(model);
        if(list != null && list.size() > 0){
            operationSuccess(result);
            result.setRes(list);
        }else {
            result.setMessage(ResultMessage.Message.NO_VALUE);
            result.setCode(ResultMessage.Code.SUCCESS);
        }
        return result;
    }
    /**
     * 检查登陆
     * @param r
     * @param sessionId
     */
    private Result checkLogin(Result r, String sessionId){
        boolean flag = redisUtil.sessionStatus(sessionId);
        if (!flag) {
            r.setCode(ResultMessage.Code.NOT_FOUND);
            r.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return r;
    }

    /**
     * 操作成功
     * @param result
     */
    private void operationSuccess(Result result){
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
        result.setRes(TacticsConstants.CompleteStatus.SUCCESS);
    }

    /**
     * 操作失败
     * @param result
     */
    private void operationFailed(Result result){
        result.setCode(ResultMessage.Code.FAILED);
        result.setMessage(ResultMessage.Message.FAILED);
        result.setRes(TacticsConstants.CompleteStatus.FAILED);
    }

    /**
     * 检验参数失败
     * @param result
     */
    private void checkParamDefeat(Result result){
        result.setMessage(ResultMessage.Message.PRAMA_LOSS);
        result.setCode(ResultMessage.Code.PRAMA_LOSS);
        result.setRes(TacticsConstants.CompleteStatus.FAILED);
    }
}
