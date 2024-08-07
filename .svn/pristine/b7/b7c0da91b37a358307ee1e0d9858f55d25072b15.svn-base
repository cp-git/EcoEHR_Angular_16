package com.cpa.ehr.backend.dao.patients;


import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.patients.constants.PatientLabResultsConstant;
import com.cpa.ehr.backend.dao.patients.entities.LabResults;
import com.cpa.ehr.backend.dao.system.constants.PatientPreventiveConstant;
import com.cpa.ehr.backend.dao.system.entities.PatientPreventiveCare;

/**
 * Jpa repository for LabResults.
 * @author Somesh Biswas version 3.0.0
 */
@Transactional
@Repository
public interface LabResultsRepository  extends JpaRepository<LabResults, Long> {
	
	@Query(value = PatientLabResultsConstant.FIND_BY_PATIENTID, nativeQuery = true)
	List<LabResults> findPatientLabResultsByPatientId(@Param("patientId") Long patientId);
	
}