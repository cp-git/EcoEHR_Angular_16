package com.cpa.ehr.service.patients.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class OrdersDTO {

	@NotNull
	private Long orderId;
	private Date labOrderDate;
	private String labOrderComments;
	private Date imagingOrderDate;
	private String imagingOrderComments;
	private Date consultingOrderDate;
	private String consultingOrderComments;
	private Date followupOrderDate;
	private String followupOrderComments;
	private String conditionType;
	private String conditionComments;
	private Long patientId;
	private Long encounterId;
	private String icd10Code;
	private String icd10CodeDesc;
	private String createdBy;
	private Date createdDate;
	private String lastUpdatedBy;
	private Date lastUpdatedDate;
	private Boolean activeFlag;

	// Constructor
	public OrdersDTO() {
		// Needed empty constructor for serialization
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getLabOrderDate() {
		return this.labOrderDate;
	}

	public void setLabOrderDate(Date labOrderDate) {
		this.labOrderDate = labOrderDate;
	}

	public String getLabOrderComments() {
		return this.labOrderComments;
	}

	public void setLabOrderComments(String labOrderComments) {
		this.labOrderComments = labOrderComments;
	}

	public Date getImagingOrderDate() {
		return this.imagingOrderDate;
	}

	public void setImagingOrderDate(Date imagingOrderDate) {
		this.imagingOrderDate = imagingOrderDate;
	}

	public String getImagingOrderComments() {
		return this.imagingOrderComments;
	}

	public void setImagingOrderComments(String imagingOrderComments) {
		this.imagingOrderComments = imagingOrderComments;
	}

	public Date getConsultingOrderDate() {
		return this.consultingOrderDate;
	}

	public void setConsultingOrderDate(Date consultingOrderDate) {
		this.consultingOrderDate = consultingOrderDate;
	}

	public String getConsultingOrderComments() {
		return this.consultingOrderComments;
	}

	public void setConsultingOrderComments(String consultingOrderComments) {
		this.consultingOrderComments = consultingOrderComments;
	}

	public Date getFollowupOrderDate() {
		return this.followupOrderDate;
	}

	public void setFollowupOrderDate(Date followupOrderDate) {
		this.followupOrderDate = followupOrderDate;
	}

	public String getFollowupOrderComments() {
		return this.followupOrderComments;
	}

	public void setFollowupOrderComments(String followupOrderComments) {
		this.followupOrderComments = followupOrderComments;
	}

	public Long getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public String getConditionComments() {
		return conditionComments;
	}

	public void setConditionComments(String conditionComments) {
		this.conditionComments = conditionComments;
	}
	
	public String getIcd10CodeDesc() {
		return icd10CodeDesc;
	}

	public void setIcd10CodeDesc(String icd10CodeDesc) {
		this.icd10CodeDesc = icd10CodeDesc;
	}

	@Override
	public String toString() {
		return "OrdersDTO [orderId=" + orderId + ", labOrderDate=" + labOrderDate + ", labOrderComments="
				+ labOrderComments + ", imagingOrderDate=" + imagingOrderDate + ", imagingOrderComments="
				+ imagingOrderComments + ", consultingOrderDate=" + consultingOrderDate + ", consultingOrderComments="
				+ consultingOrderComments + ", followupOrderDate=" + followupOrderDate + ", followupOrderComments="
				+ followupOrderComments + ", conditionType=" + conditionType + ", conditionComments="
				+ conditionComments + ", patientId=" + patientId + ", encounterId=" + encounterId + ", icd10Code="
				+ icd10Code + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", activeFlag=" + activeFlag + "]";
	}
}
