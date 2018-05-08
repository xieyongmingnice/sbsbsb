package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description sp免审模板配置 实体类
 * @date 2018/5/8 18:35
 */
public class SpTemplateConfig implements Serializable {
    private static final long serialVersionUID = 3467412867965413038L;
    /**
     *   主键
     */
    private Integer spTemplateConfigId;

    /**
     *   协议类型
     */
    private Integer agreementType;

    /**
     *   接出网关名称
     */
    private String netGateName;

    /**
     *   企业名称
     */
    private String companyName;

    /**
     *   企业代码
     */
    private Integer companyCode;

    /**
     *   接入码
     */
    private String accessCode;

    /**
     *   报备总数
     */
    private Integer reportCount;

    /**
     *   报备内容
     *
     */
    private String reportContent;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     *   修改时间
     */
    private Date updateTime;

    /**
     *   创建时间
     */
    private Date createTime;


    /**
     * This method returns the value of the database column tbl_sp_template_config.sp_template_config_id
     *
     * @return the value of tbl_sp_template_config.sp_template_config_id
     */
    public Integer getSpTemplateConfigId() {
        return spTemplateConfigId;
    }

    /**
     */
    public SpTemplateConfig withSpTemplateConfigId(Integer spTemplateConfigId) {
        this.setSpTemplateConfigId(spTemplateConfigId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.sp_template_config_id
     *
     * @param spTemplateConfigId the value for tbl_sp_template_config.sp_template_config_id
     */
    public void setSpTemplateConfigId(Integer spTemplateConfigId) {
        this.spTemplateConfigId = spTemplateConfigId;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.agreement_type
     *
     * @return the value of tbl_sp_template_config.agreement_type
     */
    public Integer getAgreementType() {
        return agreementType;
    }

    /**
     */
    public SpTemplateConfig withAgreementType(Integer agreementType) {
        this.setAgreementType(agreementType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.agreement_type
     *
     * @param agreementType the value for tbl_sp_template_config.agreement_type
     */
    public void setAgreementType(Integer agreementType) {
        this.agreementType = agreementType;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.net_gate_name
     *
     * @return the value of tbl_sp_template_config.net_gate_name
     */
    public String getNetGateName() {
        return netGateName;
    }

    /**
     */
    public SpTemplateConfig withNetGateName(String netGateName) {
        this.setNetGateName(netGateName);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.net_gate_name
     *
     * @param netGateName the value for tbl_sp_template_config.net_gate_name
     */
    public void setNetGateName(String netGateName) {
        this.netGateName = netGateName;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.company_name
     *
     * @return the value of tbl_sp_template_config.company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     */
    public SpTemplateConfig withCompanyName(String companyName) {
        this.setCompanyName(companyName);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.company_name
     *
     * @param companyName the value for tbl_sp_template_config.company_name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.company_code
     *
     * @return the value of tbl_sp_template_config.company_code
     */
    public Integer getCompanyCode() {
        return companyCode;
    }

    /**
     */
    public SpTemplateConfig withCompanyCode(Integer companyCode) {
        this.setCompanyCode(companyCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.company_code
     *
     * @param companyCode the value for tbl_sp_template_config.company_code
     */
    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.access_code
     *
     * @return the value of tbl_sp_template_config.access_code
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     */
    public SpTemplateConfig withAccessCode(String accessCode) {
        this.setAccessCode(accessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.access_code
     *
     * @param accessCode the value for tbl_sp_template_config.access_code
     */
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.report_count
     *
     * @return the value of tbl_sp_template_config.report_count
     */
    public Integer getReportCount() {
        return reportCount;
    }

    /**
     */
    public SpTemplateConfig withReportCount(Integer reportCount) {
        this.setReportCount(reportCount);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.report_count
     *
     * @param reportCount the value for tbl_sp_template_config.report_count
     */
    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.report_content
     *
     * @return the value of tbl_sp_template_config.report_content
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     */
    public SpTemplateConfig withReportContent(String reportContent) {
        this.setReportContent(reportContent);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.report_content
     *
     * @param reportContent the value for tbl_sp_template_config.report_content
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.isabled
     *
     * @return the value of tbl_sp_template_config.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public SpTemplateConfig withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.isabled
     *
     * @param isabled the value for tbl_sp_template_config.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.update_time
     *
     * @return the value of tbl_sp_template_config.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     */
    public SpTemplateConfig withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.update_time
     *
     * @param updateTime the value for tbl_sp_template_config.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column tbl_sp_template_config.create_time
     *
     * @return the value of tbl_sp_template_config.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     */
    public SpTemplateConfig withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_template_config.create_time
     *
     * @param createTime the value for tbl_sp_template_config.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spTemplateConfigId=").append(spTemplateConfigId);
        sb.append(", agreementType=").append(agreementType);
        sb.append(", netGateName=").append(netGateName);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", accessCode=").append(accessCode);
        sb.append(", reportCount=").append(reportCount);
        sb.append(", reportContent=").append(reportContent);
        sb.append(", isabled=").append(isabled);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    /**
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
        SpTemplateConfig other = (SpTemplateConfig) that;
        return (this.getSpTemplateConfigId() == null ? other.getSpTemplateConfigId() == null : this.getSpTemplateConfigId().equals(other.getSpTemplateConfigId()))
            && (this.getAgreementType() == null ? other.getAgreementType() == null : this.getAgreementType().equals(other.getAgreementType()))
            && (this.getNetGateName() == null ? other.getNetGateName() == null : this.getNetGateName().equals(other.getNetGateName()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getAccessCode() == null ? other.getAccessCode() == null : this.getAccessCode().equals(other.getAccessCode()))
            && (this.getReportCount() == null ? other.getReportCount() == null : this.getReportCount().equals(other.getReportCount()))
            && (this.getReportContent() == null ? other.getReportContent() == null : this.getReportContent().equals(other.getReportContent()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpTemplateConfigId() == null) ? 0 : getSpTemplateConfigId().hashCode());
        result = prime * result + ((getAgreementType() == null) ? 0 : getAgreementType().hashCode());
        result = prime * result + ((getNetGateName() == null) ? 0 : getNetGateName().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getAccessCode() == null) ? 0 : getAccessCode().hashCode());
        result = prime * result + ((getReportCount() == null) ? 0 : getReportCount().hashCode());
        result = prime * result + ((getReportContent() == null) ? 0 : getReportContent().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}