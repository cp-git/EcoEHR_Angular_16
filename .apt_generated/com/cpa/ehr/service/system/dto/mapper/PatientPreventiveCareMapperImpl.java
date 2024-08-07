package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.PatientPreventiveCare;
import com.cpa.ehr.service.system.dto.PatientPreventiveCareDTO;
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
public class PatientPreventiveCareMapperImpl extends PatientPreventiveCareMapper {

    @Override
    public PatientPreventiveCareDTO convertEntityToPatientPreventiveCareDTO(PatientPreventiveCare entity) {
        if ( entity == null ) {
            return null;
        }

        PatientPreventiveCareDTO patientPreventiveCareDTO = new PatientPreventiveCareDTO();

        patientPreventiveCareDTO.setPatientPreventiveCareId( entity.getPatientPreventiveCareId() );
        patientPreventiveCareDTO.setPatientId( entity.getPatientId() );
        patientPreventiveCareDTO.setPreventiveCareId( entity.getPreventiveCareId() );
        patientPreventiveCareDTO.setTestName( entity.getTestName() );
        patientPreventiveCareDTO.setAge( entity.getAge() );
        patientPreventiveCareDTO.setGender( entity.getGender() );
        patientPreventiveCareDTO.setDateLastDone( entity.getDateLastDone() );
        patientPreventiveCareDTO.setFrequency( entity.getFrequency() );
        patientPreventiveCareDTO.setRecurringEvent( entity.getRecurringEvent() );
        patientPreventiveCareDTO.setReminderEmailDate( entity.getReminderEmailDate() );
        patientPreventiveCareDTO.setCreatedDate( entity.getCreatedDate() );
        patientPreventiveCareDTO.setCreatedBy( entity.getCreatedBy() );
        patientPreventiveCareDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        patientPreventiveCareDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        patientPreventiveCareDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return patientPreventiveCareDTO;
    }

    @Override
    public PatientPreventiveCare convertPatientPreventiveCareDTOToEntity(PatientPreventiveCareDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientPreventiveCare patientPreventiveCare = new PatientPreventiveCare();

        patientPreventiveCare.setPatientPreventiveCareId( dto.getPatientPreventiveCareId() );
        patientPreventiveCare.setPatientId( dto.getPatientId() );
        patientPreventiveCare.setPreventiveCareId( dto.getPreventiveCareId() );
        patientPreventiveCare.setTestName( dto.getTestName() );
        patientPreventiveCare.setAge( dto.getAge() );
        patientPreventiveCare.setGender( dto.getGender() );
        patientPreventiveCare.setDateLastDone( dto.getDateLastDone() );
        patientPreventiveCare.setFrequency( dto.getFrequency() );
        patientPreventiveCare.setRecurringEvent( dto.getRecurringEvent() );
        patientPreventiveCare.setReminderEmailDate( dto.getReminderEmailDate() );
        patientPreventiveCare.setCreatedDate( dto.getCreatedDate() );
        patientPreventiveCare.setCreatedBy( dto.getCreatedBy() );
        patientPreventiveCare.setLastUpdatedDate( dto.getLastUpdatedDate() );
        patientPreventiveCare.setLastUpdatedBy( dto.getLastUpdatedBy() );

        patientPreventiveCare.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return patientPreventiveCare;
    }

    @Override
    public List<PatientPreventiveCareDTO> entityListToPatientPreventiveCareDTOList(List<PatientPreventiveCare> list) {
        if ( list == null ) {
            return null;
        }

        List<PatientPreventiveCareDTO> list_ = new ArrayList<PatientPreventiveCareDTO>();
        for ( PatientPreventiveCare patientPreventiveCare : list ) {
            list_.add( convertEntityToPatientPreventiveCareDTO( patientPreventiveCare ) );
        }

        return list_;
    }
}
