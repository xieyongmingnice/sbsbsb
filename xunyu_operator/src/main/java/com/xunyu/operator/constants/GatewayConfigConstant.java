package com.xunyu.operator.constants;

/**
 * @author xym
 * @description 常量类
 * @date 2018/6/19 13:58
 */
public interface GatewayConfigConstant {

    /**
     * 启用状态
     */
    interface UsedStatus{
        /**
         * 启用
         */
        int USED = 1;
        /**
         * 停用
         */
        int STOP_USING = 0;
        /**
         * 废弃
         */
        int ABANDONED = 2;
    }

    /**
     * 接入类型
     */
    interface AccessType{
        /**
         * 网关直连
         */
        int GATEWAY_STRAIGHT = 1;

        /**
         * 网关分流
         */
        int GATEWAY_SHUNT = 2;
    }

}
