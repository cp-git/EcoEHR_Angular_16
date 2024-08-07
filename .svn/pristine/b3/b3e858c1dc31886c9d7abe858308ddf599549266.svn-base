package com.cpa.ehr.backend.dao.system.constants;

public class ChiefCompliantDetailsConstants {
	
	public static final String FIND_ALL = "Select * from chief_compliant_dtl e";
	public static final String BY_ENCOUNTER_ID = "e.encounter_id = :encounterId";
	public static final String FIND_ALL_BY_ENCOUNTER_ID = FIND_ALL + " WHERE " + BY_ENCOUNTER_ID + " ORDER BY e.primary_flag DESC" ;
	public static final String FIND_ICD10_DETAILS = "select * from ehr.chief_compliant_dtl where encounter_id IN " + 
													"(select distinct ch.encounter_id from ehr.chief_compliant_dtl ch, ehr.encounter e " + 
													"WHERE ch.encounter_id=e.encounter_id AND e.patient_id = :patientId order by ch.encounter_id desc limit 5)";
	public static final String FIND_ICD_10="select * from chief_compliant_dtl where icd10_code = :icd10Code AND encounter_id = :encounterId";
	private ChiefCompliantDetailsConstants() {
		
	}
}
