package com.cpa.ehr.backend.dao.system.entities;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="enc_asessment")
public class EncAsessment implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "enc_asessment_id", initialValue=1, allocationSize = 1)
	@Column(name="enc_asessment_id", nullable=false)
private Long encAsessmentId ;
 
    @Column(name="encounter_id")
private Long encounterId ;
 
    @Column(name="patient_id")
private Long patientId ;
 
    @Column(name="icd10_code", length=255)
private String icd10Code ;
 
    @Column(name="icd10_code_description", length=255)
private String icd10CodeDescription ;
 
    @Column(name="created_by", length=100)
private String createdBy ;
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
private Date createdDate ;
 
    @Column(name="last_updated_by", length=100)
private String lastUpdatedBy ;
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_updated_date")
private Date lastUpdatedDate ;

    @Column(name="active_flag", length = 1,nullable = false)
	private String activeFlag;

    
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EncAsessment() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : enc_asessment_id (serial) 
	public void setEncAsessmentId(Long encAsessmentId)
 {this.encAsessmentId = encAsessmentId;}


	public Long getEncAsessmentId()
 {return this.encAsessmentId;}


	//--- DATABASE MAPPING : encounter_id (int8) 
	public void setEncounterId(Long encounterId)
 {this.encounterId = encounterId;}


	public Long getEncounterId()
 {return this.encounterId;}


	//--- DATABASE MAPPING : patient_id (int8) 
	public void setPatientId(Long patientId)
 {this.patientId = patientId;}


	public Long getPatientId()
 {return this.patientId;}


	//--- DATABASE MAPPING : icd10_code (varchar) 
	public void setIcd10Code(String icd10Code)
 {this.icd10Code = icd10Code;}


	public String getIcd10Code()
 {return this.icd10Code;}


	//--- DATABASE MAPPING : icd10_code_description (varchar) 
	public void setIcd10CodeDescription(String icd10CodeDescription)
 {this.icd10CodeDescription = icd10CodeDescription;}


	public String getIcd10CodeDescription()
 {return this.icd10CodeDescription;}


	//--- DATABASE MAPPING : created_by (varchar) 
	public void setCreatedBy(String createdBy)
 {this.createdBy = createdBy;}


	public String getCreatedBy()
 {return this.createdBy;}


	//--- DATABASE MAPPING : created_date (timestamp) 
	public void setCreatedDate(Date createdDate)
 {this.createdDate = createdDate;}


	public Date getCreatedDate()
 {return this.createdDate;}


	//--- DATABASE MAPPING : last_updated_by (varchar) 
	public void setLastUpdatedBy(String lastUpdatedBy)
 {this.lastUpdatedBy = lastUpdatedBy;}


	public String getLastUpdatedBy()
 {return this.lastUpdatedBy;}


	//--- DATABASE MAPPING : last_updated_date (timestamp) 
	public void setLastUpdatedDate(Date lastUpdatedDate)
 {this.lastUpdatedDate = lastUpdatedDate;}


	public Date getLastUpdatedDate()
 {return this.lastUpdatedDate;}




    public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

		//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("EncAsessment");
		sb.append("encAsessmentId :");
		sb.append(encAsessmentId); 
		sb.append("|"); 
		sb.append("encounterId :");
		sb.append(encounterId); 
		sb.append("|"); 
		sb.append("patientId :");
		sb.append(patientId); 
		sb.append("|"); 
		sb.append("icd10Code :");
		sb.append(icd10Code); 
		sb.append("|"); 
		sb.append("icd10CodeDescription :");
		sb.append(icd10CodeDescription); 
		sb.append("|"); 
		sb.append("createdBy :");
		sb.append(createdBy); 
		sb.append("|"); 
		sb.append("createdDate :");
		sb.append(createdDate); 
		sb.append("|"); 
		sb.append("lastUpdatedBy :");
		sb.append(lastUpdatedBy); 
		sb.append("|"); 
		sb.append("lastUpdatedDate :");
		sb.append(lastUpdatedDate); 
        return sb.toString();
    }
}