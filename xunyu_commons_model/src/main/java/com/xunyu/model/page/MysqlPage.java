package com.xunyu.model.page;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/12 15:02
 **/
public class MysqlPage implements Serializable {

    private static final long serialVersionUID = -757240688077721458L;
    /**
     * 从第几条开始
     */
    private long offset = 0;
    /**
     * 显示几条
     */
    private int limit = 10;

    /**
     * 当前页
     *
     * @return
     */
    private int currPage;

    public long getStartRows() {

        return (currPage - 1) * limit;
    }

    public long getEndRows() {

        return currPage * limit;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
