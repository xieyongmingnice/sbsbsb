package com.xunyu.xunyu_tactics.constant;

/**
 * @author xym
 * @description 常量类
 * @date 2018/5/2 15:06
 */
public interface TacticsConstants {


    /**
     * 运营商type
     */
    interface CarrierType{
        /**
         * 移动
         */
        int CHINA_MOBILE = 1;
        /**
         * 联通
         */
        int CHINA_UNICOM = 2;
        /**
         * 电信
         */
        int CHINA_TELECOM = 3;
    }

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

    /**
     * 文件名后缀
     */
    interface Suffix{
        /**
         * xls
         */
        String XLS = "xls";

        /**
         * xlsx
         */
        String XLSX = "xlsx";
    }

    /**
     * 黑名单来源
     */
    interface BlacklistSource{
        /**
         * 回复加黑
         */
        int REPLY = 1;

        /**
         * 手动添加
         */
        int MANNUAL = 2;

        /**
         * 其他收集
         */
        int OTHER = 3;
    }

    /**
     * 成功、失败
     */
    interface CompleteStatus{
        /**
         * 成功
         */
        String SUCCESS = "SUCCESS";
        /**
         * 失败
         */
        String FAILED = "FAILED";
    }

    /**
     * 正则表达式
     */
    interface Regex{

        /**
         * 手机号
         */
        String PHONE_NUMBER = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    }

    /**
     * 分隔符
     */
    interface Separator{
        /**
         * 逗号
         */
        String COMMA = ",";
    }
}
