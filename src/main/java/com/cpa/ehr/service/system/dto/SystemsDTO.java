package com.cpa.ehr.service.system.dto;

import java.util.Date;

public class SystemsDTO{
	
	private Long systemId;
	
	private String systemType;
	
	private String systemCode;
	
	private String systemDesc;
	
	private Integer systemOrder;
	
	private Integer questionGroupCount;
	
	private Character activeFlag;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	private String lastUpdatedBy;
	
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
		return "SystemsDTO [systemId=" + systemId + ", systemType=" + systemType + ", systemCode=" + systemCode
				+ ", systemDesc=" + systemDesc + ", systemOrder=" + systemOrder + ", questionGroupCount="
				+ questionGroupCount + ", activeFlag=" + activeFlag + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", externalLinks=" + externalLinks + "]";
	}
}
