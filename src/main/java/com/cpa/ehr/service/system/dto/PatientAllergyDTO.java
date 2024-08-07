/*
 * Created on 2019-04-25 ( Date ISO 2019-04-25 - Time 10:19:38 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.ehr.service.system.dto;

import java.util.Date;

/**
 * Hateoas resource associated with PatientAllergy.
 * @author Somesh Biswas version 3.0.0
 */
public class PatientAllergyDTO  {

    private Long patientAllergyId;  
    private String productName;  
    private String form;  
    private String route;  
    private String dose;  
    private Boolean activeFlag;  
    private Long medicationId;  
    private Date createdDate;  
    private Date lastUpdatedDate;  
    private String createdBy;  
    private String lastUpdatedBy;  
    private Long encounterId;  
    private Long patientId;  

	// Constructor
	public PatientAllergyDTO() {
		// Needed empty constructor for serialization
	}

	public Long getPatientAllergyId() {
		return this.patientAllergyId;
	}
	public void setPatientAllergyId(Long patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getForm() {
		return this.form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getRoute() {
		return this.route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getDose() {
		return this.dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}

	public Long getMedicationId() {
		return this.medicationId;
	}
	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}
	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getCreatedBy() {
		return this.createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Long getEncounterId() {
		return this.encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	public Long getPatientId() {
		return this.patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		return "PatientAllergyDTO [patientAllergyId=" + patientAllergyId + ", productName=" + productName + ", form="
				+ form + ", route=" + route + ", dose=" + dose + ", activeFlag=" + activeFlag + ", medicationId="
				+ medicationId + ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy + ", encounterId=" + encounterId
				+ ", patientId=" + patientId + "]";
	}
	
	
}
