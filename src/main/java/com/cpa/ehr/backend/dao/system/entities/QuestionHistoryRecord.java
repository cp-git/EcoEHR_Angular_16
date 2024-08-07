package com.cpa.ehr.backend.dao.system.entities;

public class QuestionHistoryRecord {
private Long questionGroupId;
	
	private String questionGroupName;
	
	private Long questionId;
	
	private String questionDesc;
	
	private Long optionId;
	private String optionValue;
	private String answer;
	
	private String questionType;
	
	
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public Long getQuestionGroupId() {
		return questionGroupId;
	}
	public void setQuestionGroupId(Long questionGroupId) {
		this.questionGroupId = questionGroupId;
	}
	public String getQuestionGroupName() {
		return questionGroupName;
	}
	public void setQuestionGroupName(String questionGroupName) {
		this.questionGroupName = questionGroupName;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
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
		return "QuestionHistoryRecord [questionGroupId=" + questionGroupId + ", questionGroupName=" + questionGroupName
				+ ", questionId=" + questionId + ", questionDesc=" + questionDesc + ", optionId=" + optionId
				+ ", optionValue=" + optionValue + ", answer=" + answer + ", questionType=" + questionType + "]";
	}
	
	
}
