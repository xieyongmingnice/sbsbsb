package com.xunyu.xunyu_tactics.service.impl;

import com.google.common.collect.Maps;
import com.xunyu.xunyu_tactics.service.FileService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xym
 * @description Excel service实现
 * @date 2018/5/2 17:54
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public Map getWorkBook(HttpServletRequest request) throws Exception {
        Map map = Maps.newHashMap();

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
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                Workbook workbook = WorkbookFactory.create(file.getInputStream());
                map.put("workbook", workbook);
                map.put("filetype", fileType);
            }
        }
        return map;
    }
}
