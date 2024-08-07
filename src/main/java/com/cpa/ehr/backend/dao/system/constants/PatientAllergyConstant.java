package com.cpa.ehr.backend.dao.system.constants;

public class PatientAllergyConstant {

	
public static final String FIND_ALL = "SELECT * FROM patient_allergy WHERE patient_id = :patientId AND active_flag='Y' ";
	
	private PatientAllergyConstant() {
		
	}
	
}
