package com.cpa.ehr.backend.dao.patients.entities;

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientDetails.class)
public abstract class PatientDetails_ {

	public static volatile SingularAttribute<PatientDetails, String> pInsEmployer;
	public static volatile SingularAttribute<PatientDetails, String> zipCode;
	public static volatile SingularAttribute<PatientDetails, String> licenseNo;
	public static volatile SingularAttribute<PatientDetails, String> sInsId;
	public static volatile SingularAttribute<PatientDetails, Long> patientId;
	public static volatile SingularAttribute<PatientDetails, String> pInsRelationship;
	public static volatile SingularAttribute<PatientDetails, String> ssn;
	public static volatile SingularAttribute<PatientDetails, String> buildingNo;
	public static volatile SingularAttribute<PatientDetails, StaffMember> staffMember;
	public static volatile SingularAttribute<PatientDetails, String> additionalInfo;
	public static volatile SingularAttribute<PatientDetails, String> sInsEmployer;
	public static volatile SingularAttribute<PatientDetails, String> primaryEmail;
	public static volatile SingularAttribute<PatientDetails, String> sInsCompany;
	public static volatile SingularAttribute<PatientDetails, String> lastUpdatedBy;
	public static volatile SingularAttribute<PatientDetails, String> pInsPlanName;
	public static volatile SingularAttribute<PatientDetails, String> sInsRelationship;
	public static volatile SingularAttribute<PatientDetails, String> pInsGroup;
	public static volatile SingularAttribute<PatientDetails, String> firstName;
	public static volatile SingularAttribute<PatientDetails, Date> dob;
	public static volatile SingularAttribute<PatientDetails, String> secondaryNo;
	public static volatile SingularAttribute<PatientDetails, String> patientState;
	public static volatile SingularAttribute<PatientDetails, String> lastName;
	public static volatile SingularAttribute<PatientDetails, String> patientLanguage;
	public static volatile SingularAttribute<PatientDetails, String> secondaryEmail;
	public static volatile SingularAttribute<PatientDetails, String> gender;
	public static volatile SingularAttribute<PatientDetails, String> ethnicity;
	public static volatile SingularAttribute<PatientDetails, String> emrId;
	public static volatile SingularAttribute<PatientDetails, String> title;
	public static volatile SingularAttribute<PatientDetails, String> pInsId;
	public static volatile SingularAttribute<PatientDetails, ClinicLocation> clinicLocation;
	public static volatile SingularAttribute<PatientDetails, String> pInsName;
	public static volatile SingularAttribute<PatientDetails, String> pInsCompany;
	public static volatile SingularAttribute<PatientDetails, String> sInsSsn;
	public static volatile SingularAttribute<PatientDetails, String> primaryNo;
	public static volatile SingularAttribute<PatientDetails, String> sInsName;
	public static volatile SingularAttribute<PatientDetails, String> patientCity;
	public static volatile SingularAttribute<PatientDetails, String> patientApartmentNo;
	public static volatile SingularAttribute<PatientDetails, String> activeFlag;
	public static volatile SingularAttribute<PatientDetails, String> pInsSsn;
	public static volatile SingularAttribute<PatientDetails, String> race;
	public static volatile SingularAttribute<PatientDetails, String> sInsPlanName;
	public static volatile SingularAttribute<PatientDetails, String> mrn;
	public static volatile SingularAttribute<PatientDetails, byte[]> patientImage;
	public static volatile SingularAttribute<PatientDetails, Date> lastUpdatedDate;
	public static volatile SingularAttribute<PatientDetails, Date> createdDate;
	public static volatile SingularAttribute<PatientDetails, String> createdBy;
	public static volatile SingularAttribute<PatientDetails, String> patientStreetAddress;
	public static volatile SingularAttribute<PatientDetails, Date> pInsDob;
	public static volatile SingularAttribute<PatientDetails, Organization> organization;
	public static volatile SingularAttribute<PatientDetails, String> sInsGroup;
	public static volatile SingularAttribute<PatientDetails, String> middleName;
	public static volatile SingularAttribute<PatientDetails, Date> sInsDob;
	public static volatile SingularAttribute<PatientDetails, String> age;

}

