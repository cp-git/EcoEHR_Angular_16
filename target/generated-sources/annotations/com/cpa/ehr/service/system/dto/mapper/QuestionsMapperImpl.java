package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.Questions;
import com.cpa.ehr.service.system.dto.QuestionsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-05T12:37:53+0530",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class QuestionsMapperImpl implements QuestionsMapper {

    @Override
    public QuestionsDTO entityToQuestionsDTO(Questions entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionsDTO questionsDTO = new QuestionsDTO();

        questionsDTO.setQuestionId( entity.getQuestionId() );
        questionsDTO.setSystemId( entity.getSystemId() );
        questionsDTO.setQuestionGroupId( entity.getQuestionGroupId() );
        questionsDTO.setQuestionDesc( entity.getQuestionDesc() );
        questionsDTO.setQuestionType( entity.getQuestionType() );
        questionsDTO.setQuestionDispType( entity.getQuestionDispType() );
        questionsDTO.setQuestionOrder( entity.getQuestionOrder() );
        questionsDTO.setMandatoryFlag( entity.getMandatoryFlag() );
        questionsDTO.setOptionsCount( entity.getOptionsCount() );
        questionsDTO.setActiveFlag( entity.getActiveFlag() );
        questionsDTO.setCreatedDate( entity.getCreatedDate() );
        questionsDTO.setCreatedBy( entity.getCreatedBy() );
        questionsDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        questionsDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        return questionsDTO;
    }

    @Override
    public Questions questionsDTOToEntity(QuestionsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Questions questions = new Questions();

        questions.setQuestionId( dto.getQuestionId() );
        questions.setSystemId( dto.getSystemId() );
        questions.setQuestionGroupId( dto.getQuestionGroupId() );
        questions.setQuestionDesc( dto.getQuestionDesc() );
        questions.setQuestionType( dto.getQuestionType() );
        questions.setQuestionDispType( dto.getQuestionDispType() );
        questions.setQuestionOrder( dto.getQuestionOrder() );
        questions.setMandatoryFlag( dto.getMandatoryFlag() );
        questions.setOptionsCount( dto.getOptionsCount() );
        questions.setActiveFlag( dto.getActiveFlag() );
        questions.setCreatedDate( dto.getCreatedDate() );
        questions.setCreatedBy( dto.getCreatedBy() );
        questions.setLastUpdatedDate( dto.getLastUpdatedDate() );
        questions.setLastUpdatedBy( dto.getLastUpdatedBy() );

        return questions;
    }

    @Override
    public List<QuestionsDTO> entityListToQuestionsDTOList(List<Questions> entities) {
        if ( entities == null ) {
            return null;
        }

        List<QuestionsDTO> list = new ArrayList<QuestionsDTO>();
        for ( Questions questions : entities ) {
            list.add( entityToQuestionsDTO( questions ) );
        }

        return list;
    }
}
