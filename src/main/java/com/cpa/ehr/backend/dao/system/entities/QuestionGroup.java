package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_group")
public class QuestionGroup {
	@Id
	@Column(name="question_group_id", nullable = false)
	private Long questionGroupId;
	
	@Column(name="sys_id", length = 10)
	private Long systemId;
	
	@Column(name="question_group_name", length = 200)
	private String questionGroupName;
	
	@Column(name="question_group_order", length = 10)
	private Long questionGroupOrder;
	
	@Column(name="question_count", length = 10)
	private Long questionCount;

	
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

	public String getQuestionGroupName() {
		return questionGroupName;
	}

	public void setQuestionGroupName(String questionGroupName) {
		this.questionGroupName = questionGroupName;
	}

	public Long getQuestionGroupOrder() {
		return questionGroupOrder;
	}

	public void setQuestionGroupOrder(Long questionGroupOrder) {
		this.questionGroupOrder = questionGroupOrder;
	}

	public Long getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Long questionCount) {
		this.questionCount = questionCount;
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
		return "QuestionGroup [questionGroupId=" + questionGroupId + ", systemId=" + systemId + ", questionGroupName="
				+ questionGroupName + ", questionGroupOrder=" + questionGroupOrder + ", questionCount=" + questionCount
				+ ", activeFlag=" + activeFlag + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

}
