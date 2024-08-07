package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.system.entities.PatientAllergy;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;


@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public interface PatientAllergyMapper {


	// This will build a fresh new PatientAllergyDTO with in infos
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract  PatientAllergyDTO convertEntityToPatientAllergyDTO(PatientAllergy entity);
	
	
	

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
    public abstract  PatientAllergy  convertPatientAllergyDTOToEntity( PatientAllergyDTO dto);



public abstract List<PatientAllergyDTO>  entityListToPatientAllergyDTOList(List<PatientAllergy> list);
}
