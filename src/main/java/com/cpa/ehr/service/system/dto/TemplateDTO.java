package com.cpa.ehr.service.system.dto;

import java.util.Arrays;
import java.util.Date;

public class TemplateDTO {
	
	private Long templateId;
	
	private Long systemId;
	
	private String templateName;
	
	private byte[] templateDesc;
	
	private Long version;
	
	private boolean activeFlag;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	private String lastUpdatedBy;
	private String  isEdited;


	public String getIsEdited() {
		return isEdited;
	}

	public void setIsEdited(String isEdited) {
		this.isEdited = isEdited;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public byte[] getTemplateDesc() {
		return templateDesc;
	}

	public void setTemplateDesc(byte[] templateDesc) {
		this.templateDesc = templateDesc;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
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

	@Override
	public String toString() {
		return "TemplateDTO [templateId=" + templateId + ", systemId=" + systemId + ", templateName=" + templateName
				+ ", templateDesc=" + Arrays.toString(templateDesc) + ", version=" + version + ", activeFlag="
				+ activeFlag + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", isEdited=" + isEdited + "]";
	}
}
