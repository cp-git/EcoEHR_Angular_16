package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.EncounterHistoryRecord;
import com.cpa.ehr.backend.dao.system.entities.QuestionHistoryRecord;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;
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
public class EncounterHistoryRecordMapperImpl implements EncounterHistoryRecordMapper {

    @Override
    public EncounterHistoryRecordDTO entityToEncounterHistoryRecordDTO(EncounterHistoryRecord entity) {
        if ( entity == null ) {
            return null;
        }

        EncounterHistoryRecordDTO encounterHistoryRecordDTO = new EncounterHistoryRecordDTO();

        encounterHistoryRecordDTO.setSystemId( entity.getSystemId() );
        encounterHistoryRecordDTO.setSystemType( entity.getSystemType() );
        encounterHistoryRecordDTO.setSystemCode( entity.getSystemCode() );
        encounterHistoryRecordDTO.setSystemDesc( entity.getSystemDesc() );
        List<QuestionHistoryRecord> list = entity.getQuestionRecord();
        if ( list != null ) {
            encounterHistoryRecordDTO.setQuestionRecord(       new ArrayList<QuestionHistoryRecord>( list )
            );
        }

        return encounterHistoryRecordDTO;
    }

    @Override
    public EncounterHistoryRecord encounterHistoryRecordDTOToEntity(EncounterHistoryRecordDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EncounterHistoryRecord encounterHistoryRecord = new EncounterHistoryRecord();

        encounterHistoryRecord.setSystemId( dto.getSystemId() );
        encounterHistoryRecord.setSystemType( dto.getSystemType() );
        encounterHistoryRecord.setSystemCode( dto.getSystemCode() );
        List<QuestionHistoryRecord> list = dto.getQuestionRecord();
        if ( list != null ) {
            encounterHistoryRecord.setQuestionRecord(       new ArrayList<QuestionHistoryRecord>( list )
            );
        }
        encounterHistoryRecord.setSystemDesc( dto.getSystemDesc() );

        return encounterHistoryRecord;
    }

    @Override
    public List<EncounterHistoryRecordDTO> entityListToEncounterHistoryRecordDTOList(List<EncounterHistoryRecord> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EncounterHistoryRecordDTO> list = new ArrayList<EncounterHistoryRecordDTO>();
        for ( EncounterHistoryRecord encounterHistoryRecord : entities ) {
            list.add( entityToEncounterHistoryRecordDTO( encounterHistoryRecord ) );
        }

        return list;
    }
}
