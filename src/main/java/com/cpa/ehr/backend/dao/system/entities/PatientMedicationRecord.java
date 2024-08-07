package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cpa.ehr.converters.StringCryptoConverter;

@Entity
@Table(name="medication_history_vw")
public class PatientMedicationRecord {
	
	@Id
	@Column(name="patient_medication_id", nullable = false)
	private Long patientMedicationId;
	
	@Column(name="patient_id")
	private Long patientId;
	
	@Column(name="frequency")
	private String frequency;
	
	@Column(name="icd10_code")
	private String icd10Code;
	
	@Column(name="is_active_medication")
	private String isActiveMedication;
	
	@Column(name="medication_duration")
	private Long medicationDuration;
	
	@Column(name="refill_count")
	private Long refillCount;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="discontinued_date")
	private Date discontinuedDate;
	
	@Column(name="discontinue_reason")
	private String discontinueReason;
	
	@Column(name="encounter_id")
	private Long encounterId;
	
	@Column(name="medication_id")
	private Long medicationId;
	
	@Column(name="patient_first_name")
	@Convert(converter = StringCryptoConverter.class)
	private String patientFirstName;
	
	@Column(name="patient_middle_name")
	private String patientMiddleName;
	
	@Column(name="patient_last_name")
	@Convert(converter = StringCryptoConverter.class)
	private String patientLastName;
	
	@Column(name="provider_first_name")
	private String providerFirstName;
	
	@Column(name="provider_middle_name")
	private String providerMiddleName;
	
	@Column(name="provider_last_name")
	private String providerLastName;
	
	@Column(name="clinic_loc_name")
	private String clinicLocationName;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="form")
	private String form;
	
	@Column(name="dose")
	private String dose;
	
	@Column(name="schedule")
	private String schedule;
	
	@Column(name="route")
	private String route;

	@Column(name="npi_number")
	private String npiNumber;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	public Long getPatientMedicationId() {
		return patientMedicationId;
	}

	public void setPatientMedicationId(Long patientMedicationId) {
		this.patientMedicationId = patientMedicationId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	public String getIsActiveMedication() {
		return isActiveMedication;
	}

	public void setIsActiveMedication(String isActiveMedication) {
		this.isActiveMedication = isActiveMedication;
	}

	public Long getMedicationDuration() {
		return medicationDuration;
	}

	public void setMedicationDuration(Long medicationDuration) {
		this.medicationDuration = medicationDuration;
	}

	public Long getRefillCount() {
		return refillCount;
	}

	public void setRefillCount(Long refillCount) {
		this.refillCount = refillCount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public String getDiscontinueReason() {
		return discontinueReason;
	}

	public void setDiscontinueReason(String discontinueReason) {
		this.discontinueReason = discontinueReason;
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

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientMiddleName() {
		return patientMiddleName;
	}

	public void setPatientMiddleName(String patientMiddleName) {
		this.patientMiddleName = patientMiddleName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getProviderFirstName() {
		return providerFirstName;
	}

	public void setProviderFirstName(String providerFirstName) {
		this.providerFirstName = providerFirstName;
	}

	public String getProviderMiddleName() {
		return providerMiddleName;
	}

	public void setProviderMiddleName(String providerMiddleName) {
		this.providerMiddleName = providerMiddleName;
	}

	public String getProviderLastName() {
		return providerLastName;
	}

	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}

	public String getClinicLocationName() {
		return clinicLocationName;
	}

	public void setClinicLocationName(String clinicLocationName) {
		this.clinicLocationName = clinicLocationName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
	public String getNpiNumber() {
		return npiNumber;
	}

	public void setNpiNumber(String npiNumber) {
		this.npiNumber = npiNumber;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		return "PatientMedicationRecord [patientMedicationId=" + patientMedicationId + ", patientId=" + patientId
				+ ", frequency=" + frequency + ", icd10Code=" + icd10Code + ", isActiveMedication=" + isActiveMedication
				+ ", medicationDuration=" + medicationDuration + ", refillCount=" + refillCount + ", startDate="
				+ startDate + ", endDate=" + endDate + ", discontinuedDate=" + discontinuedDate + ", discontinueReason="
				+ discontinueReason + ", encounterId=" + encounterId + ", medicationId=" + medicationId
				+ ", patientFirstName=" + patientFirstName + ", patientMiddleName=" + patientMiddleName
				+ ", patientLastName=" + patientLastName + ", providerFirstName=" + providerFirstName
				+ ", providerMiddleName=" + providerMiddleName + ", providerLastName=" + providerLastName
				+ ", clinicLocationName=" + clinicLocationName + ", productName=" + productName + ", form=" + form
				+ ", dose=" + dose + ", schedule=" + schedule + ", route=" + route + ", npiNumber=" + npiNumber
				+ ", activeFlag=" + activeFlag + "]";
	}



	

	
	
	
}
