package com.cpa.ehr.service.system.dto;

public class EncounterHistoryDTO {
	
	private Long systemId;
	
	private String systemType;
	
	private String systemCode;
	
	private String systemDesc;
	
	private Long systemOrder;
	
	private String questionGroupName;
	
	private Long questionGroupOrder;
	
	private Long questionGroupId;
	
	private String questionDesc;
	
	private String questionType;
	
	private String questionDispType;
	
	private Long questionOrder;
	
	private Long encounterId;
	
	private Long questionId;
	
	private Long encQuestionOptionId;
	
	private Long optionId;
	
	private String optionValue;
	
	private String answer;

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getSystemDesc() {
		return systemDesc;
	}

	public void setSystemDesc(String systemDesc) {
		this.systemDesc = systemDesc;
	}

	public Long getSystemOrder() {
		return systemOrder;
	}

	public void setSystemOrder(Long systemOrder) {
		this.systemOrder = systemOrder;
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

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getEncQuestionOptionId() {
		return encQuestionOptionId;
	}

	public void setEncQuestionOptionId(Long encQuestionOptionId) {
		this.encQuestionOptionId = encQuestionOptionId;
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

	@Override
	public String toString() {
		return "EncounterHistoryDTO [systemId=" + systemId + ", systemType=" + systemType + ", systemCode=" + systemCode
				+ ", systemDesc=" + systemDesc + ", systemOrder=" + systemOrder + ", questionGroupName="
				+ questionGroupName + ", questionGroupOrder=" + questionGroupOrder + ", questionGroupId="
				+ questionGroupId + ", questionDesc=" + questionDesc + ", questionType=" + questionType
				+ ", questionDispType=" + questionDispType + ", questionOrder=" + questionOrder + ", encounterId="
				+ encounterId + ", questionId=" + questionId + ", encQuestionOptionId=" + encQuestionOptionId
				+ ", optionId=" + optionId + ", optionValue=" + optionValue + ", answer=" + answer + "]";
	}
}
