package com.cpa.ehr.backend.dao.system.entities;

import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientMedication.class)
public abstract class PatientMedication_ {

	public static volatile SingularAttribute<PatientMedication, String> icd10Code;
	public static volatile SingularAttribute<PatientMedication, String> lastUpdatedBy;
	public static volatile SingularAttribute<PatientMedication, String> discontinueReason;
	public static volatile SingularAttribute<PatientMedication, Date> endDate;
	public static volatile SingularAttribute<PatientMedication, String> isActiveMedication;
	public static volatile SingularAttribute<PatientMedication, PatientDetails> patientDetails;
	public static volatile SingularAttribute<PatientMedication, Medication> medication;
	public static volatile SingularAttribute<PatientMedication, Long> patientMedicationId;
	public static volatile SingularAttribute<PatientMedication, Long> encounterId;
	public static volatile SingularAttribute<PatientMedication, String> frequency;
	public static volatile SingularAttribute<PatientMedication, String> medicationNotes;
	public static volatile SingularAttribute<PatientMedication, Date> lastUpdatedDate;
	public static volatile SingularAttribute<PatientMedication, Long> medicationDuration;
	public static volatile SingularAttribute<PatientMedication, Date> createdDate;
	public static volatile SingularAttribute<PatientMedication, String> createdBy;
	public static volatile SingularAttribute<PatientMedication, Long> refillCount;
	public static volatile SingularAttribute<PatientMedication, Date> discontinuedDate;
	public static volatile SingularAttribute<PatientMedication, Date> startDate;
	public static volatile SingularAttribute<PatientMedication, String> activeFlag;

}

