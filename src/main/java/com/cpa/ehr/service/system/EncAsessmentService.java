package com.cpa.ehr.service.system;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cpa.ehr.service.system.dto.EncAsessmentDTO;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;

import java.util.List;


public interface EncAsessmentService {


	EncAsessmentDTO persistEncAsessment(EncAsessmentDTO encAsessmentDTOpersist) ;
	EncAsessmentDTO retrieveEncAsessmentById(Long encAsessmentId);
	List<EncAsessmentDTO>getAllEncAssessmentByEncounterId(Long encounterId);
	List<EncAsessmentDTO> retrieveAllEncAsessment();
	

	 public void deleteById(Long encAsessmentId);
	}
