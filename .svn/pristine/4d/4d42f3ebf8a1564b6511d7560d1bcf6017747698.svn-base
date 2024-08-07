
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

@Entity
@Table(name="enc_question_group")
public class EncounterQuestionGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "enc_question_group_id_seq", initialValue=1, allocationSize =1)
	@Column(name="enc_question_group_id", nullable = false)
	private Long encQuestionGroupId;
	
	@ManyToOne
	@JoinColumn(name="encounter_id", foreignKey = @ForeignKey(name = "qg_encounter_id_fkey"))
	private Encounter encounter;
	
	@Column(name="question_group_id", length = 10)
	private Long questionGroupId;
	
	@Column(name="sys_id", length = 10)
	private Long systemId;
	
	@Column(name="question_group_answer", length = 50,nullable = false)
	private String questionGroupAnswer;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;
	


	public Long getEncQuestionGroupId() {
		return encQuestionGroupId;
	}

	public void setEncQuestionGroupId(Long encQuestionGroupId) {
		this.encQuestionGroupId = encQuestionGroupId;
	}


	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public Long getQuestionGroupId() {
		return questionGroupId;
	}

	public void setQuestionGroupId(Long questionGroupId) {
		this.questionGroupId = questionGroupId;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getQuestionGroupAnswer() {
		return questionGroupAnswer;
	}

	public void setQuestionGroupAnswer(String questionGroupAnswer) {
		this.questionGroupAnswer = questionGroupAnswer;
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

	@Override
	public String toString() {
		return "EncounterQuestionGroup [encQuestionGroupId=" + encQuestionGroupId + ", encounter=" + encounter
				+ ", questionGroupId=" + questionGroupId + ", systemId=" + systemId + ", questionGroupAnswer="
				+ questionGroupAnswer + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}



	
	


	
	
	
	
}
