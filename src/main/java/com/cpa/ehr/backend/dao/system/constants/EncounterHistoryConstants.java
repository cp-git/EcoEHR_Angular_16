package com.cpa.ehr.backend.dao.system.constants;

public class EncounterHistoryConstants {

//	public static final String FIND_ALL = "SELECT sys_id,sys_type,sys_desc,string_agg(question_group_name,'`')AS question_group_name_list," + 
//			"string_agg(CAST(question_desc AS VARCHAR),'`') as question_desc_list,string_agg(question_type,'`') AS question_type_list," + 
//			"string_agg((CASE WHEN answer ISNULL THEN 'NULL' ELSE answer END),'`' )AS answer_list," + 
//			"string_agg((CASE WHEN option_value ISNULL THEN 'NULL' ELSE option_value END),'`' ) AS option_value_list," + 
//			"string_agg(CAST(question_id AS VARCHAR),'`' ) AS question_id_list "+
//			"FROM ehr.encounter_history_vw WHERE encounter_id = :encounterId " + 
//			"GROUP BY 1,2,3 ORDER BY sys_id";
	
//	public static final String FIND_ALL = "SELECT * FROM ehr.encounter_history_vw WHERE encounter_id = :encounterId ORDER BY sys_id,question_group_id";
	
	public static final String FIND_ALL ="SELECT * FROM ehr.encounter_history_vw WHERE encounter_id = :encounterId ORDER BY sys_id,question_group_id, question_type desc , option_value desc"; 

	private EncounterHistoryConstants() {
		
	}
}