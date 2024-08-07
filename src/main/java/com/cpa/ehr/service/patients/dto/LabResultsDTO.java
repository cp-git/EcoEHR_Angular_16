package com.cpa.ehr.service.patients.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;



/**
 * Hateoas resource associated with LabResults.
 * @author Somesh Biswas version 3.0.0
 */
public class LabResultsDTO  {

		@NotNull
		   private Long labId;  
		   private Long patientId;  
		   private String resultsComments;  
		   private String documentLink;  
		   private Date labDate;  
		   private Date createdDate;  
		   private String createdBy;  
		   private Date lastUpdatedDate;  
		   private String lastUpdatedBy;  
		   private Boolean activeFlag;  

	// Constructor
	public LabResultsDTO() {
		// Needed empty constructor for serialization
	}

	public Long getLabId() {
		return this.labId;
	}
	public void setLabId(Long labId) {
		this.labId = labId;
	}
	public Long getPatientId() {
		return this.patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getResultsComments() {
		return this.resultsComments;
	}
	public void setResultsComments(String resultsComments) {
		this.resultsComments = resultsComments;
	}
	public String getDocumentLink() {
		return this.documentLink;
	}
	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}
	public Date getLabDate() {
		return this.labDate;
	}
	public void setLabDate(Date labDate) {
		this.labDate = labDate;
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
		return this.activeFlag;
	}
	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(); 
	sb.append("LabResultsDTO");
		sb.append("labId :");
		sb.append(labId); 
		sb.append("patientId :");
		sb.append(patientId); 
		sb.append("|"); 
		sb.append("resultsComments :");
		sb.append(resultsComments); 
		sb.append("|"); 
		sb.append("documentLink :");
		sb.append(documentLink); 
		sb.append("|"); 
		sb.append("labDate :");
		sb.append(labDate); 
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


