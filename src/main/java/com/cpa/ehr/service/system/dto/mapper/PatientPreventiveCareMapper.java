package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.ehr.backend.dao.system.entities.PatientAllergy;
import com.cpa.ehr.backend.dao.system.entities.PatientPreventiveCare;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
import com.cpa.ehr.service.system.dto.PatientPreventiveCareDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class PatientPreventiveCareMapper {

	// This will build a fresh new PatientPreventiveCareDTO with in infos
		
//public abstract  PatientPreventiveCareDTO convertEntityToPatientPreventiveCareDTO(PatientPreventiveCare entity);
	
//public abstract  PatientPreventiveCare  convertPatientPreventiveCareDTOToEntity( PatientPreventiveCareDTO dto);
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract  PatientPreventiveCareDTO convertEntityToPatientPreventiveCareDTO(PatientPreventiveCare entity);
	
	
	

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
    public abstract  PatientPreventiveCare  convertPatientPreventiveCareDTOToEntity( PatientPreventiveCareDTO dto);



public abstract List<PatientPreventiveCareDTO>  entityListToPatientPreventiveCareDTOList(List<PatientPreventiveCare> list);
}
