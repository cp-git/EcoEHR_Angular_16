package com.cpa.ehr.service.system.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class PatientPreventiveCareDTO  {

	@NotNull
	private Long patientPreventiveCareId;  
	@NotNull
	private Long patientId;  
	@NotNull
	private Long preventiveCareId;  
	@NotNull
	private String testName;  
	@NotNull
	private String age;  
	@NotNull
	private String gender;  
	@NotNull
	private Date dateLastDone;  
	@NotNull
	private String frequency;  
	@NotNull
	private String recurringEvent;  
	@NotNull
	private String reminderEmailDate;  
	@NotNull
	private boolean activeFlag;  
	@NotNull
	private Date createdDate;  
	@NotNull
	private String createdBy;  
	@NotNull
	private Date lastUpdatedDate;  
	@NotNull
	private String lastUpdatedBy;  

	// Constructor
	public PatientPreventiveCareDTO() {
		// Needed empty constructor for serialization
	}

	public Long getPatientPreventiveCareId() {
		return this.patientPreventiveCareId;
	}
	public void setPatientPreventiveCareId(Long patientPreventiveCareId) {
		this.patientPreventiveCareId = patientPreventiveCareId;
	}
	public Long getPatientId() {
		return this.patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getPreventiveCareId() {
		return this.preventiveCareId;
	}
	public void setPreventiveCareId(Long preventiveCareId) {
		this.preventiveCareId = preventiveCareId;
	}
	public String getTestName() {
		return this.testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getAge() {
		return this.age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateLastDone() {
		return this.dateLastDone;
	}
	public void setDateLastDone(Date dateLastDone) {
		this.dateLastDone = dateLastDone;
	}
	public String getFrequency() {
		return this.frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getRecurringEvent() {
		return this.recurringEvent;
	}
	public void setRecurringEvent(String recurringEvent) {
		this.recurringEvent = recurringEvent;
	}
	public String getReminderEmailDate() {
		return this.reminderEmailDate;
	}
	public void setReminderEmailDate(String reminderEmailDate) {
		this.reminderEmailDate = reminderEmailDate;
	}
	public boolean getActiveFlag() {
		return this.activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
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

	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("PatientPreventiveCareDTO");
		sb.append("patientPreventiveCareId :");
		sb.append(patientPreventiveCareId); 
		sb.append("patientId :");
		sb.append(patientId); 
		sb.append("|"); 
		sb.append("preventiveCareId :");
		sb.append(preventiveCareId); 
		sb.append("|"); 
		sb.append("testName :");
		sb.append(testName); 
		sb.append("|"); 
		sb.append("age :");
		sb.append(age); 
		sb.append("|"); 
		sb.append("gender :");
		sb.append(gender); 
		sb.append("|"); 
		sb.append("dateLastDone :");
		sb.append(dateLastDone); 
		sb.append("|"); 
		sb.append("frequency :");
		sb.append(frequency); 
		sb.append("|"); 
		sb.append("recurringEvent :");
		sb.append(recurringEvent); 
		sb.append("|"); 
		sb.append("reminderEmailDate :");
		sb.append(reminderEmailDate); 
		sb.append("|"); 
		sb.append("activeFlag :");
		sb.append(activeFlag); 
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
		return sb.toString();
	}

}


