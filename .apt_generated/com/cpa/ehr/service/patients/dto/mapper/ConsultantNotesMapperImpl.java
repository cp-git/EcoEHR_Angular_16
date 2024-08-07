package com.cpa.ehr.service.patients.dto.mapper;

import com.cpa.ehr.backend.dao.patients.entities.ConsultantNotes;
import com.cpa.ehr.service.patients.dto.ConsultantNotesDTO;
import com.cpa.ehr.util.FormatConverterUtils;
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
public class ConsultantNotesMapperImpl extends ConsultantNotesMapper {

    @Override
    public ConsultantNotesDTO convertEntityToConsultantNotesDTO(ConsultantNotes entity) {
        if ( entity == null ) {
            return null;
        }

        ConsultantNotesDTO consultantNotesDTO = new ConsultantNotesDTO();

        consultantNotesDTO.setConsultantNotesId( entity.getConsultantNotesId() );
        consultantNotesDTO.setPatientId( entity.getPatientId() );
        consultantNotesDTO.setConsultantComments( entity.getConsultantComments() );
        consultantNotesDTO.setConsultantDate( entity.getConsultantDate() );
        consultantNotesDTO.setDocumentLink( entity.getDocumentLink() );
        consultantNotesDTO.setCreatedDate( entity.getCreatedDate() );
        consultantNotesDTO.setCreatedBy( entity.getCreatedBy() );
        consultantNotesDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        consultantNotesDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        consultantNotesDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return consultantNotesDTO;
    }

    @Override
    public ConsultantNotes convertConsultantNotesDTOToEntity(ConsultantNotesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ConsultantNotes consultantNotes = new ConsultantNotes();

        consultantNotes.setConsultantNotesId( dto.getConsultantNotesId() );
        consultantNotes.setPatientId( dto.getPatientId() );
        consultantNotes.setConsultantComments( dto.getConsultantComments() );
        consultantNotes.setConsultantDate( dto.getConsultantDate() );
        consultantNotes.setDocumentLink( dto.getDocumentLink() );
        consultantNotes.setCreatedDate( dto.getCreatedDate() );
        consultantNotes.setCreatedBy( dto.getCreatedBy() );
        consultantNotes.setLastUpdatedDate( dto.getLastUpdatedDate() );
        consultantNotes.setLastUpdatedBy( dto.getLastUpdatedBy() );

        consultantNotes.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return consultantNotes;
    }

    @Override
    public List<ConsultantNotesDTO> entityListToConsultantNotesDTOList(List<ConsultantNotes> list) {
        if ( list == null ) {
            return null;
        }

        List<ConsultantNotesDTO> list_ = new ArrayList<ConsultantNotesDTO>();
        for ( ConsultantNotes consultantNotes : list ) {
            list_.add( convertEntityToConsultantNotesDTO( consultantNotes ) );
        }

        return list_;
    }
}
