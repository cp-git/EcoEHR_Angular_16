package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="master_lookup")
public class MasterLookup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "master_lookup_id_seq", allocationSize=1)
	@Column(name="lookup_id")
	private Long lookupId; 
	
	@Size(max = 100)
	@Column(name="lookup_type", length = 100, nullable = false)
	private String lookupType;
	
	@Size(max = 500)
	@Column(name="lookup_code", length = 500, nullable = false)
	private String lookupCode;
	
	@Size(max = 500)
	@Column(name="lookup_desc", length = 500, nullable = false)
	private String lookupDesc;
	
	@Size(max = 1)
	@Column(name="active_flag", length = 1, nullable = false)
	private String activeFlag;
	
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;
	
	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	
	@Size(max = 100)
	@Column(name = "created_by", length = 100)
	private String createdBy;
	
	@Column(name = "last_updated_date", nullable = false)
	private Date lastUpdatedDate;
	
	@Size(max = 100)
	@Column(name = "last_updated_by", length = 100)
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


	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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
		return "MasterLookup [lookupId=" + lookupId + ", lookupType=" + lookupType + ", lookupCode=" + lookupCode
				+ ", lookupDesc=" + lookupDesc + ", activeFlag=" + activeFlag + ", organization=" + organization
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

}
