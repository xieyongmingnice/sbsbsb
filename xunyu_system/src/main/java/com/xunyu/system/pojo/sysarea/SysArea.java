package com.xunyu.system.pojo.sysarea;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/7 16:47
 **/
public class SysArea extends UserModel {

    private Long areaId;//主键
    private Integer isabled;// 1未删除  0已删除
    private Date createTime;//创建时间
    private String areaCode;//区域编码
    private String areaName;//区域名称
    private String pArea;//父级区域
    private Integer areaType;//区域类型 1省/直辖市 2市 、3保留
    private String areaAbbre;//区域简称
    private String areaPinyin;//区域拼音
    private String areaZipcode;//区域邮编
    private String areaGrade;//区域等级
    private String areaOrder;//区域排序
    private String areaIndex;//区域索引
    private Integer areaStatus;//是否是直辖市  1是 2否
    private String areaText;//区域描述
    private Double price;//短信单价
    private Integer cusAreaCount;//客户数

    public Integer getCusAreaCount() {
        return cusAreaCount;
    }

    public void setCusAreaCount(Integer cusAreaCount) {
        this.cusAreaCount = cusAreaCount;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getpArea() {
        return pArea;
    }

    public void setpArea(String pArea) {
        this.pArea = pArea;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getAreaAbbre() {
        return areaAbbre;
    }

    public void setAreaAbbre(String areaAbbre) {
        this.areaAbbre = areaAbbre;
    }

    public String getAreaPinyin() {
        return areaPinyin;
    }

    public void setAreaPinyin(String areaPinyin) {
        this.areaPinyin = areaPinyin;
    }

    public String getAreaZipcode() {
        return areaZipcode;
    }

    public void setAreaZipcode(String areaZipcode) {
        this.areaZipcode = areaZipcode;
    }

    public String getAreaGrade() {
        return areaGrade;
    }

    public void setAreaGrade(String areaGrade) {
        this.areaGrade = areaGrade;
    }

    public String getAreaOrder() {
        return areaOrder;
    }

    public void setAreaOrder(String areaOrder) {
        this.areaOrder = areaOrder;
    }

    public String getAreaIndex() {
        return areaIndex;
    }

    public void setAreaIndex(String areaIndex) {
        this.areaIndex = areaIndex;
    }

    public Integer getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(Integer areaStatus) {
        this.areaStatus = areaStatus;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
