package com.cpa.ehr.backend.dao.students;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.students.constants.StudentValidationConstants;

import com.cpa.ehr.backend.dao.students.entities.StudentDetails;



@Repository
@Transactional
public interface StudentValidationRepository extends JpaRepository<StudentDetails, Long>{

	@Query(value = StudentValidationConstants.FIND_BY_USERNAME, nativeQuery = true)
	StudentDetails findStudentValidationByUserName(@Param("userName")String userName,@Param("password")String password);

//	void save(String userName,String password);
}
	





