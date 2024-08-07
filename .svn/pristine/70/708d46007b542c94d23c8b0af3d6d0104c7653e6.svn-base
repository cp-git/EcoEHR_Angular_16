package com.cpa.ehr.backend.dao.system.entities;

import java.util.List;

public class QuestionRecord implements Cloneable {
	
	private Long questionId;
	
	private Long systemId;
	
	private Long questionGroupId;
	
	private String questionDesc;
	
	private String optionType;
	
	private List<OptionRecord> optionRecord;

	public List<OptionRecord> getOptionRecord() {
		return optionRecord;
	}

	public void setOptionRecord(List<OptionRecord> optionRecord) {
		this.optionRecord = optionRecord;
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	@Override
	public String toString() {
		return "QuestionRecord [questionId=" + questionId + ", systemId=" + systemId
				+ ", questionGroupId=" + questionGroupId + ", questionDesc=" + questionDesc + ", optionType="
				+ optionType + ", optionRecord=" + optionRecord + "]";
	}


}
