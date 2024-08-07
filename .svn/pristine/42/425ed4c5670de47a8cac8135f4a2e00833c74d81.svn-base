package com.cpa.ehr.backend.dao.system.constants;

public class EncQuestionOptionConstants {
	
	public static final String DELETE_BY_ENCID = "DELETE FROM ehr.enc_question_option WHERE enc_question_option_id in (SELECT enc_question_option_id FROM ehr.enc_question_option eqo, ehr.system s WHERE eqo.sys_id = s.sys_id and eqo.encounter_id =:encounterId AND s.sys_type= :sysType)";
	
	private EncQuestionOptionConstants() {
		
	}
}
