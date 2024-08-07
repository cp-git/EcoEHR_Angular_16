package com.cpa.ehr.backend.dao.students.constants;

public class StudentValidationConstants 
{
	public static final String FIND_ALL_STUDENTV = "SELECT * FROM student_details vv";

	public static final String BY_STUDENT_USERNAME = "vv.student_user_name = :userName";
	public static final String BY_STUDENT_PASSWORD = "vv.student_password = :password";

	public static final String FIND_BY_USERNAME =  FIND_ALL_STUDENTV + " AND " + BY_STUDENT_USERNAME + " AND " + BY_STUDENT_PASSWORD;
	private StudentValidationConstants() 
	{
		
	}
}



