package com.cpa.ehr.backend.dao.students.constants;

public class StudentRecordConstants 
{
	public static final String SELECT_ALL_STUDENT ="SELECT * FROM student_details p";
	public static final String BY_STUDENT_ID = "p.student_id = :stuId";
	
	public static final String FIND_STUDENT_BY_STUDENT_ID = SELECT_ALL_STUDENT + " AND " + BY_STUDENT_ID;
	
	private StudentRecordConstants() {
		
	}
}


