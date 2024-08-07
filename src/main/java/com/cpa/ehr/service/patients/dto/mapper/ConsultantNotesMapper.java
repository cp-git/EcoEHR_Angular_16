package com.cpa.ehr.service.patients.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.ehr.backend.dao.patients.entities.ConsultantNotes;
import com.cpa.ehr.service.patients.dto.ConsultantNotesDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class ConsultantNotesMapper {

	// This will build a fresh new ConsultantNotesDTO with in infos
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract  ConsultantNotesDTO convertEntityToConsultantNotesDTO(ConsultantNotes entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
public abstract  ConsultantNotes  convertConsultantNotesDTOToEntity( ConsultantNotesDTO dto);



public abstract List<ConsultantNotesDTO>  entityListToConsultantNotesDTOList(List<ConsultantNotes> list);
}
