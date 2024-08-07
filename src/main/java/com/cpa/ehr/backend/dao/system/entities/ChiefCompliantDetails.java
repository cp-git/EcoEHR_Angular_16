package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="chief_compliant_dtl")
public class ChiefCompliantDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "chief_compliant_dtl_id_seq", initialValue=1, allocationSize =1)
	@Column(name="chief_compliant_dtl_id", nullable = false)
	private Long chiefCompliantDtlId;
	
	@ManyToOne
	@JoinColumn(name="encounter_id", foreignKey = @ForeignKey(name = "cc_encounter_id_fkey"))
	private Encounter encounter;
	
	@Column(name="icd10_code")
	private String icd10Code;
	
	@Column(name="icd10_code_description")
	private String icd10CodeDescription;
	
	@Column(name="primary_flag")
	private String primaryFlag;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;

	public Long getChiefCompliantDtlId() {
		return chiefCompliantDtlId;
	}

	public void setChiefCompliantDtlId(Long chiefCompliantDtlId) {
		this.chiefCompliantDtlId = chiefCompliantDtlId;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	public String getPrimaryFlag() {
		return primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
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

	public String getIcd10CodeDescription() {
		return icd10CodeDescription;
	}

	public void setIcd10CodeDescription(String icd10CodeDescription) {
		this.icd10CodeDescription = icd10CodeDescription;
	}

	@Override
	public String toString() {
		return "ChiefCompliantDetails [chiefCompliantDtlId=" + chiefCompliantDtlId + ", encounter=" + encounter
				+ ", icd10Code=" + icd10Code + ", icd10CodeDescription=" + icd10CodeDescription + ", primaryFlag="
				+ primaryFlag + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

	
	
}
