package com.commons.core.message;


/**
 * TODO
 */
public class SuccessMessage extends Message {

    private Object data;

    private String successMsg = "操作成功";

    public SuccessMessage(Object data) {
        super(SUCCESS);
        this.data = data;
    }

    public SuccessMessage() {
        super(SUCCESS);
    }

    public SuccessMessage(ResultTypeEnum resultType) {
        super(resultType.getFlag());
        this.successMsg = resultType.getRemark();
    }

    public SuccessMessage(ResultTypeEnum resultType, Object data) {
        super(resultType.getFlag());
        this.successMsg = resultType.getRemark();
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }
}
