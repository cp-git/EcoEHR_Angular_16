package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "system")
public class Systems {

	@Id
	@Column(name = "sys_id", nullable = false)
	private Long systemId;

	@Column(name = "sys_type", length = 50)
	private String systemType;

	@Column(name = "sys_code", length = 100)
	private String systemCode;

	@Column(name = "sys_desc")
	private String systemDesc;

	@Column(name = "sys_order")
	private Integer systemOrder;

	@Column(name = "question_group_cnt")
	private Integer questionGroupCount;

	@Column(name = "active_flag", nullable = false, length = 1)
	private Character activeFlag;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

	@Column(name = "last_updated_by", length = 100)
	private String lastUpdatedBy;

	@Column(name = "external_links", length = 255)
	private String externalLinks;

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getSystemDesc() {
		return systemDesc;
	}

	public void setSystemDesc(String systemDesc) {
		this.systemDesc = systemDesc;
	}

	public Integer getSystemOrder() {
		return systemOrder;
	}

	public void setSystemOrder(Integer systemOrder) {
		this.systemOrder = systemOrder;
	}

	public Integer getQuestionGroupCount() {
		return questionGroupCount;
	}

	public void setQuestionGroupCount(Integer questionGroupCount) {
		this.questionGroupCount = questionGroupCount;
	}

	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(String externalLinks) {
		this.externalLinks = externalLinks;
	}

	@Override
	public String toString() {
		return "Systems [systemId=" + systemId + ", systemType=" + systemType + ", systemCode=" + systemCode
				+ ", systemDesc=" + systemDesc + ", systemOrder=" + systemOrder + ", questionGroupCount="
				+ questionGroupCount + ", activeFlag=" + activeFlag + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", externalLinks=" + externalLinks + "]";
	}

}