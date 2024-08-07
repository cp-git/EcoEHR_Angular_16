package com.cpa.ehr.backend.dao.system.constants;

public class PatientMedicationConstants {
	
	
	
	private PatientMedicationConstants(){
		
	}
	public static final String SELECTPMBYENCID = "SELECT * FROM patient_medication s WHERE s.encounter_id=:encounterId AND s.active_flag='Y'";
	
	public static final String SELECTACTIVEPMBYENCID = "SELECT * FROM patient_medication s WHERE s.encounter_id=:encounterId AND s.is_active_medication='Y' AND s.active_flag='Y'";
	
	public static final String SELECTINACTIVEPMBYENCID = "SELECT * FROM patient_medication s WHERE s.encounter_id=:encounterId AND s.is_active_medication='N' AND s.active_flag='Y'";

}
