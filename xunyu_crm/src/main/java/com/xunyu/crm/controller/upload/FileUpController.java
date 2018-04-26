package com.xunyu.crm.controller.upload;

import com.xunyu.config.oos.AliyunOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author dth
 * @date 2018/4/25 18:14
 **/
@RestController(value = "/upload")
public class FileUpController {

    /**
     * 注入
     */
    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    /**
     * 上传文件
     * @Param file文件对象
     * @Param dirName目录名称
     * @Param fileName文件名称
     */
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    public Map<String,Object> uploadFileData(HttpServletRequest request,
           String folderName,HttpServletResponse response){

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String,Object> map = new HashMap<String,Object>();
        CommonsMultipartFile file = null;
        file = (CommonsMultipartFile) multipartRequest.getFile("imgFile");
        String fileName = file.getOriginalFilename();
        if(file != null) {
            try {
                String rex = fileName.substring(fileName.lastIndexOf("."));
                String dirName = "";//通过后缀确定上传目录名称
                StringBuffer newName = new StringBuffer();
                newName.append(UUID.randomUUID()).append(rex);
                map = aliyunOssUtil.uploadFileOSS(file, dirName, fileName);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }
}