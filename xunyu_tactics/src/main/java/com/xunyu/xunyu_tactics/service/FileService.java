package com.xunyu.xunyu_tactics.service;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xym
 * @description excel相关service
 * @date 2018/5/2 17:42
 */
public interface FileService {

    /**
     * 根据http请求获得workbook对象 和 文件类型
     * @param request
     * @return map 装有WorkBook对象和文件类型fileType的map
     * @throws Exception
     */
    Map getWorkBook(HttpServletRequest request) throws Exception;
}