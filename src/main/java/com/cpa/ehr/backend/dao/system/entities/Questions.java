package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Questions {
	@Id
	@Column(name="question_id", nullable = false)
	private Long questionId;
	
	@Column(name="sys_id")
	private Long systemId;
	 
	@Column(name="question_group_id")
	private Long questionGroupId;
	
	@Column(name="question_desc")
	private String questionDesc;
	
	@Column(name="question_type", length=100)
	private String questionType;
	
	@Column(name="question_disp_type", length=100)
	private String questionDispType;
	
	@Column(name="question_order")
	private Long questionOrder;
	
	@Column(name="mandatory_flag", length=1)
	private Character mandatoryFlag;
	
	@Column(name="options_count")
	private Long optionsCount;
	
	@Column(name="active_flag", nullable = false, length = 1)
	private Character activeFlag;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;

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

	public Long getQuestionGroupId() {
		return questionGroupId;
	}

	public void setQuestionGroupId(Long questionGroupId) {
		this.questionGroupId = questionGroupId;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionDispType() {
		return questionDispType;
	}

	public void setQuestionDispType(String questionDispType) {
		this.questionDispType = questionDispType;
	}

	public Long getQuestionOrder() {
		return questionOrder;
	}

	public void setQuestionOrder(Long questionOrder) {
		this.questionOrder = questionOrder;
	}

	public Character getMandatoryFlag() {
		return mandatoryFlag;
	}

	public void setMandatoryFlag(Character mandatoryFlag) {
		this.mandatoryFlag = mandatoryFlag;
	}

	public Long getOptionsCount() {
		return optionsCount;
	}

	public void setOptionsCount(Long optionsCount) {
		this.optionsCount = optionsCount;
	}

	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
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
		return "Questions [questionId=" + questionId + ", systemId=" + systemId + ", questionGroupId=" + questionGroupId
				+ ", questionDesc=" + questionDesc + ", questionType=" + questionType + ", questionDispType="
				+ questionDispType + ", questionOrder=" + questionOrder + ", mandatoryFlag=" + mandatoryFlag
				+ ", optionsCount=" + optionsCount + ", activeFlag=" + activeFlag + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + "]";
	}
}
