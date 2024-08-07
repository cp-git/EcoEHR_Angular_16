package com.cpa.ehr.backend.dao.system.constants;

public class QuestionConstants {
	
	public static final String FIND_ALL_COMMON_QUESTIONS = "SELECT * FROM(SELECT question_option.option_id,question.question_id,question.sys_id,question.question_group_id,question.question_desc," + 
			"question_option.option_name,question.question_type FROM question LEFT JOIN question_option " + 
			"ON question_option.question_id = question.question_id " + 
			"WHERE question_option.question_id IS NULL " + 
			"UNION " + 
			"SELECT question_option.option_id,question.question_id,question.sys_id,question.question_group_id,question.question_desc," + 
			"question_option.option_name,question.question_type FROM question INNER JOIN question_option " + 
			"ON question.question_id = question_option.question_id " + 
			"AND question.sys_id = question_option.sys_id AND question.active_flag='Y' AND question_option.active_flag='Y') " + 
			"a WHERE a.sys_id=:systemId ORDER BY a.question_id,a.option_id";
	
	
	public static final String FIND_ALL_COMMON_QUESTIONS_FAMILY = "SELECT * FROM(SELECT question_option.option_id,question.question_id,question.sys_id,question.question_group_id,question.question_desc," + 
			"question_option.option_name,question.question_type FROM question LEFT JOIN question_option " + 
			"ON question_option.question_id = question.question_id " + 
			"WHERE question_option.question_id IS NULL " + 
			"UNION " + 
			"SELECT question_option.option_id,question.question_id,question.sys_id,question.question_group_id,question.question_desc," + 
			"question_option.option_name,question.question_type FROM question INNER JOIN question_option " + 
			"ON question.question_id = question_option.question_id " + 
			"AND question.sys_id = question_option.sys_id AND question.active_flag='Y' AND question_option.active_flag='Y') " + 
			"a WHERE a.sys_id=:systemId ORDER BY a.question_id,a.option_id LIMIT 8";
	
	private QuestionConstants() {
		
	}
}
