package com.cpa.ehr.backend.dao.students.constants;

public class StudentDetailsConstants 
{
	public static final String FIND_ALL_STUDENT = "SELECT * FROM student_details dd";

	public static final String BY_STUDENT_ID = "dd.student_id = :stuId";
	public static final String FIND_STUDENT_BY_STUDENT_ID =  FIND_ALL_STUDENT + " AND " + BY_STUDENT_ID;
	private StudentDetailsConstants() {
		
	}
}



