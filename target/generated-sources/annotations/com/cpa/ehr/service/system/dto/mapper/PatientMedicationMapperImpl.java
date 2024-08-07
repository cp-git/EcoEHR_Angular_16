package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.PatientMedication;
import com.cpa.ehr.service.system.dto.PatientMedicationDTO;
import com.cpa.ehr.util.FormatConverterUtils;
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
public class PatientMedicationMapperImpl extends PatientMedicationMapper {

    @Override
    public PatientMedicationDTO entitytoPatientMedicationDTO(PatientMedication entity) {
        if ( entity == null ) {
            return null;
        }

        PatientMedicationDTO patientMedicationDTO = new PatientMedicationDTO();

        patientMedicationDTO.setPatientMedicationId( entity.getPatientMedicationId() );
        patientMedicationDTO.setEncounterId( entity.getEncounterId() );
        patientMedicationDTO.setFrequency( entity.getFrequency() );
        patientMedicationDTO.setStartDate( entity.getStartDate() );
        patientMedicationDTO.setMedicationDuration( entity.getMedicationDuration() );
        patientMedicationDTO.setEndDate( entity.getEndDate() );
        patientMedicationDTO.setRefillCount( entity.getRefillCount() );
        patientMedicationDTO.setIcd10Code( entity.getIcd10Code() );
        patientMedicationDTO.setIsActiveMedication( entity.getIsActiveMedication() );
        patientMedicationDTO.setDiscontinueReason( entity.getDiscontinueReason() );
        patientMedicationDTO.setCreatedBy( entity.getCreatedBy() );
        patientMedicationDTO.setCreatedDate( entity.getCreatedDate() );
        patientMedicationDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        patientMedicationDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        patientMedicationDTO.setDiscontinuedDate( entity.getDiscontinuedDate() );

        patientMedicationDTO.setMedicationId( entity.getMedication().getMedicationId() );
        patientMedicationDTO.setPatientId( entity.getPatientDetails().getPatientId() );
        patientMedicationDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return patientMedicationDTO;
    }

    @Override
    public PatientMedication patientMedicationDTOtoEntity(PatientMedicationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientMedication patientMedication = new PatientMedication();

        patientMedication.setPatientMedicationId( dto.getPatientMedicationId() );
        patientMedication.setEncounterId( dto.getEncounterId() );
        patientMedication.setFrequency( dto.getFrequency() );
        patientMedication.setStartDate( dto.getStartDate() );
        patientMedication.setMedicationDuration( dto.getMedicationDuration() );
        patientMedication.setEndDate( dto.getEndDate() );
        patientMedication.setRefillCount( dto.getRefillCount() );
        patientMedication.setIcd10Code( dto.getIcd10Code() );
        patientMedication.setIsActiveMedication( dto.getIsActiveMedication() );
        patientMedication.setDiscontinueReason( dto.getDiscontinueReason() );
        patientMedication.setCreatedBy( dto.getCreatedBy() );
        patientMedication.setCreatedDate( dto.getCreatedDate() );
        patientMedication.setLastUpdatedBy( dto.getLastUpdatedBy() );
        patientMedication.setLastUpdatedDate( dto.getLastUpdatedDate() );
        patientMedication.setDiscontinuedDate( dto.getDiscontinuedDate() );

        patientMedication.setPatientDetails( patientRepo.findOne(dto.getPatientId()) );
        patientMedication.setMedication( medRepo.findOne(dto.getMedicationId()) );
        patientMedication.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return patientMedication;
    }

    @Override
    public List<PatientMedicationDTO> entityListToPatientMedicationDTOList(List<PatientMedication> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PatientMedicationDTO> list = new ArrayList<PatientMedicationDTO>();
        for ( PatientMedication patientMedication : entities ) {
            list.add( entitytoPatientMedicationDTO( patientMedication ) );
        }

        return list;
    }
}
