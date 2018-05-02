package com.xunyu.system.service.errcode;

import com.xunyu.system.pojo.errcode.ErrorCode;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/2 16:02
 **/
public interface ErrorCodeService {

    /**
     * 添加
     */
    int addErrCodeConfig(ErrorCode ec);

    /**
     * 修改
     */
    int updateErrCodeConfig(ErrorCode ec);

    /**
     * 删除
     */
    int delErrCodeConfig(String errIds);

    /**
     * 详情
     */
    ErrorCode getErrCodeConfigDetail(Map<String,Object> map);

    /**
     * 列表
     */
    int errCodeConfigCount(Map<String,Object> map);
    List<ErrorCode> errCodeConfigList(Map<String,Object> map);
}
