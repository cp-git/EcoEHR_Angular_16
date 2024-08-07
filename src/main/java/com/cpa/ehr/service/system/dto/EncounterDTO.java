package com.cpa.ehr.service.system.dto;

import java.util.Date;

public class EncounterDTO {
	
	private Long encounterId;
	
	private Long patientId;
	
	private Long staffId;
	
	private Long locationId;
	
	private Long organizationId;
	
	private Date encounterDate;
	
	private String chiefCompliant;
	
	private Long emId;
	
	private Boolean activeFlag;
	
	private Long physicalExamTempId;
	
	private Long cardioExamTempId;
	
	private Long simpleNeuroExamTempId;
	
	private Long eyeExamTempId;
	
	private Long detailedExamTempId;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	private String lastUpdatedBy;
	
	private String patientUniqueCharacters;
	
	private Date completionDate;

	private String isEdited;
	


	public String getIsEdited() {
		return isEdited;
	}

	public void setIsEdited(String isEdited) {
		this.isEdited = isEdited;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Date getEncounterDate() {
		return encounterDate;
	}

	public void setEncounterDate(Date encounterDate) {
		this.encounterDate = encounterDate;
	}

	public String getChiefCompliant() {
		return chiefCompliant;
	}

	public void setChiefCompliant(String chiefCompliant) {
		this.chiefCompliant = chiefCompliant;
	}

	public Long getEmId() {
		return emId;
	}

	public void setEmId(Long emId) {
		this.emId = emId;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Long getPhysicalExamTempId() {
		return physicalExamTempId;
	}

	public void setPhysicalExamTempId(Long physicalExamTempId) {
		this.physicalExamTempId = physicalExamTempId;
	}

	public Long getCardioExamTempId() {
		return cardioExamTempId;
	}

	public void setCardioExamTempId(Long cardioExamTempId) {
		this.cardioExamTempId = cardioExamTempId;
	}

	public Long getSimpleNeuroExamTempId() {
		return simpleNeuroExamTempId;
	}

	public void setSimpleNeuroExamTempId(Long simpleNeuroExamTempId) {
		this.simpleNeuroExamTempId = simpleNeuroExamTempId;
	}

	public Long getEyeExamTempId() {
		return eyeExamTempId;
	}

	public void setEyeExamTempId(Long eyeExamTempId) {
		this.eyeExamTempId = eyeExamTempId;
	}

	public Long getDetailedExamTempId() {
		return detailedExamTempId;
	}

	public void setDetailedExamTempId(Long detailedExamTempId) {
		this.detailedExamTempId = detailedExamTempId;
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

	public String getPatientUniqueCharacters() {
		return patientUniqueCharacters;
	}

	public void setPatientUniqueCharacters(String patientUniqueCharacters) {
		this.patientUniqueCharacters = patientUniqueCharacters;
	}

	@Override
	public String toString() {
		return "EncounterDTO [encounterId=" + encounterId + ", patientId=" + patientId + ", staffId=" + staffId
				+ ", locationId=" + locationId + ", organizationId=" + organizationId + ", encounterDate="
				+ encounterDate + ", chiefCompliant=" + chiefCompliant + ", emId=" + emId + ", activeFlag=" + activeFlag
				+ ", physicalExamTempId=" + physicalExamTempId + ", cardioExamTempId=" + cardioExamTempId
				+ ", simpleNeuroExamTempId=" + simpleNeuroExamTempId + ", eyeExamTempId=" + eyeExamTempId
				+ ", detailedExamTempId=" + detailedExamTempId + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", patientUniqueCharacters=" + patientUniqueCharacters + ", completionDate=" + completionDate
				+ ", isEdited=" + isEdited + "]";
	}

	
	
	
}