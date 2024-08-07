

package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.QuestionGroup;
import com.cpa.ehr.service.system.dto.QuestionGroupDTO;

@Mapper(componentModel = "spring")
public interface QuestionGroupMapper {
	
	public abstract QuestionGroupDTO entityToSystemDTO(QuestionGroup entity);
	
	/**
	 * Maps QuestionGroupDTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of QuestionGroup
	 * @return ActivityType
	 * 		Entity of QuestionGroup
	 */
	public abstract QuestionGroup questionGroupDTOToEntity(QuestionGroupDTO dto);
	
	/**
	 * Maps List of QuestionGroup Entities to DTOs
	 * 
	 * @param entities
	 * 		List of QuestionGroup entities
	 * @return 
	 * 		List of QuestionGroups DTOs
	 */
	public abstract List<QuestionGroupDTO> entityListToQuestionGroupDTOList(List<QuestionGroup> entities);

}
