package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 系统白名单关键字 请求参数实体类
 * @date 2018/5/8 15:10
 */
public class SysWhitelistKeywordModel extends UserModel {
    private static final long serialVersionUID = 8265778097666593397L;

    /**
     *   主键
     */
    private Integer sysWhitelistKeywordId;

    /**
     *   系统白名单关键字
     */
    private String keyword;

    /**
     *   1：可用，0：不可用
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 批量操作时用的数据集合(关键词)
     */
    private List<String> idList;

    /**
     * 检查内容关键词
     */
    private String content;

    public Integer getSysWhitelistKeywordId() {
        return sysWhitelistKeywordId;
    }

    public void setSysWhitelistKeywordId(Integer sysWhitelistKeywordId) {
        this.sysWhitelistKeywordId = sysWhitelistKeywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
