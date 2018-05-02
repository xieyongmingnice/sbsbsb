package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.model.user.UserModel;
import com.xunyu.xunyu_tactics.constant.SysRedlistConstant;
import com.xunyu.xunyu_tactics.pojo.SysRedlist;
import com.xunyu.xunyu_tactics.service.SysRedlistService;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @author xym
 * @description 系统级红名单controller
 * @date 2018/4/28 11:21
 */
@RestController("/sysredlist")
public class SysRedlistController {

    private static final Logger logger = LoggerFactory.getLogger(SysRedlistController.class);

    private static final String SUCCESS = "SUCCESS";

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysRedlistService sysRedlistService;

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
        try{
            int success = sysRedlistService.addSysRedlist(model);
            if (success>0){
                operationSuccess(result);
                result.setRes(SUCCESS);
            }else {
                operationFailed(result);
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
        try{
            List<SysRedlistVO> redlist = sysRedlistService.selectSysRedlist(model);
            if (redlist != null && redlist.size() > 0){
                result.setRes(redlist);
                operationSuccess(result);
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
        try{
            int success = sysRedlistService.deleteSysRedlist(model);
            if (success>0){
                operationSuccess(result);
                result.setRes(SUCCESS);
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
     * 导入添加
     */
    @RequestMapping(value = "/exceladdredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result excelAddRedlist(HttpRequest request, UserModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        MultipartFile mFile = mRequest.getFile("file");
        String fileName = mFile.getOriginalFilename();
        String fileType = "";
        Workbook workbook = null;
        try{
            fileType = fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(".")+4);
            CommonsMultipartFile cFile = (CommonsMultipartFile) mFile;
            DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
            InputStream inputStream = fileItem.getInputStream();
            workbook = new HSSFWorkbook(inputStream);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            fileType = "";
        }

        if (!("xls").equals(fileType.toLowerCase())){
            result.setMessage("文件格式错误");
            result.setCode(ResultMessage.Code.FAILED);
            return result;
        }
        if (workbook != null){
            List<SysRedlist> list = Lists.newArrayList();
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet){
                if(row.getRowNum()<1){
                    continue;
                }
                SysRedlist redlist = new SysRedlist();
                redlist.setPhoneNumber(row.getCell(0).getStringCellValue());
                redlist.setRemarks("手动导入");
                redlist.setRedlistSource(SysRedlistConstant.RedlistSource.MANUAL_ADD);
                list.add(redlist);
            }

        }

        return result;
    }
    /**
     * 导入删除
     */
    @RequestMapping(value = "/exceldelredlist" ,method = RequestMethod.POST)
    @ResponseBody
    public Result excelDeleteRedlist(){
        Result result = new Result();
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
