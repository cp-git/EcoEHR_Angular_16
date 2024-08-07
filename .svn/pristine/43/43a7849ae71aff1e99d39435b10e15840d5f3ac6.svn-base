package com.cpa.ehr.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cpa.ehr.service.system.dto.PatientMedicationDTO;
import com.cpa.ehr.service.system.dto.PatientMedicationRecordDTO;

@Service
public interface PatientMedicationService {
	
	PatientMedicationDTO persistPatientMedication(PatientMedicationDTO patientMedicationDTO);
	
	List<PatientMedicationRecordDTO> retrieveAllPatientMedicationRecord(Long patientId);
	
	void inActivePatientMedication(PatientMedicationDTO patientMedication);
	void deletePatientMedication(Long encounterId);
	
	List<PatientMedicationDTO> retrieveAllPatientMedicationByencId(Long encounterId);

}
