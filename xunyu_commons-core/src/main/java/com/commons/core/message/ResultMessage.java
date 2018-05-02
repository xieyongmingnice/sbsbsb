package com.commons.core.message;

/**
 * @author xym
 * @description 结果集消息
 * @date 2018/4/24 11:07
 */
public interface ResultMessage {

    /**
     * 返回信息
     */
    interface Message{

        String UN_LOGIN = "用户未登录，请先登录";

        String SUCCESS = "操作成功";

        String ERROR = "服务器异常";

        String PRAMA_LOSS = "必要参数缺失";

        String NO_VALUE = "结果集为空";

        String FAILED = "操作失败";
    }

    /**
     * 返回码
     */
    interface Code{

        String SUCCESS = "200";

        String NOT_FOUND = "404";

        String ERROR = "500";

        String USER_EXIST = "412";

        String PRAMA_LOSS = "413";

        String FAILED = "414";
    }

}
