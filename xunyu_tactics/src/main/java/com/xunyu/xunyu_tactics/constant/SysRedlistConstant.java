package com.xunyu.xunyu_tactics.constant;

/**
 * @author xym
 * @description 常量类
 * @date 2018/5/2 15:06
 */
public interface SysRedlistConstant {

    /**
     * 系统红名单来源
     */
    interface RedlistSource{

        /**
         * 自动添加
         */
        int AUTO_ADD = 1;

        /**
         * 手动添加
         */
        int MANUAL_ADD = 2;
    }

    /**
     * 是否可用
     */
    interface Isabled{
        /**
         * 可用
         */
        int ENABLED = 1;

        /**
         * 不可用
         */
        int DISABLED = 0;
    }
}
