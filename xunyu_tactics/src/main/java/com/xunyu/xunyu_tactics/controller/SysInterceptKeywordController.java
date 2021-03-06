package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.SysInterceptKeywordModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword;
import com.xunyu.xunyu_tactics.service.FileService;
import com.xunyu.xunyu_tactics.service.SysInterceptKeywordService;
import com.xunyu.xunyu_tactics.util.PoiUtil;
import org.apache.poi.ss.usermodel.CellType;
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
 * @description 系统拦截关键字 控制器
 * @date 2018/5/7 17:37
 */
@RestController
@RequestMapping("/inckeyword")
public class SysInterceptKeywordController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysInterceptKeywordService keywordService;

    @Autowired
    FileService fileService;

    /**
     * 新增拦截关键词
     */
    @RequestMapping(value = "/addkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addKeyword(SysInterceptKeywordModel model) throws Exception{
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
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
     * 删除拦截关键词
     */
    @RequestMapping(value = "/delkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteKeyword(SysInterceptKeywordModel model) throws Exception {
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
     * 查询拦截关键词列表
     */
    @RequestMapping(value = "/getkeywordlist",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<SysInterceptKeyword>> getKeywordList(SysInterceptKeywordModel model){
        Result result = checkLogin(new Result(), model.getSessionId());
        if (result.getMessage() != null) {
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
        List<SysInterceptKeyword> list = keywordService.selectKeywordList(model);
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
     * 批量删除拦截关键词
     */
    @RequestMapping(value = "/batchdelkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteKeyword(SysInterceptKeywordModel model){
        Result result = checkLogin(new Result(), model.getSessionId());
        if (result.getMessage() != null) {
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
     * 导入新增拦截关键词
     */
    @RequestMapping(value = "/exceladdkeyword" ,method = RequestMethod.POST)
    public Result<String> excelAddKeyword(HttpServletRequest request,String sessionId) throws Exception{
        Result result = checkLogin(new Result(), sessionId);
        if (result.getMessage() != null) {
            return result;
        }
        Map map = fileService.getWorkBook(request);
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
        List<SysInterceptKeyword> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet){
            if(row.getRowNum()<1){
                continue;
            }
            String keyword = PoiUtil.getKeyword(row.getCell(0));
            SysInterceptKeyword sysInterceptKeyword = new SysInterceptKeyword();
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
        Map map = fileService.getWorkBook(request);
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
        List<SysInterceptKeyword> list = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet){
            //文件第一行为抬头，不读取
            if(row.getRowNum()<1){
                continue;
            }
            SysInterceptKeyword sysInterceptKeyword = new SysInterceptKeyword();
            String keyword = PoiUtil.getKeyword(row.getCell(0));
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
        }
        return result;
    }

    /**
     * 检查内容关键字
     * @return 内容中存在的关键字list
     */
    @RequestMapping(value = "/checkkeyword",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<String>> checkKeyword(SysInterceptKeywordModel model) throws Exception{
        Result result = checkLogin(new Result(), model.getSessionId());
        if (result.getMessage() != null) {
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
     */
    private void checkParamDefeat(Result result){
        result.setMessage(ResultMessage.Message.PRAMA_LOSS);
        result.setCode(ResultMessage.Code.PRAMA_LOSS);
        result.setRes(TacticsConstants.CompleteStatus.FAILED);
    }
}
