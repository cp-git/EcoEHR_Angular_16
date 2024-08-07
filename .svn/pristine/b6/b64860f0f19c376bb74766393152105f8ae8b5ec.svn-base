package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.cpa.ehr.backend.dao.patients.PatientDetailsRepository;
import com.cpa.ehr.backend.dao.system.MedicationRepository;
import com.cpa.ehr.backend.dao.system.entities.PatientMedication;
import com.cpa.ehr.service.system.dto.PatientMedicationDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class PatientMedicationMapper {
	@Autowired
	public PatientDetailsRepository patientRepo;
	
	@Autowired
	public MedicationRepository medRepo;
	
	@Mapping(target = "medicationId", expression = "java(entity.getMedication().getMedicationId())")
	@Mapping(target = "patientId", expression = "java(entity.getPatientDetails().getPatientId())")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract PatientMedicationDTO entitytoPatientMedicationDTO(PatientMedication entity);
	
	@Mapping(target = "medication", expression = "java(medRepo.findOne(dto.getMedicationId()))")
	@Mapping(target = "patientDetails", expression = "java(patientRepo.findOne(dto.getPatientId()))")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract PatientMedication patientMedicationDTOtoEntity(PatientMedicationDTO dto);
	
	public abstract List<PatientMedicationDTO> entityListToPatientMedicationDTOList(List<PatientMedication> entities);
	
}