package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.service.system.dto.EncounterDTO;
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
public class EncounterMapperImpl extends EncounterMapper {

    @Override
    public EncounterDTO entityToEncounterDTO(Encounter entity) {
        if ( entity == null ) {
            return null;
        }

        EncounterDTO encounterDTO = new EncounterDTO();

        encounterDTO.setCompletionDate( entity.getCompletionDate() );
        encounterDTO.setEncounterId( entity.getEncounterId() );
        encounterDTO.setPatientId( entity.getPatientId() );
        encounterDTO.setEncounterDate( entity.getEncounterDate() );
        encounterDTO.setChiefCompliant( entity.getChiefCompliant() );
        encounterDTO.setEmId( entity.getEmId() );
        encounterDTO.setPhysicalExamTempId( entity.getPhysicalExamTempId() );
        encounterDTO.setCardioExamTempId( entity.getCardioExamTempId() );
        encounterDTO.setSimpleNeuroExamTempId( entity.getSimpleNeuroExamTempId() );
        encounterDTO.setEyeExamTempId( entity.getEyeExamTempId() );
        encounterDTO.setDetailedExamTempId( entity.getDetailedExamTempId() );
        encounterDTO.setCreatedDate( entity.getCreatedDate() );
        encounterDTO.setCreatedBy( entity.getCreatedBy() );
        encounterDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        encounterDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        encounterDTO.setPatientUniqueCharacters( entity.getPatientUniqueCharacters() );

        encounterDTO.setOrganizationId( entity.getOrganization().getOrganizationId() );
        encounterDTO.setLocationId( entity.getClinicLocation().getLocationId() );
        encounterDTO.setStaffId( entity.getStaffMember().getStaffId() );
        encounterDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return encounterDTO;
    }

    @Override
    public Encounter encounterDTOToEntity(EncounterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Encounter encounter = new Encounter();

        encounter.setCompletionDate( dto.getCompletionDate() );
        encounter.setEncounterId( dto.getEncounterId() );
        encounter.setPatientId( dto.getPatientId() );
        encounter.setEncounterDate( dto.getEncounterDate() );
        encounter.setChiefCompliant( dto.getChiefCompliant() );
        encounter.setEmId( dto.getEmId() );
        encounter.setPhysicalExamTempId( dto.getPhysicalExamTempId() );
        encounter.setCardioExamTempId( dto.getCardioExamTempId() );
        encounter.setSimpleNeuroExamTempId( dto.getSimpleNeuroExamTempId() );
        encounter.setEyeExamTempId( dto.getEyeExamTempId() );
        encounter.setDetailedExamTempId( dto.getDetailedExamTempId() );
        encounter.setCreatedDate( dto.getCreatedDate() );
        encounter.setCreatedBy( dto.getCreatedBy() );
        encounter.setLastUpdatedDate( dto.getLastUpdatedDate() );
        encounter.setLastUpdatedBy( dto.getLastUpdatedBy() );
        encounter.setPatientUniqueCharacters( dto.getPatientUniqueCharacters() );

        encounter.setClinicLocation( clinicLocRepo.findOne(dto.getLocationId()) );
        encounter.setStaffMember( staffMemberRepo.findOne(dto.getStaffId()) );
        encounter.setOrganization( orgRepo.findOne(dto.getOrganizationId()) );
        encounter.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return encounter;
    }

    @Override
    public List<EncounterDTO> entityListToEncounterDTOList(List<Encounter> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EncounterDTO> list = new ArrayList<EncounterDTO>();
        for ( Encounter encounter : entities ) {
            list.add( entityToEncounterDTO( encounter ) );
        }

        return list;
    }
}
