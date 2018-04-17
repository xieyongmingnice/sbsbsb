package com.commons.core.message;


/**
 * TODO
 *
 * @author
 */
public class FailMessage extends Message {
    private Object data;
    private String errMsg;

    public FailMessage() {
        super(Message.FAILURE);
    }

    public FailMessage(int code) {
        super(code);
    }

    public FailMessage(String errorMsg) {
        super(Message.FAILURE);
        this.errMsg = errorMsg;
    }

    public FailMessage(int code, String errorMsg) {
        super(code);
        this.errMsg = errorMsg;
    }


    public FailMessage(ResultTypeEnum resultType) {
        super(resultType.getFlag());
        super.flag = resultType.getFlag();
        this.errMsg = resultType.getRemark();
    }

    public void setResultType(ResultTypeEnum resultType) {
        super.flag = resultType.getFlag();
        this.errMsg = resultType.getRemark();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
