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
@Table(name="enc_question_option")
public class EncQuestionOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "encounter_question_option_id_seq", allocationSize=1)
	@Column(name="enc_question_option_id", nullable = false)
	private Long encQuestionOptionId;
	
	@ManyToOne
	@JoinColumn(name="encounter_id", foreignKey = @ForeignKey(name = "encounter_id_fkey"))
	private Encounter encounter;
	
	@Column(name="question_id")
	private Long questionId;
	
	@Column(name="question_group_id")
	private Long questionGroupId;
	
	@Column(name="sys_id")
	private Long systemId;
	
	@Column(name="option_id")
	private Long optionId;
	
	@Column(name="option_value", length = 100)
	private String optionValue;
	
	@Column(name="answer", length = 500)
	private String answer;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;
	
	@Column(name="answer_comments", length = 500)
	private String answerComments;


	public Long getEncQuestionOptionId() {
		return encQuestionOptionId;
	}

	public void setEncQuestionOptionId(Long encQuestionOptionId) {
		this.encQuestionOptionId = encQuestionOptionId;
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

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(String answerComments) {
		this.answerComments = answerComments;
	}

	@Override
	public String toString() {
		return "EncQuestionOption [encQuestionOptionId=" + encQuestionOptionId + ", encounter=" + encounter
				+ ", questionId=" + questionId + ", questionGroupId=" + questionGroupId + ", systemId=" + systemId
				+ ", optionId=" + optionId + ", optionValue=" + optionValue + ", answer=" + answer + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", answerComments=" + answerComments + "]";
	}

	



	
	
}
