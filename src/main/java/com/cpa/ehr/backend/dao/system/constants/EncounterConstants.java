package com.cpa.ehr.backend.dao.system.constants;

public class EncounterConstants {
	
	public static final String FIND_ALL = "Select * from encounter e";
	public static final String BY_PATIENT_ID = "e.patient_id = :patientId AND e.active_flag = 'Y'";
	public static final String FIND_ALL_BY_PATIENT_ID = FIND_ALL + " WHERE " + BY_PATIENT_ID + " ORDER BY e.encounter_date DESC";
	
	public static final String BY_USER_ID = "e. staffId= :staffId AND created_date > :lastLoginDate ";
	public static final String FIND_ALL_BY_PATIENT_ID_STUD = FIND_ALL+" WHERE "+BY_USER_ID + " ORDER BY e.encounter_date DESC";
	
	private EncounterConstants() {
		
	}
}