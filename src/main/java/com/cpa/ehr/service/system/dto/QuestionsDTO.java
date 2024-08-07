package com.cpa.ehr.service.system.dto;

import java.util.Date;

public class QuestionsDTO{
	
	private Long questionId;
	
	private Long systemId;
	 
	private Long questionGroupId;
	
	private String questionDesc;
	
	private String questionType;
	
	private String questionDispType;
	
	private Long questionOrder;
	
	private Character mandatoryFlag;
	
	private Long optionsCount;
	
	private Character activeFlag;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date lastUpdatedDate;
	
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
		return "QuestionsDTO [questionId=" + questionId + ", systemId=" + systemId + ", questionGroupId="
				+ questionGroupId + ", questionDesc=" + questionDesc + ", questionType=" + questionType
				+ ", questionDispType=" + questionDispType + ", questionOrder=" + questionOrder + ", mandatoryFlag="
				+ mandatoryFlag + ", optionsCount=" + optionsCount + ", activeFlag=" + activeFlag + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + "]";
	}
}
