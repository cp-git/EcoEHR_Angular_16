
package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.entities.EncounterQuestionGroup;
import com.cpa.ehr.service.system.dto.EncounterQuestionGroupDTO;


@Mapper(componentModel = "spring")
public abstract class EncounterQuestionGroupMapper {
	@Autowired
	public EncounterRepository encRepo;

	@Mapping(target = "encounterId", expression = "java(entity.getEncounter().getEncounterId())")
	public abstract EncounterQuestionGroupDTO entityToEncounterQuestionGroupDTO(EncounterQuestionGroup entity);

	/**
	 * Maps EncounterQuestionGroupDTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of EncounterQuestionGroup
	 * @return ActivityType
	 * 		Entity of EncounterQuestionGroup
	 */
	@Mapping(target = "encounter", expression = "java(encRepo.findOne(dto.getEncounterId()))")
	public abstract EncounterQuestionGroup encounterQuestionGroupDTOToEntity(EncounterQuestionGroupDTO dto);

	/**
	 * Maps List of EncounterQuestionGroup Entities to DTOs
	 * 
	 * @param entities
	 * 		List of EncounterQuestionGroup entities
	 * @return 
	 * 		List of EncounterQuestionGroup DTOs
	 */
	public abstract List<EncounterQuestionGroupDTO> entityListToEncounterQuestionGroupDTOList(List<EncounterQuestionGroup> entities);

}
