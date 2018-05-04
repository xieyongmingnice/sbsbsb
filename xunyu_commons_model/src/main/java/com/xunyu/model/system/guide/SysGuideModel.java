package com.xunyu.model.system.guide;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/3 11:50
 **/
public class SysGuideModel extends UserModel {

    private Long guideId;//主键
    private String guideName;//名称
    private String guidePath;//文件地址
    private String fileType;//文件类型
    private Integer isabled;//1未删除  0删除
    private Date createTime;//创建时间
    private String guideIds;

    public String getGuideIds() {
        return guideIds;
    }

    public void setGuideIds(String guideIds) {
        this.guideIds = guideIds;
    }

    public Long getGuideId() {
        return guideId;
    }

    public void setGuideId(Long guideId) {
        this.guideId = guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuidePath() {
        return guidePath;
    }

    public void setGuidePath(String guidePath) {
        this.guidePath = guidePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
