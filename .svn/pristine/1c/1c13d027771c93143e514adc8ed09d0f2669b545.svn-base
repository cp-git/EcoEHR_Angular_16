package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.PatientMedication;
import com.cpa.ehr.backend.dao.system.entities.PatientMedicationRecord;
import com.cpa.ehr.service.system.dto.PatientMedicationDTO;
import com.cpa.ehr.service.system.dto.PatientMedicationRecordDTO;


@Mapper(componentModel = "spring")
public abstract class PatientMedicationRecordMapper {


	public abstract PatientMedicationRecordDTO entitytoPatientMedicationRecordDTO(PatientMedicationRecord entity);
	
	public abstract PatientMedicationRecord patientMedicationRecordDTOtoEntity(PatientMedicationRecordDTO dto);
	
	public abstract List<PatientMedicationRecordDTO> entityListToPatientMedicationRecordDTOList(List<PatientMedicationRecord> entities);
	
}
