package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.OptionRecord;
import com.cpa.ehr.backend.dao.system.entities.QuestionRecord;
import com.cpa.ehr.service.system.dto.QuestionRecordDTO;
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
public class QuestionRecordMapperImpl implements QuestionRecordMapper {

    @Override
    public QuestionRecordDTO entityToSystemDTO(QuestionRecord entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionRecordDTO questionRecordDTO = new QuestionRecordDTO();

        List<OptionRecord> list = entity.getOptionRecord();
        if ( list != null ) {
            questionRecordDTO.setOptionRecord(       new ArrayList<OptionRecord>( list )
            );
        }
        questionRecordDTO.setQuestionId( entity.getQuestionId() );
        questionRecordDTO.setSystemId( entity.getSystemId() );
        questionRecordDTO.setQuestionGroupId( entity.getQuestionGroupId() );
        questionRecordDTO.setQuestionDesc( entity.getQuestionDesc() );
        questionRecordDTO.setOptionType( entity.getOptionType() );

        return questionRecordDTO;
    }

    @Override
    public QuestionRecord questionRecordDTOToEntity(QuestionRecordDTO dto) {
        if ( dto == null ) {
            return null;
        }

        QuestionRecord questionRecord = new QuestionRecord();

        List<OptionRecord> list = dto.getOptionRecord();
        if ( list != null ) {
            questionRecord.setOptionRecord(       new ArrayList<OptionRecord>( list )
            );
        }
        questionRecord.setQuestionId( dto.getQuestionId() );
        questionRecord.setSystemId( dto.getSystemId() );
        questionRecord.setQuestionGroupId( dto.getQuestionGroupId() );
        questionRecord.setQuestionDesc( dto.getQuestionDesc() );
        questionRecord.setOptionType( dto.getOptionType() );

        return questionRecord;
    }

    @Override
    public List<QuestionRecordDTO> entityListToQuestionRecordDTOList(List<QuestionRecord> entities) {
        if ( entities == null ) {
            return null;
        }

        List<QuestionRecordDTO> list = new ArrayList<QuestionRecordDTO>();
        for ( QuestionRecord questionRecord : entities ) {
            list.add( entityToSystemDTO( questionRecord ) );
        }

        return list;
    }
}
