package com.cpa.ehr.service.admin.dto;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class MasterLookupDTO {
	
	private Long lookupId; 
	
	@NotBlank
	@Size(max = 100)
	private String lookupType;
	
	@NotBlank
	@Size(max = 500)
	private String lookupCode;
	
	@NotBlank
	@Size(max = 500)
	private String lookupDesc;
	
	private Boolean activeFlag;
	
	private Long organizationId;
	
	private Date createdDate;
	
	@Size(max = 100)
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	@Size(max = 100)
	private String lastUpdatedBy;

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getLookupDesc() {
		return lookupDesc;
	}

	public void setLookupDesc(String lookupDesc) {
		this.lookupDesc = lookupDesc;
	}


	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
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
		return "MasterLookupDTO [lookupId=" + lookupId + ", lookupType=" + lookupType + ", lookupCode=" + lookupCode
				+ ", lookupDesc=" + lookupDesc + ", activeFlag=" + activeFlag + ", organizationId=" + organizationId
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}
}
