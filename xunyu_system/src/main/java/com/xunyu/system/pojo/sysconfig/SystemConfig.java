package com.xunyu.system.pojo.sysconfig;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/4/26 15:53
 * 系统全局配置
 **/
public class SystemConfig extends UserModel {

    private Long sysId;//主键
    private Integer isabled;//1未删除  0删除
    private Date createTime;//创建时间
    private String sysIp;//系统IP配置
    private Integer sysReturn;//是否自动返还 1全部不返还 2按用户配置  3全部返还
    private Integer sysOpen;//余额放开IP查询 1全部固定IP 2按用户配置 3全部放开IP
    private String yidongPort;//移动端口配置
    private String liantongPort;//联通端口配置
    private String dianxinPort;//电信端口配置
    private Integer upKeyword;//批量修改关键字 1不修改  2全部启用 3全部停用
    private Integer upWhite;//批量修改白名单 1不修改  2全部启用 3全部停用
    private Integer upBlack;//批量修改黑名单 1不修改  2全部启用 3全部停用
    private Integer sysListen;//网关告警监控是否启用 1启用 2不启用
    private String  statisTime;//网关告警监控统计时间
    private Integer sysWProportion;//网关告警监控未知量比例
    private Integer sysFProportion;//网关告警监控失败量比例
    private Integer sysSProportion;//网关告警监控成功率告警
    private Integer sysRemind;//是否启用余额短信提醒 1按用户配置  2全部启用 3全部停用

    private Integer reNum;//余额提醒条数
    private String reContent;//余额提醒内容
    private String reInterval;//余额提醒间隔
    private String reDate;//余额提醒时间
    private String reSp;//余额提醒发送SP代码
    private Long userId;//当前登录用户id

    public String getStatisTime() {
        return statisTime;
    }

    public void setStatisTime(String statisTime) {
        this.statisTime = statisTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getReNum() {
        return reNum;
    }

    public void setReNum(Integer reNum) {
        this.reNum = reNum;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public String getReInterval() {
        return reInterval;
    }

    public void setReInterval(String reInterval) {
        this.reInterval = reInterval;
    }

    public String getReDate() {
        return reDate;
    }

    public void setReDate(String reDate) {
        this.reDate = reDate;
    }

    public String getReSp() {
        return reSp;
    }

    public void setReSp(String reSp) {
        this.reSp = reSp;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
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

    public String getSysIp() {
        return sysIp;
    }

    public void setSysIp(String sysIp) {
        this.sysIp = sysIp;
    }

    public Integer getSysReturn() {
        return sysReturn;
    }

    public void setSysReturn(Integer sysReturn) {
        this.sysReturn = sysReturn;
    }

    public Integer getSysOpen() {
        return sysOpen;
    }

    public void setSysOpen(Integer sysOpen) {
        this.sysOpen = sysOpen;
    }

    public String getYidongPort() {
        return yidongPort;
    }

    public void setYidongPort(String yidongPort) {
        this.yidongPort = yidongPort;
    }

    public String getLiantongPort() {
        return liantongPort;
    }

    public void setLiantongPort(String liantongPort) {
        this.liantongPort = liantongPort;
    }

    public String getDianxinPort() {
        return dianxinPort;
    }

    public void setDianxinPort(String dianxinPort) {
        this.dianxinPort = dianxinPort;
    }

    public Integer getUpKeyword() {
        return upKeyword;
    }

    public void setUpKeyword(Integer upKeyword) {
        this.upKeyword = upKeyword;
    }

    public Integer getUpWhite() {
        return upWhite;
    }

    public void setUpWhite(Integer upWhite) {
        this.upWhite = upWhite;
    }

    public Integer getUpBlack() {
        return upBlack;
    }

    public void setUpBlack(Integer upBlack) {
        this.upBlack = upBlack;
    }

    public Integer getSysListen() {
        return sysListen;
    }

    public void setSysListen(Integer sysListen) {
        this.sysListen = sysListen;
    }

    public Integer getSysWProportion() {
        return sysWProportion;
    }

    public void setSysWProportion(Integer sysWProportion) {
        this.sysWProportion = sysWProportion;
    }

    public Integer getSysFProportion() {
        return sysFProportion;
    }

    public void setSysFProportion(Integer sysFProportion) {
        this.sysFProportion = sysFProportion;
    }

    public Integer getSysSProportion() {
        return sysSProportion;
    }

    public void setSysSProportion(Integer sysSProportion) {
        this.sysSProportion = sysSProportion;
    }

    public Integer getSysRemind() {
        return sysRemind;
    }

    public void setSysRemind(Integer sysRemind) {
        this.sysRemind = sysRemind;
    }
}
