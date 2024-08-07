package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientAllergy.class)
public abstract class PatientAllergy_ {

	public static volatile SingularAttribute<PatientAllergy, String> lastUpdatedBy;
	public static volatile SingularAttribute<PatientAllergy, Long> patientId;
	public static volatile SingularAttribute<PatientAllergy, Long> encounterId;
	public static volatile SingularAttribute<PatientAllergy, String> productName;
	public static volatile SingularAttribute<PatientAllergy, Long> patientAllergyId;
	public static volatile SingularAttribute<PatientAllergy, String> dose;
	public static volatile SingularAttribute<PatientAllergy, Date> lastUpdatedDate;
	public static volatile SingularAttribute<PatientAllergy, String> route;
	public static volatile SingularAttribute<PatientAllergy, Date> createdDate;
	public static volatile SingularAttribute<PatientAllergy, String> form;
	public static volatile SingularAttribute<PatientAllergy, Long> medicationId;
	public static volatile SingularAttribute<PatientAllergy, String> createdBy;
	public static volatile SingularAttribute<PatientAllergy, String> activeFlag;

}

