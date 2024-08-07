package com.cpa.ehr.backend.dao.patients.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="consultant_notes", schema="ehr" )
public class ConsultantNotes implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "consultant_notes_id_seq", initialValue=1, allocationSize =1)
    @Column(name="consultant_notes_id", nullable=false)
    private Long consultantNotesId ;  

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

 
    @Column(name="patient_id")
private Long patientId ;
 
    @Column(name="consultant_comments", length=500)
private String consultantComments ;
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="consultant_date")
private Date consultantDate ;
 
    @Column(name="document_link", length=500)
private String documentLink ;
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
private Date createdDate ;
 
    @Column(name="created_by", length=500)
private String createdBy ;
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_updated_date")
private Date lastUpdatedDate ;
 
    @Column(name="last_updated_by", length=500)
private String lastUpdatedBy ;
 
    @Column(name="active_flag", length=1)
private String activeFlag ;


    
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ConsultantNotes() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	public void setConsultantNotesId(Long consultantNotesId) {
        this.consultantNotesId = consultantNotesId ;
    }
	public Long getConsultantNotesId() {
        return this.consultantNotesId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : patient_id (int8) 
	public void setPatientId(Long patientId)
 {this.patientId = patientId;}


	public Long getPatientId()
 {return this.patientId;}


	//--- DATABASE MAPPING : consultant_comments (varchar) 
	public void setConsultantComments(String consultantComments)
 {this.consultantComments = consultantComments;}


	public String getConsultantComments()
 {return this.consultantComments;}


	//--- DATABASE MAPPING : consultant_date (timestamptz) 
	public void setConsultantDate(Date consultantDate)
 {this.consultantDate = consultantDate;}


	public Date getConsultantDate()
 {return this.consultantDate;}


	//--- DATABASE MAPPING : document_link (varchar) 
	public void setDocumentLink(String documentLink)
 {this.documentLink = documentLink;}


	public String getDocumentLink()
 {return this.documentLink;}


	//--- DATABASE MAPPING : created_date (timestamptz) 
	public void setCreatedDate(Date createdDate)
 {this.createdDate = createdDate;}


	public Date getCreatedDate()
 {return this.createdDate;}


	//--- DATABASE MAPPING : created_by (varchar) 
	public void setCreatedBy(String createdBy)
 {this.createdBy = createdBy;}


	public String getCreatedBy()
 {return this.createdBy;}


	//--- DATABASE MAPPING : last_updated_date (timestamptz) 
	public void setLastUpdatedDate(Date lastUpdatedDate)
 {this.lastUpdatedDate = lastUpdatedDate;}


	public Date getLastUpdatedDate()
 {return this.lastUpdatedDate;}


	//--- DATABASE MAPPING : last_updated_by (varchar) 
	public void setLastUpdatedBy(String lastUpdatedBy)
 {this.lastUpdatedBy = lastUpdatedBy;}


	public String getLastUpdatedBy()
 {return this.lastUpdatedBy;}


	//--- DATABASE MAPPING : active_flag (varchar) 
	public void setActiveFlag(String activeFlag)
 {this.activeFlag = activeFlag;}


	public String getActiveFlag()
 {return this.activeFlag;}




    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("ConsultantNotes");
		sb.append("consultantNotesId :");
		sb.append(consultantNotesId); 
		sb.append("patientId :");
		sb.append(patientId); 
		sb.append("|"); 
		sb.append("consultantComments :");
		sb.append(consultantComments); 
		sb.append("|"); 
		sb.append("consultantDate :");
		sb.append(consultantDate); 
		sb.append("|"); 
		sb.append("documentLink :");
		sb.append(documentLink); 
		sb.append("|"); 
		sb.append("createdDate :");
		sb.append(createdDate); 
		sb.append("|"); 
		sb.append("createdBy :");
		sb.append(createdBy); 
		sb.append("|"); 
		sb.append("lastUpdatedDate :");
		sb.append(lastUpdatedDate); 
		sb.append("|"); 
		sb.append("lastUpdatedBy :");
		sb.append(lastUpdatedBy); 
		sb.append("|"); 
		sb.append("activeFlag :");
		sb.append(activeFlag); 
        return sb.toString();
    }
}