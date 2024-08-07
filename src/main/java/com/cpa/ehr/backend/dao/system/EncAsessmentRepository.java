package com.cpa.ehr.backend.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpa.ehr.backend.dao.system.constants.EncAssessmentConstant;
import com.cpa.ehr.backend.dao.system.entities.EncAsessment;

public interface EncAsessmentRepository extends JpaRepository<EncAsessment, Long>{
	
	@Query(value = EncAssessmentConstant.FIND_ALL_BY_ENCID, nativeQuery = true)
	List<EncAsessment> getAllEncAssessmentByEncounterId(@Param("encounterId") Long encounterId);
}

