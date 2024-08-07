package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.EncounterHistory;
import com.cpa.ehr.service.system.dto.EncounterHistoryDTO;
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
public class EncounterHistoryMapperImpl extends EncounterHistoryMapper {

    @Override
    public EncounterHistoryDTO entityToEncounterHistoryDTO(EncounterHistory entity) {
        if ( entity == null ) {
            return null;
        }

        EncounterHistoryDTO encounterHistoryDTO = new EncounterHistoryDTO();

        encounterHistoryDTO.setSystemId( entity.getSystemId() );
        encounterHistoryDTO.setSystemType( entity.getSystemType() );
        encounterHistoryDTO.setSystemCode( entity.getSystemCode() );
        encounterHistoryDTO.setSystemDesc( entity.getSystemDesc() );
        encounterHistoryDTO.setSystemOrder( entity.getSystemOrder() );
        encounterHistoryDTO.setQuestionGroupName( entity.getQuestionGroupName() );
        encounterHistoryDTO.setQuestionGroupOrder( entity.getQuestionGroupOrder() );
        encounterHistoryDTO.setQuestionGroupId( entity.getQuestionGroupId() );
        encounterHistoryDTO.setQuestionDesc( entity.getQuestionDesc() );
        encounterHistoryDTO.setQuestionType( entity.getQuestionType() );
        encounterHistoryDTO.setQuestionDispType( entity.getQuestionDispType() );
        encounterHistoryDTO.setQuestionOrder( entity.getQuestionOrder() );
        encounterHistoryDTO.setEncounterId( entity.getEncounterId() );
        encounterHistoryDTO.setQuestionId( entity.getQuestionId() );
        encounterHistoryDTO.setEncQuestionOptionId( entity.getEncQuestionOptionId() );
        encounterHistoryDTO.setOptionId( entity.getOptionId() );
        encounterHistoryDTO.setOptionValue( entity.getOptionValue() );
        encounterHistoryDTO.setAnswer( entity.getAnswer() );

        return encounterHistoryDTO;
    }

    @Override
    public EncounterHistory encounterHistoryDTOToEntity(EncounterHistoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EncounterHistory encounterHistory = new EncounterHistory();

        encounterHistory.setSystemId( dto.getSystemId() );
        encounterHistory.setSystemType( dto.getSystemType() );
        encounterHistory.setSystemCode( dto.getSystemCode() );
        encounterHistory.setSystemDesc( dto.getSystemDesc() );
        encounterHistory.setSystemOrder( dto.getSystemOrder() );
        encounterHistory.setQuestionGroupName( dto.getQuestionGroupName() );
        encounterHistory.setQuestionGroupOrder( dto.getQuestionGroupOrder() );
        encounterHistory.setQuestionGroupId( dto.getQuestionGroupId() );
        encounterHistory.setQuestionDesc( dto.getQuestionDesc() );
        encounterHistory.setQuestionType( dto.getQuestionType() );
        encounterHistory.setQuestionDispType( dto.getQuestionDispType() );
        encounterHistory.setQuestionOrder( dto.getQuestionOrder() );
        encounterHistory.setEncounterId( dto.getEncounterId() );
        encounterHistory.setQuestionId( dto.getQuestionId() );
        encounterHistory.setEncQuestionOptionId( dto.getEncQuestionOptionId() );
        encounterHistory.setOptionId( dto.getOptionId() );
        encounterHistory.setOptionValue( dto.getOptionValue() );
        encounterHistory.setAnswer( dto.getAnswer() );

        return encounterHistory;
    }

    @Override
    public List<EncounterHistoryDTO> entityListToEncounterHistoryDTOList(List<EncounterHistory> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EncounterHistoryDTO> list = new ArrayList<EncounterHistoryDTO>();
        for ( EncounterHistory encounterHistory : entities ) {
            list.add( entityToEncounterHistoryDTO( encounterHistory ) );
        }

        return list;
    }
}
