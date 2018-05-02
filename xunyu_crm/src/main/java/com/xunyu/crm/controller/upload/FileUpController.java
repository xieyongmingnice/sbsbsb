package com.xunyu.crm.controller.upload;

import com.commons.core.util.StringUtils2;
import com.xunyu.config.oos.AliyunOssUtil;
import com.xunyu.config.oos.ImgUtils;
import com.xunyu.config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * @author dth
 * @date 2018/4/25 18:14
 **/
@RestController
@RequestMapping("/upload")
public class FileUpController {

    @Autowired
    private AliyunOssUtil aliyunOssUtil;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 上传文件
     * @Param file文件对象
     * @Param dirName目录名称
     * @Param fileName文件名称
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public Map<String,Object> uploadFileData(HttpServletRequest request
                 ,String sessionId,HttpServletResponse response){

        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils2.isNotEmpty(sessionId)) {
            boolean status = redisUtil.sessionStatus(sessionId);
            if (!status) {
                map.put("code", "404");
                map.put("message", "当前会话失效，请跳转到登录页");
                return map;
            }
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                // 取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //System.out.println("获取到的文件。。。"+iter.next());
                    // 取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    String fileName = file.getOriginalFilename();
                    String rex = fileName.substring(fileName.lastIndexOf("."));
                    try {
                        //AliyunOssUtil aliyunOssUtil = AliyunOssUtil.getInstance();
                        String dirName = rex+"/";//通过后缀确定上传目录名称
                        StringBuffer newName = new StringBuffer();
                        newName.append(UUID.randomUUID()).append(rex);
                        if (ImgUtils.isImg(rex)) {//是图片

                            map = aliyunOssUtil.ImgUploadLimitSizeOSS(file, dirName, newName.toString(), 9);
                        } else {

                            map = aliyunOssUtil.uploadFileOSS(file, dirName, newName.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } else {
                map.put("code","412");
                map.put("message", "未获取到file值");
            }
        }else{
            map.put("code","413");
            map.put("message","sessionId不能为空");
        }
        return map;
    }

}
