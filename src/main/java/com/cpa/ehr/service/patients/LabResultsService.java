package com.cpa.ehr.service.patients;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cpa.ehr.service.patients.dto.LabResultsDTO;
import com.cpa.ehr.service.system.dto.PatientPreventiveCareDTO;

import java.util.List;


public interface LabResultsService {


LabResultsDTO persistLabResults(LabResultsDTO labResultsDTOpersist) ;


  LabResultsDTO retrieveLabResultsById(Long labId);

  List<LabResultsDTO> retrievePatientLabResultsById(Long patientId);


	List<LabResultsDTO> retrieveAllLabResults();


	LabResultsDTO modifyLabResults(LabResultsDTO labResultsDTOUpdate) ;

	 public void deleteById(Long labId);
	}
