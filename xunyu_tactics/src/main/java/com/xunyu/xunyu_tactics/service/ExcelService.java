package com.xunyu.xunyu_tactics.service;


import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.model.user.UserModel;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xym
 * @description excel相关service
 * @date 2018/5/2 17:42
 */
public interface ExcelService {

    /**
     * 根据http请求获得workbook对象 和 文件类型
     * @param request
     * @return map 装有WorkBook对象和文件类型fileType的map
     * @throws Exception
     */
    Map getWorkBook(HttpServletRequest request) throws Exception;
}