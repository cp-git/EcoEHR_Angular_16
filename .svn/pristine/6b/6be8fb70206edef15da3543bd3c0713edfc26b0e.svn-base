package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;

@Entity
@Table(name = "patient_medication")
public class PatientMedication {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "patient_medication_id_seq", allocationSize = 1)
	@Column(name = "patient_medication_id", nullable = false)
	private Long patientMedicationId;


	@ManyToOne
	@JoinColumn(name="patient_id", foreignKey = @ForeignKey(name = "patient_id_fkey"))
	private PatientDetails patientDetails;

	@Column(name = "encounter_id")
	private Long encounterId;

	@ManyToOne
	@JoinColumn(name="medication_id", foreignKey = @ForeignKey(name = "medication_id_fkey"))
	private Medication medication;

	@Column(name = "frequency", nullable = false)
	private String frequency;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "medication_duration", nullable = false)
	private Long medicationDuration;

	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "refill_count")
	private Long refillCount;

	@Column(name = "icd10_code", nullable = false)
	private String icd10Code;

	@Column(name = "medication_notes")
	private String medicationNotes;

	@Column(name = "is_active_medication", nullable = false, length = 1)
	private String isActiveMedication;

	@Column(name = "discontinue_reason")
	private String discontinueReason;

	@Column(name = "active_flag", nullable = false, length = 1)
	private String activeFlag;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "last_updated_by", nullable = false)
	private String lastUpdatedBy;

	@Column(name = "last_updated_date", nullable = false)
	private Date lastUpdatedDate;

	@Column(name = "discontinued_date")
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


	public String getFrequency() {
		return frequency;
	}


	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
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

	public String getMedicationNotes() {
		return medicationNotes;
	}

	public void setMedicationNotes(String medicationNotes) {
		this.medicationNotes = medicationNotes;
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

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
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

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}

	@Override
	public String toString() {
		return "PatientMedication [patientMedicationId=" + patientMedicationId + ", patientDetails=" + patientDetails
				+ ", encounterId=" + encounterId + ", medication=" + medication + ", frequency=" + frequency
				+ ", startDate=" + startDate + ", medicationDuration=" + medicationDuration + ", endDate=" + endDate
				+ ", refillCount=" + refillCount + ", icd10Code=" + icd10Code + ", medicationNotes=" + medicationNotes
				+ ", isActiveMedication=" + isActiveMedication + ", discontinueReason=" + discontinueReason
				+ ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", discontinuedDate="
				+ discontinuedDate + "]";
	}

	


}
