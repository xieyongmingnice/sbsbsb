package com.commons.core.message;

import java.io.Serializable;

/**
 * @param <T>
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 2229542356930016617L;
    private String code;//200 成功,400 失败410，403没有登录授权等， 5xx
    private String message;//失败原因
    private T res;
    private Long total; //总数(废弃)
    private Integer totalRows; //总条数

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }
}
