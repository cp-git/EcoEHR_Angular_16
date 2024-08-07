package com.cpa.ehr.backend.dao.patients;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.patients.constants.PatientRecordConstants;
import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;


@Repository
@Transactional
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
	

	@Query(value = PatientRecordConstants.SELECT_ALL_PATIENT, nativeQuery = true)
	List<PatientRecord> findAllActivePatientsfromView(@Param("organizationId") Long organizationId);
	
	@Query(value = PatientRecordConstants.FIND_PATIENT_BY_USER_ID, nativeQuery = true)
	List<PatientRecord> findAllActivePatientsByUserId(@Param("userName") String userName, @Param("lastLoginDate") Date lastLoginDate);
	
	@Query(value = PatientRecordConstants.FIND_PATIENT_BY_PATIENT_ID, nativeQuery = true)
	PatientRecord findPatientRecordByPatientId(@Param("patientId")Long patientId,@Param("organizationId") Long organizationId);
}