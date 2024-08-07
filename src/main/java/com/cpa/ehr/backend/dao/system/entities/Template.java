package com.cpa.ehr.backend.dao.system.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="template")
public class Template {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "template_template_id_seq", initialValue=1, allocationSize =1)
	@Column(name="template_id", nullable = false)
	private Long templateId;
	
	@Column(name="sys_id")
	private Long systemId;
	
	@Column(name="template_name")
	private String templateName;
	
	@Lob
	@Column(name="template_desc")
	private byte[] templateDesc;
	
	@Column(name="version")
	private Long version;
	
	@Column(name="active_flag", length = 1,nullable = false)
	private String activeFlag;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;

	@Column(name="isEdited")
	private String isEdited;
	
	


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

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
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
		return "Template [templateId=" + templateId + ", systemId=" + systemId + ", templateName=" + templateName
				+ ", templateDesc=" + Arrays.toString(templateDesc) + ", version=" + version + ", activeFlag="
				+ activeFlag + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", isEdited=" + isEdited + "]";
	}

}