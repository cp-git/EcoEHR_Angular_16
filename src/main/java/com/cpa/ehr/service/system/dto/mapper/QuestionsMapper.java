package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.Questions;
import com.cpa.ehr.service.system.dto.QuestionsDTO;

@Mapper(componentModel = "spring")
public interface QuestionsMapper {
	
	public abstract QuestionsDTO entityToQuestionsDTO(Questions entity);
	
	public abstract Questions questionsDTOToEntity(QuestionsDTO dto);
	
	public abstract List<QuestionsDTO> entityListToQuestionsDTOList(List<Questions> entities);
}
