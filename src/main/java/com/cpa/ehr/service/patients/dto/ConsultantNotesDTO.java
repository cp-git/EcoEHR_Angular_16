package com.cpa.ehr.service.patients.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class ConsultantNotesDTO  {

		@NotNull
		   private Long consultantNotesId;  
		   private Long patientId;  
		   private String consultantComments;  
		   private Date consultantDate;  
		   private String documentLink;  
		   private Date createdDate;  
		   private String createdBy;  
		   private Date lastUpdatedDate;  
		   private String lastUpdatedBy;  
		   private Boolean activeFlag;  

	// Constructor
	public ConsultantNotesDTO() {
		// Needed empty constructor for serialization
	}

	public Long getConsultantNotesId() {
		return this.consultantNotesId;
	}
	public void setConsultantNotesId(Long consultantNotesId) {
		this.consultantNotesId = consultantNotesId;
	}
	public Long getPatientId() {
		return this.patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getConsultantComments() {
		return this.consultantComments;
	}
	public void setConsultantComments(String consultantComments) {
		this.consultantComments = consultantComments;
	}
	public Date getConsultantDate() {
		return this.consultantDate;
	}
	public void setConsultantDate(Date consultantDate) {
		this.consultantDate = consultantDate;
	}
	public String getDocumentLink() {
		return this.documentLink;
	}
	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}
	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return this.createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(); 
	sb.append("ConsultantNotesDTO");
		sb.append("consultantNotesId :");
		sb.append(consultantNotesId); 
		sb.append("patientId :");
		sb.append(patientId); 
		sb.append("|"); 
		sb.append("consultantComments :");
		sb.append(consultantComments); 
		sb.append("|"); 
		sb.append("consultantDate :");
		sb.append(consultantDate); 
		sb.append("|"); 
		sb.append("documentLink :");
		sb.append(documentLink); 
		sb.append("|"); 
		sb.append("createdDate :");
		sb.append(createdDate); 
		sb.append("|"); 
		sb.append("createdBy :");
		sb.append(createdBy); 
		sb.append("|"); 
		sb.append("lastUpdatedDate :");
		sb.append(lastUpdatedDate); 
		sb.append("|"); 
		sb.append("lastUpdatedBy :");
		sb.append(lastUpdatedBy); 
		sb.append("|"); 
		sb.append("activeFlag :");
		sb.append(activeFlag); 
        return sb.toString();
    }

}


