package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.ehr.backend.dao.system.entities.EncAsessment;
import com.cpa.ehr.service.system.dto.EncAsessmentDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class EncAsessmentMapper {

	// This will build a fresh new EncAsessmentDTO with in infos
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
public abstract  EncAsessmentDTO convertEntityToEncAsessmentDTO(EncAsessment entity);
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
public abstract  EncAsessment  convertEncAsessmentDTOToEntity( EncAsessmentDTO dto);



public abstract List<EncAsessmentDTO>  entityListToEncAsessmentDTOList(List<EncAsessment> list);
}
