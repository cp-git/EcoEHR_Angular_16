package com.cpa.ehr.backend.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.preventivecare.constants.MasterPreventitiveConstant;
import com.cpa.ehr.backend.dao.preventivecare.entities.MasterPreventiveCare;
import com.cpa.ehr.backend.dao.system.constants.PatientPreventiveConstant;
import com.cpa.ehr.backend.dao.system.entities.PatientPreventiveCare;

@Repository
public interface PatientPreventiveCareRepository  extends JpaRepository<PatientPreventiveCare, Long> 
{
	@Query(value = PatientPreventiveConstant.FIND_BY_PATIENTID, nativeQuery = true)
	List<PatientPreventiveCare> findPatientPrevByPatientId(@Param("patientId") Long patientId);
	

}