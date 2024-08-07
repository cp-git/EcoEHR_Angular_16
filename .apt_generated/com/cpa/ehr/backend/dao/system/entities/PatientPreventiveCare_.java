package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientPreventiveCare.class)
public abstract class PatientPreventiveCare_ {

	public static volatile SingularAttribute<PatientPreventiveCare, String> lastUpdatedBy;
	public static volatile SingularAttribute<PatientPreventiveCare, String> gender;
	public static volatile SingularAttribute<PatientPreventiveCare, Long> patientPreventiveCareId;
	public static volatile SingularAttribute<PatientPreventiveCare, Long> patientId;
	public static volatile SingularAttribute<PatientPreventiveCare, Long> preventiveCareId;
	public static volatile SingularAttribute<PatientPreventiveCare, Date> dateLastDone;
	public static volatile SingularAttribute<PatientPreventiveCare, String> frequency;
	public static volatile SingularAttribute<PatientPreventiveCare, Date> lastUpdatedDate;
	public static volatile SingularAttribute<PatientPreventiveCare, Date> createdDate;
	public static volatile SingularAttribute<PatientPreventiveCare, String> createdBy;
	public static volatile SingularAttribute<PatientPreventiveCare, String> recurringEvent;
	public static volatile SingularAttribute<PatientPreventiveCare, String> reminderEmailDate;
	public static volatile SingularAttribute<PatientPreventiveCare, String> age;
	public static volatile SingularAttribute<PatientPreventiveCare, String> testName;
	public static volatile SingularAttribute<PatientPreventiveCare, String> activeFlag;

}

