
package com.cpa.ehr.backend.dao.preventivecare.entities;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="preventive_care_master", schema="ehr" )
public class MasterPreventiveCare implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="preventive_care_id", nullable=false)

    private Long preventiveCareId ; 
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    @Column(name="test_name", length=500)
    private String testName ; 
    @Column(name="gender", length=50)
    private String gender ;    
    @Column(name="age", length=50)
    private String age ;     
    @Column(name="frequency", length=50)
    private String frequency ;     
    @Column(name="recurring_event", length=10)
    private String recurringEvent ;     
    @Column(name="reminder_email_date", length=500)
    private String reminderEmailDate ; 

    
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public MasterPreventiveCare() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	public void setPreventiveCareId(Long preventiveCareId) {
        this.preventiveCareId = preventiveCareId ;
    }
	public Long getPreventiveCareId() {
        return this.preventiveCareId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : test_name (varchar) 
	public void setTestName(String testName)
 {this.testName = testName;}


	public String getTestName()
 {return this.testName;}



	//--- DATABASE MAPPING : gender (varchar) 
	public void setGender(String gender)
 {this.gender = gender;}


	public String getGender()
 {return this.gender;}



	//--- DATABASE MAPPING : age (varchar) 
	public void setAge(String age)
 {this.age = age;}


	public String getAge()
 {return this.age;}



	//--- DATABASE MAPPING : frequency (varchar) 
	public void setFrequency(String frequency)
 {this.frequency = frequency;}


	public String getFrequency()
 {return this.frequency;}



	//--- DATABASE MAPPING : recurring_event (varchar) 
	public void setRecurringEvent(String recurringEvent)
 {this.recurringEvent = recurringEvent;}


	public String getRecurringEvent()
 {return this.recurringEvent;}



	//--- DATABASE MAPPING : reminder_email_date (varchar) 
	public void setReminderEmailDate(String reminderEmailDate)
 {this.reminderEmailDate = reminderEmailDate;}


	public String getReminderEmailDate()
 {return this.reminderEmailDate;}





    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("MasterPreventiveCare");
		sb.append("preventiveCareId :");
		sb.append(preventiveCareId); 
		sb.append("testName :");
		sb.append(testName); 
		sb.append("|"); 
		sb.append("gender :");
		sb.append(gender); 
		sb.append("|"); 
		sb.append("age :");
		sb.append(age); 
		sb.append("|"); 
		sb.append("frequency :");
		sb.append(frequency); 
		sb.append("|"); 
		sb.append("recurringEvent :");
		sb.append(recurringEvent); 
		sb.append("|"); 
		sb.append("reminderEmailDate :");
		sb.append(reminderEmailDate); 
        return sb.toString();
    }
}