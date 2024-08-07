package com.cpa.ehr.backend.dao.patients;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cpa.ehr.backend.dao.patients.constants.PatientDetailsConstants;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;


@Repository
@Transactional
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {
	
	@Query(value = PatientDetailsConstants.FIND_ALL_BY_ACTIVE_FLAG, nativeQuery = true)
	List<PatientDetails> findAllPatients();
	
	@Query(value = PatientDetailsConstants.FIND_PATIENT_BY_PATIENT_ID, nativeQuery = true)
	PatientDetails findPatientDetailsByPatientId(@Param("patientId")Long patientId);
	
	@Query(value = PatientDetailsConstants.FIND_ALL_PATIENTS_BY_CLINIC_LOC_ID, nativeQuery = true)
	List<PatientDetails> getPatientsByClinicLocId(@Param("staffAddressId") Long staffAddressId);
	
	@Query(value = PatientDetailsConstants.FIND_ALL_PATIENTS_BY_STAFF_ID, nativeQuery = true)
	List<PatientDetails> getPatientsByStaffId(@Param("staffId") Long staffId);
}