package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.entities.EncQuestionOption;
import com.cpa.ehr.service.system.dto.EncQuestionOptionDTO;

@Mapper(componentModel = "spring")
public abstract class EncQuestionOptionMapper {
	@Autowired
	public EncounterRepository encRepo;

	@Mapping(target = "encounterId", expression = "java(entity.getEncounter().getEncounterId())")
	public abstract EncQuestionOptionDTO entityToEncQuestionOptionDTO(EncQuestionOption entity);

	/**
	 * Maps EncQuestionOptionDTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of EncQuestionOption
	 * @return ActivityType
	 * 		Entity of EncQuestionOption
	 */
	@Mapping(target = "encounter", expression = "java(encRepo.findOne(dto.getEncounterId()))")
	public abstract EncQuestionOption encQuestionOptionDTOToEntity(EncQuestionOptionDTO dto);

	/**
	 * Maps List of EncQuestionOption Entities to DTOs
	 * 
	 * @param entities
	 * 		List of EncQuestionOption entities
	 * @return 
	 * 		List of EncQuestionOption DTOs
	 */
	public abstract List<EncQuestionOptionDTO> entityListToEncounterQuestionGroupDTOList(List<EncQuestionOption> entities);

}
