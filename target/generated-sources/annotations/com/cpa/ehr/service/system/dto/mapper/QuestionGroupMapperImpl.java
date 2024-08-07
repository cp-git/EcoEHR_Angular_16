package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.QuestionGroup;
import com.cpa.ehr.service.system.dto.QuestionGroupDTO;
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
public class QuestionGroupMapperImpl implements QuestionGroupMapper {

    @Override
    public QuestionGroupDTO entityToSystemDTO(QuestionGroup entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionGroupDTO questionGroupDTO = new QuestionGroupDTO();

        questionGroupDTO.setQuestionGroupId( entity.getQuestionGroupId() );
        questionGroupDTO.setSystemId( entity.getSystemId() );
        questionGroupDTO.setQuestionGroupName( entity.getQuestionGroupName() );
        questionGroupDTO.setQuestionGroupOrder( entity.getQuestionGroupOrder() );
        questionGroupDTO.setQuestionCount( entity.getQuestionCount() );
        questionGroupDTO.setActiveFlag( entity.getActiveFlag() );
        questionGroupDTO.setCreatedDate( entity.getCreatedDate() );
        questionGroupDTO.setCreatedBy( entity.getCreatedBy() );
        questionGroupDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        questionGroupDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        return questionGroupDTO;
    }

    @Override
    public QuestionGroup questionGroupDTOToEntity(QuestionGroupDTO dto) {
        if ( dto == null ) {
            return null;
        }

        QuestionGroup questionGroup = new QuestionGroup();

        questionGroup.setQuestionGroupId( dto.getQuestionGroupId() );
        questionGroup.setSystemId( dto.getSystemId() );
        questionGroup.setQuestionGroupName( dto.getQuestionGroupName() );
        questionGroup.setQuestionGroupOrder( dto.getQuestionGroupOrder() );
        questionGroup.setQuestionCount( dto.getQuestionCount() );
        questionGroup.setActiveFlag( dto.getActiveFlag() );
        questionGroup.setCreatedDate( dto.getCreatedDate() );
        questionGroup.setCreatedBy( dto.getCreatedBy() );
        questionGroup.setLastUpdatedDate( dto.getLastUpdatedDate() );
        questionGroup.setLastUpdatedBy( dto.getLastUpdatedBy() );

        return questionGroup;
    }

    @Override
    public List<QuestionGroupDTO> entityListToQuestionGroupDTOList(List<QuestionGroup> entities) {
        if ( entities == null ) {
            return null;
        }

        List<QuestionGroupDTO> list = new ArrayList<QuestionGroupDTO>();
        for ( QuestionGroup questionGroup : entities ) {
            list.add( entityToSystemDTO( questionGroup ) );
        }

        return list;
    }
}
