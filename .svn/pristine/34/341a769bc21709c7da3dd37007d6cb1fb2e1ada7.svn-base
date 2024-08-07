package com.cpa.ehr.backend.dao.patients.constants;

public class PatientDetailsConstants {
	
	public static final String FIND_ALL = "SELECT * FROM patient_details d";
	public static final String BY_ACTIVE_FLAG = "d.active_flag = 'Y'";
	public static final String FIND_ALL_BY_ACTIVE_FLAG = FIND_ALL + " WHERE " + BY_ACTIVE_FLAG;
	public static final String BY_PATIENT_ID = "d.patient_id = :patientId";
	public static final String FIND_PATIENT_BY_PATIENT_ID = FIND_ALL_BY_ACTIVE_FLAG + " AND " + BY_PATIENT_ID;
	public static final String BY_CLINIC_LOC_ID = " d.location_id = :staffAddressId";
	public static final String FIND_ALL_PATIENTS_BY_CLINIC_LOC_ID = FIND_ALL + " WHERE "+ BY_CLINIC_LOC_ID;
	public static final String BY_STAFF_ID = " d.staff_id = :staffId";
	public static final String FIND_ALL_PATIENTS_BY_STAFF_ID = FIND_ALL + " WHERE " + BY_STAFF_ID;
	private PatientDetailsConstants() {
		
	}
}
