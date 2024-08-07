package com.cpa.ehr.backend.dao.system.entities;

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
import javax.persistence.ForeignKey;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;

@Entity
@Table(name="encounter")
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "encounter_encounter_id_seq", initialValue=1, allocationSize =1)
	@Column(name="encounter_id", nullable = false)
	private Long encounterId;
	
	@Column(name="patient_id")
	private Long patientId;
	
	@ManyToOne
	@JoinColumn(name="staff_id", foreignKey = @ForeignKey(name = "enc_staff_id_fkey"))
	private StaffMember staffMember;
	
	@ManyToOne
	@JoinColumn(name="location_id", foreignKey = @ForeignKey(name = "enc_location_id_fkey"))
	private ClinicLocation clinicLocation;
	
	@ManyToOne
	@JoinColumn(name="organization_id", foreignKey = @ForeignKey(name = "organization_id_fkey"))
	private Organization organization;
	
	@Column(name="encounter_date")
	private Date encounterDate;
	
	@Column(name="chief_compliant",columnDefinition="text")
	private String chiefCompliant;
	
	@Column(name="em_id")
	private Long emId;
	
	@Column(name="active_flag", length = 1,nullable = false)
	private String activeFlag;
	
	@Column(name="physical_exam_template_id")
	private Long physicalExamTempId;
	
	@Column(name="cardiovascular_exam_template_id")
	private Long cardioExamTempId;
	
	@Column(name="simple_neuro_exam_template_id")
	private Long simpleNeuroExamTempId;
	
	@Column(name="eye_exam_template_id")
	private Long eyeExamTempId;
	
	@Column(name="detailed_exam_template_id")
	private Long detailedExamTempId;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;
	
	@Column(name="patient_unique_characters", length = 500)
	private String patientUniqueCharacters;
	
	@Column(name="completion_date")
	private Date completionDate;
	
	@Column(name="isEdited")
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

	public StaffMember getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}

	public ClinicLocation getClinicLocation() {
		return clinicLocation;
	}

	public void setClinicLocation(ClinicLocation clinicLocation) {
		this.clinicLocation = clinicLocation;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
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
		return "Encounter [encounterId=" + encounterId + ", patientId=" + patientId + ", staffMember=" + staffMember
				+ ", clinicLocation=" + clinicLocation + ", organization=" + organization + ", encounterDate="
				+ encounterDate + ", chiefCompliant=" + chiefCompliant + ", emId=" + emId + ", activeFlag=" + activeFlag
				+ ", physicalExamTempId=" + physicalExamTempId + ", cardioExamTempId=" + cardioExamTempId
				+ ", simpleNeuroExamTempId=" + simpleNeuroExamTempId + ", eyeExamTempId=" + eyeExamTempId
				+ ", detailedExamTempId=" + detailedExamTempId + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", patientUniqueCharacters=" + patientUniqueCharacters + ", completionDate=" + completionDate
				+ ", isEdited=" + isEdited + "]";
	}

	
}
