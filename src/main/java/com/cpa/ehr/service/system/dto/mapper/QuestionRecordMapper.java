package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.QuestionRecord;
import com.cpa.ehr.service.system.dto.QuestionRecordDTO;

@Mapper(componentModel = "spring")
public interface QuestionRecordMapper {
	
	public abstract QuestionRecordDTO entityToSystemDTO(QuestionRecord entity);
	
	public abstract QuestionRecord questionRecordDTOToEntity(QuestionRecordDTO dto);
	
	public abstract List<QuestionRecordDTO> entityListToQuestionRecordDTOList(List<QuestionRecord> entities);
}
