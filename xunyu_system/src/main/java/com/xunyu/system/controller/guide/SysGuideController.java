package com.xunyu.system.controller.guide;

import com.commons.core.message.Result;
import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.oos.AliyunOssUtil;
import com.xunyu.config.oos.ImgUtils;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.guide.SysGuideModel;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.guide.SysGuide;
import com.xunyu.system.service.guide.SysGuideService;
import com.xunyu.system.utils.syslog.CrmService;
import com.xunyu.system.utils.syslog.LogService2;
import com.xunyu.system.utils.syslog.SysLogsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author dth
 * @date 2018/5/3 11:44
 **/
@RestController
@RequestMapping(value = "/guide")
public class SysGuideController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysGuideService sysGuideService;
    @Autowired
    private AliyunOssUtil aliyunOssUtil;
    @Resource
    private LogService2 logService;
    @Resource
    private CrmService crmService;
    /**
     * 添加文件
     */
    @RequestMapping(value = "addSysGuide",method = RequestMethod.POST)
    public Result<Map<String, Object>> addSysGuideData(HttpServletRequest request,SysGuideModel sm) throws Exception{
        Result<Map<String, Object>> res = new Result<Map<String, Object>>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int n = 0;
        if(StringUtils2.isEmpty(sm.getGuideName())){
            res.setCode("413");
            res.setMessage("guidName 不能为空");
            return res;
        }else{
            map = uploadFileData(request,sm.getGuideName());
            if(map != null) {
                String code = String.valueOf(map.get("code"));
                if("200".equals(code)){//上传成功
                    String url = String.valueOf(map.get("url"));
                    String rex = String.valueOf(map.get("rex"));
                    //开始添加一条记录
                    SysGuide sg = new SysGuide();
                    sg.setCreateTime(new Date());
                    sg.setFileType(rex);
                    sg.setGuideName(sm.getGuideName());
                    sg.setGuidePath(url);
                    sg.setIsabled(1);
                    n = sysGuideService.addSysGuide(sg);
                    res.setCode("200");
                    res.setMessage("success");
                    res.setRes(map);
                    if(n > 0){
                        //异步添加日志
                        SysLogsUtil su = SysLogsUtil.getInstance();
                        su.addSysLogs(logService,us,"添加系统基本指导内容"
                                ,"添加",request,"添加系统基本指导内容信息",crmService);
                    }
                }
            }else{
                map.put("code","412");
                map.put("message", "未获取到file值");
            }
        }
        res.setRes(map);
        return res;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "delSysGuide",method = RequestMethod.POST)
    public Result<SysGuideModel> delSysGuideData(SysGuideModel sm,HttpServletRequest request) throws Exception {
        Result<SysGuideModel> res = new Result<SysGuideModel>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(sm.getGuideIds())){
            String[] ids = sm.getGuideIds().split(",");
            String[] array = new String[ids.length];
            for (int i = 0; i < ids.length; i++) {
                if(RandomUtils.isInteger(ids[i])){
                    array[i] = ids[i];

                }else{
                    continue;
                }
            }
            map.put("isabled",0);
            map.put("array",array);
            n = sysGuideService.delSysGuide(map);
            res.setCode("200");
            res.setMessage("success");
            if(n > 0){
                //异步添加日志
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService,us,"删除系统基本指导内容"
                        ,"删除",request,"删除系统基本指导内容信息",crmService);
            }
        }else{
            res.setCode("413");
            res.setMessage("guideIds不能为空");
        }

        return res;
    }

    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "sysGuideList",method = RequestMethod.POST)
    public Result<List<SysGuide>> sysGuideListData(SysGuideModel sm) throws Exception {
        Result<List<SysGuide>> res = new Result<List<SysGuide>>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        List<SysGuide> list = sysGuideService.sysGuideList(map);
        if(list != null && list.size() > 0){
            res.setCode("200");
            res.setMessage("success");
            res.setRes(list);

        }else{
            res.setCode("412");
            res.setMessage("notvalue");
        }
        return res;
    }

    private Map<String,Object> uploadFileData(HttpServletRequest request,String newFileName){

            Map<String,Object> map = new HashMap<String,Object>();
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                // 取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    // 取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    String fileName = file.getOriginalFilename();
                    String rex = fileName.substring(fileName.lastIndexOf("."));
                    try {
                        String dirName = rex+"/";//通过后缀确定上传目录名称
                        StringBuffer newName = new StringBuffer();
                        newName.append(UUID.randomUUID()).append(rex);
                        if (ImgUtils.isImg(rex)) {//是图片
                            map = aliyunOssUtil.ImgUploadLimitSizeOSS(file, dirName, newName.toString(), 9);
                        } else {
                            map = aliyunOssUtil.uploadFileOSS(file, dirName, newName.toString());
                        }
                        map.put("rex",rex);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                map.put("code","412");
                map.put("message", "未获取到file值");
            }
        return map;
    }


}
