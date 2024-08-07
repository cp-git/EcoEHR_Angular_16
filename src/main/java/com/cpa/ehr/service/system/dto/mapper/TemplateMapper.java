package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.ehr.backend.dao.system.entities.Template;
import com.cpa.ehr.service.system.dto.TemplateDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public interface TemplateMapper {
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract TemplateDTO entityToTemplateDTO(Template entity);
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract Template templateDTOToEntity(TemplateDTO dto);
	
	
	
	public abstract List<TemplateDTO> entityListToTemplateDTOList(List<Template> entities);
}