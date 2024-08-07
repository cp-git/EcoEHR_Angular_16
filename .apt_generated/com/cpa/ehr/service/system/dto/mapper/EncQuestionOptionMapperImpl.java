package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.EncQuestionOption;
import com.cpa.ehr.service.system.dto.EncQuestionOptionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T01:39:11+0530",
    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.13.50.v20171007-0855, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class EncQuestionOptionMapperImpl extends EncQuestionOptionMapper {

    @Override
    public EncQuestionOptionDTO entityToEncQuestionOptionDTO(EncQuestionOption entity) {
        if ( entity == null ) {
            return null;
        }

        EncQuestionOptionDTO encQuestionOptionDTO = new EncQuestionOptionDTO();

        encQuestionOptionDTO.setQuestionGroupId( entity.getQuestionGroupId() );
        encQuestionOptionDTO.setEncQuestionOptionId( entity.getEncQuestionOptionId() );
        encQuestionOptionDTO.setQuestionId( entity.getQuestionId() );
        encQuestionOptionDTO.setSystemId( entity.getSystemId() );
        encQuestionOptionDTO.setOptionId( entity.getOptionId() );
        encQuestionOptionDTO.setOptionValue( entity.getOptionValue() );
        encQuestionOptionDTO.setAnswer( entity.getAnswer() );
        encQuestionOptionDTO.setCreatedDate( entity.getCreatedDate() );
        encQuestionOptionDTO.setCreatedBy( entity.getCreatedBy() );
        encQuestionOptionDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        encQuestionOptionDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        encQuestionOptionDTO.setAnswerComments( entity.getAnswerComments() );

        encQuestionOptionDTO.setEncounterId( entity.getEncounter().getEncounterId() );

        return encQuestionOptionDTO;
    }

    @Override
    public EncQuestionOption encQuestionOptionDTOToEntity(EncQuestionOptionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EncQuestionOption encQuestionOption = new EncQuestionOption();

        encQuestionOption.setEncQuestionOptionId( dto.getEncQuestionOptionId() );
        encQuestionOption.setQuestionGroupId( dto.getQuestionGroupId() );
        encQuestionOption.setQuestionId( dto.getQuestionId() );
        encQuestionOption.setSystemId( dto.getSystemId() );
        encQuestionOption.setOptionId( dto.getOptionId() );
        encQuestionOption.setOptionValue( dto.getOptionValue() );
        encQuestionOption.setAnswer( dto.getAnswer() );
        encQuestionOption.setCreatedDate( dto.getCreatedDate() );
        encQuestionOption.setCreatedBy( dto.getCreatedBy() );
        encQuestionOption.setLastUpdatedDate( dto.getLastUpdatedDate() );
        encQuestionOption.setLastUpdatedBy( dto.getLastUpdatedBy() );
        encQuestionOption.setAnswerComments( dto.getAnswerComments() );

        encQuestionOption.setEncounter( encRepo.findOne(dto.getEncounterId()) );

        return encQuestionOption;
    }

    @Override
    public List<EncQuestionOptionDTO> entityListToEncounterQuestionGroupDTOList(List<EncQuestionOption> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EncQuestionOptionDTO> list = new ArrayList<EncQuestionOptionDTO>();
        for ( EncQuestionOption encQuestionOption : entities ) {
            list.add( entityToEncQuestionOptionDTO( encQuestionOption ) );
        }

        return list;
    }
}
