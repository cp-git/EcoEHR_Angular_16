package com.cpa.ehr.backend.dao.patients.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "ehr")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "order_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "order_id", nullable = false)
	private Long orderId;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lab_order_date")
	private Date labOrderDate;

	@Column(name = "lab_order_comments", length = 500)
	private String labOrderComments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "imaging_order_date")
	private Date imagingOrderDate;

	@Column(name = "imaging_order_comments", length = 500)
	private String imagingOrderComments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consulting_order_date")
	private Date consultingOrderDate;

	@Column(name = "consulting_order_comments", length = 500)
	private String consultingOrderComments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "followup_order_date")
	private Date followupOrderDate;

	@Column(name = "followup_order_comments", length = 500)
	private String followupOrderComments;

	@Column(name = "condition_type", length = 500)
	private String conditionType;

	@Column(name = "condition_comments", length = 500)
	private String conditionComments;

	@Column(name = "patient_id")
	private Long patientId;

	@Column(name = "encounter_id")
	private Long encounterId;

	@Column(name = "icd10_code")
	private String icd10Code;
	
	@Column(name = "icd10_code_desc")
	private String icd10CodeDesc;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "last_updated_by", length = 100)
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

	@Column(name = "active_flag", length = 1)
	private String activeFlag;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public Orders() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : lab_order_date (timestamp)
	public void setLabOrderDate(Date labOrderDate) {
		this.labOrderDate = labOrderDate;
	}

	public Date getLabOrderDate() {
		return this.labOrderDate;
	}

	// --- DATABASE MAPPING : lab_order_comments (varchar)
	public void setLabOrderComments(String labOrderComments) {
		this.labOrderComments = labOrderComments;
	}

	public String getLabOrderComments() {
		return this.labOrderComments;
	}

	// --- DATABASE MAPPING : imaging_order_date (timestamp)
	public void setImagingOrderDate(Date imagingOrderDate) {
		this.imagingOrderDate = imagingOrderDate;
	}

	public Date getImagingOrderDate() {
		return this.imagingOrderDate;
	}

	// --- DATABASE MAPPING : imaging_order_comments (varchar)
	public void setImagingOrderComments(String imagingOrderComments) {
		this.imagingOrderComments = imagingOrderComments;
	}

	public String getImagingOrderComments() {
		return this.imagingOrderComments;
	}

	// --- DATABASE MAPPING : consulting_order_date (timestamp)
	public void setConsultingOrderDate(Date consultingOrderDate) {
		this.consultingOrderDate = consultingOrderDate;
	}

	public Date getConsultingOrderDate() {
		return this.consultingOrderDate;
	}

	// --- DATABASE MAPPING : consulting_order_comments (varchar)
	public void setConsultingOrderComments(String consultingOrderComments) {
		this.consultingOrderComments = consultingOrderComments;
	}

	public String getConsultingOrderComments() {
		return this.consultingOrderComments;
	}

	// --- DATABASE MAPPING : followup_order_date (timestamp)
	public void setFollowupOrderDate(Date followupOrderDate) {
		this.followupOrderDate = followupOrderDate;
	}

	public Date getFollowupOrderDate() {
		return this.followupOrderDate;
	}

	// --- DATABASE MAPPING : followup_order_comments (varchar)
	public void setFollowupOrderComments(String followupOrderComments) {
		this.followupOrderComments = followupOrderComments;
	}

	public String getFollowupOrderComments() {
		return this.followupOrderComments;
	}

	// --- DATABASE MAPPING : patient_id (int8)
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getPatientId() {
		return this.patientId;
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

	// --- DATABASE MAPPING : created_by (varchar)
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	// --- DATABASE MAPPING : created_date (timestamp)
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	// --- DATABASE MAPPING : last_updated_by (varchar)
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	// --- DATABASE MAPPING : last_updated_date (timestamp)
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	// --- DATABASE MAPPING : active_flag (varchar)
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getActiveFlag() {
		return this.activeFlag;
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
		return "Orders [orderId=" + orderId + ", labOrderDate=" + labOrderDate + ", labOrderComments="
				+ labOrderComments + ", imagingOrderDate=" + imagingOrderDate + ", imagingOrderComments="
				+ imagingOrderComments + ", consultingOrderDate=" + consultingOrderDate + ", consultingOrderComments="
				+ consultingOrderComments + ", followupOrderDate=" + followupOrderDate + ", followupOrderComments="
				+ followupOrderComments + ", conditionType=" + conditionType + ", conditionComments="
				+ conditionComments + ", patientId=" + patientId + ", encounterId=" + encounterId + ", icd10Code="
				+ icd10Code + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", activeFlag=" + activeFlag + "]";
	}

}