package com.cpa.ehr.backend.dao.patients.constants;

public class PatientRecordConstants {
	

	public static final String SELECT_ALL_PATIENT ="SELECT * FROM patient_vw s WHERE s.active_flag='Y' AND s.organization_id = :organizationId ";
	public static final String BY_PATIENT_ID = "s.patient_id = :patientId";
	
	public static final String FIND_PATIENT_BY_PATIENT_ID = SELECT_ALL_PATIENT + " AND " + BY_PATIENT_ID;
	
	
	public static final String SELECT_ALL_PATIENT_USER_ID ="SELECT * FROM patient_vw s WHERE s.active_flag='Y' AND s.created_by = :userName AND s.created_date > :lastLoginDate";
	public static final String FIND_PATIENT_BY_USER_ID = SELECT_ALL_PATIENT_USER_ID;
	
	private PatientRecordConstants() {
		
	}
}
