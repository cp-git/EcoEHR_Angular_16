package com.cpa.ehr.service.patients;

import java.util.Date;
import java.util.List;

import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;


/**
 * Interface PatientDetails Service holds all the interfaces
 * supported for performing CRUD operations against 
 * PatientDetails Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public interface PatientDetailsService {

	PatientDetailsDTO persistPatientDetails(PatientDetailsDTO patientDetailsDTO);

	List<PatientDetailsDTO> retrieveAllPatients();

	PatientRecordDTO retrievePatientRecordPatientId(Long patientId,Long orgId);
	
	PatientDetailsDTO retrievePatientDetailsPatientId(Long patientId);

	PatientDetailsDTO modifyPatientDetails(PatientDetailsDTO patientDetailsDTO);
	
	List<PatientRecordDTO> retrieveAllActivePatients(Long orgId);
	
	List<PatientRecordDTO> retrieveAllActivePatientsByUserId(String userName , Date lastLoginDate);
}