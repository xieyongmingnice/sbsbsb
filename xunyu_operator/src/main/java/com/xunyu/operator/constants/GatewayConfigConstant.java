package com.xunyu.operator.constants;

/**
 * @author xym
 * @description 常量类
 * @date 2018/6/19 13:58
 */
public interface GatewayConfigConstant {


    /**
     * 运营商
     */
    interface Carrier{
        /**
         * 移动
         */
        int CMPP = 1;
        /**
         * 联通
         */
        int SGIP = 2;
        /**
         * 电信
         */
        int SMGP = 3;
    }

    /**
     * 运营商
     */
    interface CarrierName{
        /**
         * 移动
         */
        String CMPP = "移动";
        /**
         * 联通
         */
        String SGIP = "联通";
        /**
         * 电信
         */
        String SMGP = "电信";
    }
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
