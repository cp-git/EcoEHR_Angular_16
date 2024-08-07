package com.cpa.ehr.backend.dao.patients.constants;

public class OrdersConstants {
	
	public static final String FIND_ALL = "SELECT * FROM orders o";
	public static final String FIND_ALL_DISTINT = "SELECT * FROM orders o";
	public static final String BY_PATIENT_ID = "o.patient_id = :patientId AND o.active_flag='Y'";
	public static final String FIND_ALL_BY_PATIENT_ID = FIND_ALL + " WHERE " + BY_PATIENT_ID;
	public static final String BY_ENC_ID = "o.encounter_id = :encounterId";
	public static final String FIND_ALL_BY_PATIENT_ID_ENC_ID = FIND_ALL + " WHERE " +BY_ENC_ID+" AND "+BY_PATIENT_ID+" ORDER BY icd10_code";
	
	private OrdersConstants()
	{}
}
