package com.cpa.ehr.backend.dao.students;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.backend.dao.students.constants.StudentDetailsConstants;
import com.cpa.ehr.backend.dao.students.entities.StudentDetails;


@Repository
@Transactional

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long>
{
	@Query(value = StudentDetailsConstants.FIND_ALL_STUDENT, nativeQuery = true)
	List<StudentDetails> findAllStudents();
	
	@Query(value = StudentDetailsConstants.FIND_STUDENT_BY_STUDENT_ID, nativeQuery = true)
	StudentDetails findStudentDetailsByStudentId(@Param("stuId")Long stuId);
}





	
	
	
	




