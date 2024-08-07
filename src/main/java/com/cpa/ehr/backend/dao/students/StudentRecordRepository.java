package com.cpa.ehr.backend.dao.students;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.students.constants.StudentRecordConstants;
import com.cpa.ehr.backend.dao.students.entities.StudentRecord;


@Repository
@Transactional

public interface StudentRecordRepository extends JpaRepository<StudentRecord, Long>
{
	@Query(value = StudentRecordConstants.SELECT_ALL_STUDENT, nativeQuery = true)
	List<StudentRecord> findAllActiveStudentsfromView();
	
	@Query(value = StudentRecordConstants.FIND_STUDENT_BY_STUDENT_ID, nativeQuery = true)
	StudentRecord findStudentRecordByStudentId(@Param("stuId")Long stuId);

}



