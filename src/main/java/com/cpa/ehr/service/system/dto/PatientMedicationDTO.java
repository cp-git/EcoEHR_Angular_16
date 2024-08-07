package com.cpa.ehr.service.system.dto;

import java.util.Date;


public class PatientMedicationDTO {

	private Long patientMedicationId;

	private Long patientId;
	
	private Long encounterId;

	private Long medicationId;

	private String frequency;

	private Date startDate;

	private Long medicationDuration;

	private Date endDate;

	private Long refillCount;

	private String icd10Code;

	private String medicationName;

	private String isActiveMedication;

	private String discontinueReason;

	private Boolean activeFlag;

	private String createdBy;

	private Date createdDate;

	private String lastUpdatedBy;

	private Date lastUpdatedDate;

	private Date discontinuedDate;

	public Long getPatientMedicationId() {
		return patientMedicationId;
	}

	public void setPatientMedicationId(Long patientMedicationId) {
		this.patientMedicationId = patientMedicationId;
	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getMedicationDuration() {
		return medicationDuration;
	}

	public void setMedicationDuration(Long medicationDuration) {
		this.medicationDuration = medicationDuration;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getRefillCount() {
		return refillCount;
	}

	public void setRefillCount(Long refillCount) {
		this.refillCount = refillCount;
	}

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getIsActiveMedication() {
		return isActiveMedication;
	}

	public void setIsActiveMedication(String isActiveMedication) {
		this.isActiveMedication = isActiveMedication;
	}

	public String getDiscontinueReason() {
		return discontinueReason;
	}

	public void setDiscontinueReason(String discontinueReason) {
		this.discontinueReason = discontinueReason;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "PatientMedicationDTO [patientMedicationId=" + patientMedicationId + ", patientId=" + patientId
				+ ", encounterId=" + encounterId + ", medicationId=" + medicationId + ", frequency=" + frequency
				+ ", startDate=" + startDate + ", medicationDuration=" + medicationDuration + ", endDate=" + endDate
				+ ", refillCount=" + refillCount + ", icd10Code=" + icd10Code + ", medicationName=" + medicationName
				+ ", isActiveMedication=" + isActiveMedication + ", discontinueReason=" + discontinueReason
				+ ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", discontinuedDate="
				+ discontinuedDate + "]";
	}

	


	

	
}
