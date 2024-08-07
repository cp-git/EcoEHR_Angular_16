package com.cpa.ehr.service.students;
import java.util.List;

import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;


/**
 * Interface PatientDetails Service holds all the interfaces
 * supported for performing CRUD operations against 
 * PatientDetails Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

public interface StudentValidationService 
{

	//StudentDetailsDTO CheckUsernamePassword();
	StudentDetailsDTO CheckUsernamePassword(String userName,String password);

}








