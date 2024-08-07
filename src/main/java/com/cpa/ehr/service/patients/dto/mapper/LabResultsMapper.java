package com.cpa.ehr.service.patients.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.cpa.ehr.backend.dao.patients.entities.LabResults;
import com.cpa.ehr.service.patients.dto.LabResultsDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class LabResultsMapper {

	// This will build a fresh new LabResultsDTO with in infos
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract  LabResultsDTO convertEntityToLabResultsDTO(LabResults entity);
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract  LabResults  convertLabResultsDTOToEntity( LabResultsDTO dto);

	public abstract List<LabResultsDTO>  entityListToLabResultsDTOList(List<LabResults> list);
}
