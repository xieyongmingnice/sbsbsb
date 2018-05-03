package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class SysRedlist implements Serializable {

    private static final long serialVersionUID = 1872767265019716100L;
    /**
     * 流水id
     */
    private Integer sysRedlistId;

    /**
     *   手机号
     */
    private String phoneNumber;

    /**
     *   红名单来源
     */
    private Integer redlistSource;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   备注
     */
    private String remarks;

    /**
     *   1：可用，0：不可用
     */

    private Integer isabled;

    /**
     * This method returns the value of the database column tbl_sys_redlist.sys_redlist_id
     *
     * @return the value of tbl_sys_redlist.sys_redlist_id
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public Integer getSysRedlistId() {
        return sysRedlistId;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public SysRedlist withSysRedlistId(Integer sysRedlistId) {
        this.setSysRedlistId(sysRedlistId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_redlist.sys_redlist_id
     *
     * @param sysRedlistId the value for tbl_sys_redlist.sys_redlist_id
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public void setSysRedlistId(Integer sysRedlistId) {
        this.sysRedlistId = sysRedlistId;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.phone_number
     *
     * @return the value of tbl_sys_redlist.phone_number
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public SysRedlist withPhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_redlist.phone_number
     *
     * @param phoneNumber the value for tbl_sys_redlist.phone_number
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.redlist_source
     *
     * @return the value of tbl_sys_redlist.redlist_source
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public Integer getRedlistSource() {
        return redlistSource;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public SysRedlist withRedlistSource(Integer redlistSource) {
        this.setRedlistSource(redlistSource);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_redlist.redlist_source
     *
     * @param redlistSource the value for tbl_sys_redlist.redlist_source
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public void setRedlistSource(Integer redlistSource) {
        this.redlistSource = redlistSource;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.join_time
     *
     * @return the value of tbl_sys_redlist.join_time
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public SysRedlist withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_redlist.join_time
     *
     * @param joinTime the value for tbl_sys_redlist.join_time
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.remarks
     *
     * @return the value of tbl_sys_redlist.remarks
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public SysRedlist withRemarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_redlist.remarks
     *
     * @param remarks the value for tbl_sys_redlist.remarks
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.isabled
     *
     * @return the value of tbl_sys_redlist.isabled
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public SysRedlist withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_redlist.isabled
     *
     * @param isabled the value for tbl_sys_redlist.isabled
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysRedlistId=").append(sysRedlistId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", redlistSource=").append(redlistSource);
        sb.append(", joinTime=").append(joinTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", isabled=").append(isabled);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysRedlist other = (SysRedlist) that;
        return (this.getSysRedlistId() == null ? other.getSysRedlistId() == null : this.getSysRedlistId().equals(other.getSysRedlistId()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getRedlistSource() == null ? other.getRedlistSource() == null : this.getRedlistSource().equals(other.getRedlistSource()))
            && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()));
    }

    /**
     *
     * @mbg.generated Wed May 02 17:00:55 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSysRedlistId() == null) ? 0 : getSysRedlistId().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getRedlistSource() == null) ? 0 : getRedlistSource().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        return result;
    }
}