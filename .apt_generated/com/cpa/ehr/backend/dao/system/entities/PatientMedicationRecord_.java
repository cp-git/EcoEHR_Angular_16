package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientMedicationRecord.class)
public abstract class PatientMedicationRecord_ {

	public static volatile SingularAttribute<PatientMedicationRecord, String> icd10Code;
	public static volatile SingularAttribute<PatientMedicationRecord, String> providerLastName;
	public static volatile SingularAttribute<PatientMedicationRecord, Long> patientId;
	public static volatile SingularAttribute<PatientMedicationRecord, Date> endDate;
	public static volatile SingularAttribute<PatientMedicationRecord, String> npiNumber;
	public static volatile SingularAttribute<PatientMedicationRecord, String> clinicLocationName;
	public static volatile SingularAttribute<PatientMedicationRecord, String> patientMiddleName;
	public static volatile SingularAttribute<PatientMedicationRecord, Long> encounterId;
	public static volatile SingularAttribute<PatientMedicationRecord, String> productName;
	public static volatile SingularAttribute<PatientMedicationRecord, String> frequency;
	public static volatile SingularAttribute<PatientMedicationRecord, String> patientLastName;
	public static volatile SingularAttribute<PatientMedicationRecord, Long> medicationId;
	public static volatile SingularAttribute<PatientMedicationRecord, String> activeFlag;
	public static volatile SingularAttribute<PatientMedicationRecord, String> discontinueReason;
	public static volatile SingularAttribute<PatientMedicationRecord, String> isActiveMedication;
	public static volatile SingularAttribute<PatientMedicationRecord, String> patientFirstName;
	public static volatile SingularAttribute<PatientMedicationRecord, Long> patientMedicationId;
	public static volatile SingularAttribute<PatientMedicationRecord, String> providerMiddleName;
	public static volatile SingularAttribute<PatientMedicationRecord, String> schedule;
	public static volatile SingularAttribute<PatientMedicationRecord, String> dose;
	public static volatile SingularAttribute<PatientMedicationRecord, Long> medicationDuration;
	public static volatile SingularAttribute<PatientMedicationRecord, String> route;
	public static volatile SingularAttribute<PatientMedicationRecord, String> form;
	public static volatile SingularAttribute<PatientMedicationRecord, Long> refillCount;
	public static volatile SingularAttribute<PatientMedicationRecord, String> providerFirstName;
	public static volatile SingularAttribute<PatientMedicationRecord, Date> discontinuedDate;
	public static volatile SingularAttribute<PatientMedicationRecord, Date> startDate;

}

