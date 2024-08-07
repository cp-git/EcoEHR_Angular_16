package com.cpa.ehr.service.students;

import java.util.List;

import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;
import com.google.gson.Gson;

/**
 * Interface PatientDetails Service holds all the interfaces supported for
 * performing CRUD operations against PatientDetails Entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

public interface StudentDetailsService {
	StudentDetailsDTO persistStudentDetails(StudentDetailsDTO studentDetailsDTO);
	
	List<StudentDetailsDTO> retrieveAllStudents();

	StudentRecordDTO retrieveStudentRecordStudentId(Long stuId);

	StudentDetailsDTO retrieveStudentDetailsStudentId(Long stuId);

	StudentDetailsDTO modifyStudentDetails(StudentDetailsDTO studentDetailsDTO);

	List<StudentRecordDTO> retrieveAllActiveStudents();
}
