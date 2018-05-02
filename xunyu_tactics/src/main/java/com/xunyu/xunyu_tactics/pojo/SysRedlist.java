package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 系统红名单 实体类
 * @date 2018/4/28 14:18
 */
public class SysRedlist  implements Serializable {
    private static final long serialVersionUID = 8401033822587064250L;
    /**
     * id
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
     * This method returns the value of the database column tbl_sys_redlist.sys_redlist_id
     *
     * @return the value of tbl_sys_redlist.sys_redlist_id
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public Integer getSysRedlistId() {
        return sysRedlistId;
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public void setSysRedlistId(Integer sysRedlistId) {
        this.sysRedlistId = sysRedlistId;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.phone_number
     *
     * @return the value of tbl_sys_redlist.phone_number
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.redlist_source
     *
     * @return the value of tbl_sys_redlist.redlist_source
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public Integer getRedlistSource() {
        return redlistSource;
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public void setRedlistSource(Integer redlistSource) {
        this.redlistSource = redlistSource;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.join_time
     *
     * @return the value of tbl_sys_redlist.join_time
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method returns the value of the database column tbl_sys_redlist.remarks
     *
     * @return the value of tbl_sys_redlist.remarks
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    /**
     *
     * @mbg.generated Sat Apr 28 14:14:09 CST 2018
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
        return result;
    }
}