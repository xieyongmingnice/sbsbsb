package com.commons.core.message;

/**
 * @author
 */
public enum ResultTypeEnum {

    SUCCESS(1, "操作成功"),
    SYS_ERR(-1, "系统异常"),
    PARAM_IS_ERROR(11000, "参数错误"),
    TEL_ERR(11001, "手机号不合法"),
    IMAGE_IS_EMPTY(11006, "图片不能为空"),
    IMAGE_EXCEED_LIMIT(11007, "图片大小超过限制"),
    FILE_IS_EMPTY(11008, "文件不能为空"),
    FILE_EXCEED_LIMIT(11009, "文件大小超过限制"),
    FILE_NOT_EXIST(11010, "文件不存在"),

    USER_NAME_ERR(11002, "用户不合法"),
    USER_NOT_LOGIN(12001, "用户未登陆"),
    USER_IS_VISITOR(12002, "当前用户是游客，没有操作权限"),
    USER_SESSION_TIMEOUT(12003, "会话超时"),
    USER_OLD_PASSWORD_ERROR(12004, "原始密码错误"),
    USER_NOT_EXIST(12005, "用户不存在"),
    TOKEN_TIMEOUT(12006, "TOKEN失效，请从新登录"),
    USER_IS_LOCK(12007, "用户被禁用，如有疑问，请联系客服"),
    USER_PASSWORD_ERROR(12008, "用户名密码错误"),
    DATA_NOT_EXIST(12009, "没有找到数据"),;

    ResultTypeEnum(Integer flag, String remark) {
        this.flag = flag;
        this.remark = remark;
    }

    private Integer flag;

    private String remark;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
