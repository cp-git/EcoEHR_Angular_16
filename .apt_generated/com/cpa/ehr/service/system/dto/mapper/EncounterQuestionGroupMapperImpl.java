package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.EncounterQuestionGroup;
import com.cpa.ehr.service.system.dto.EncounterQuestionGroupDTO;
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
public class EncounterQuestionGroupMapperImpl extends EncounterQuestionGroupMapper {

    @Override
    public EncounterQuestionGroupDTO entityToEncounterQuestionGroupDTO(EncounterQuestionGroup entity) {
        if ( entity == null ) {
            return null;
        }

        EncounterQuestionGroupDTO encounterQuestionGroupDTO = new EncounterQuestionGroupDTO();

        encounterQuestionGroupDTO.setEncQuestionGroupId( entity.getEncQuestionGroupId() );
        encounterQuestionGroupDTO.setQuestionGroupId( entity.getQuestionGroupId() );
        encounterQuestionGroupDTO.setSystemId( entity.getSystemId() );
        encounterQuestionGroupDTO.setQuestionGroupAnswer( entity.getQuestionGroupAnswer() );
        encounterQuestionGroupDTO.setCreatedDate( entity.getCreatedDate() );
        encounterQuestionGroupDTO.setCreatedBy( entity.getCreatedBy() );
        encounterQuestionGroupDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        encounterQuestionGroupDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        encounterQuestionGroupDTO.setEncounterId( entity.getEncounter().getEncounterId() );

        return encounterQuestionGroupDTO;
    }

    @Override
    public EncounterQuestionGroup encounterQuestionGroupDTOToEntity(EncounterQuestionGroupDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EncounterQuestionGroup encounterQuestionGroup = new EncounterQuestionGroup();

        encounterQuestionGroup.setEncQuestionGroupId( dto.getEncQuestionGroupId() );
        encounterQuestionGroup.setQuestionGroupId( dto.getQuestionGroupId() );
        encounterQuestionGroup.setSystemId( dto.getSystemId() );
        encounterQuestionGroup.setQuestionGroupAnswer( dto.getQuestionGroupAnswer() );
        encounterQuestionGroup.setCreatedDate( dto.getCreatedDate() );
        encounterQuestionGroup.setCreatedBy( dto.getCreatedBy() );
        encounterQuestionGroup.setLastUpdatedDate( dto.getLastUpdatedDate() );
        encounterQuestionGroup.setLastUpdatedBy( dto.getLastUpdatedBy() );

        encounterQuestionGroup.setEncounter( encRepo.findOne(dto.getEncounterId()) );

        return encounterQuestionGroup;
    }

    @Override
    public List<EncounterQuestionGroupDTO> entityListToEncounterQuestionGroupDTOList(List<EncounterQuestionGroup> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EncounterQuestionGroupDTO> list = new ArrayList<EncounterQuestionGroupDTO>();
        for ( EncounterQuestionGroup encounterQuestionGroup : entities ) {
            list.add( entityToEncounterQuestionGroupDTO( encounterQuestionGroup ) );
        }

        return list;
    }
}
