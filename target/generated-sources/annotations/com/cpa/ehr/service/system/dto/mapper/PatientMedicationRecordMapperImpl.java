package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.PatientMedicationRecord;
import com.cpa.ehr.service.system.dto.PatientMedicationRecordDTO;
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
public class PatientMedicationRecordMapperImpl extends PatientMedicationRecordMapper {

    @Override
    public PatientMedicationRecordDTO entitytoPatientMedicationRecordDTO(PatientMedicationRecord entity) {
        if ( entity == null ) {
            return null;
        }

        PatientMedicationRecordDTO patientMedicationRecordDTO = new PatientMedicationRecordDTO();

        patientMedicationRecordDTO.setPatientMedicationId( entity.getPatientMedicationId() );
        patientMedicationRecordDTO.setPatientId( entity.getPatientId() );
        patientMedicationRecordDTO.setFrequency( entity.getFrequency() );
        patientMedicationRecordDTO.setIcd10Code( entity.getIcd10Code() );
        patientMedicationRecordDTO.setIsActiveMedication( entity.getIsActiveMedication() );
        patientMedicationRecordDTO.setMedicationDuration( entity.getMedicationDuration() );
        patientMedicationRecordDTO.setRefillCount( entity.getRefillCount() );
        patientMedicationRecordDTO.setStartDate( entity.getStartDate() );
        patientMedicationRecordDTO.setEndDate( entity.getEndDate() );
        patientMedicationRecordDTO.setDiscontinuedDate( entity.getDiscontinuedDate() );
        patientMedicationRecordDTO.setDiscontinueReason( entity.getDiscontinueReason() );
        patientMedicationRecordDTO.setEncounterId( entity.getEncounterId() );
        patientMedicationRecordDTO.setMedicationId( entity.getMedicationId() );
        patientMedicationRecordDTO.setPatientFirstName( entity.getPatientFirstName() );
        patientMedicationRecordDTO.setPatientMiddleName( entity.getPatientMiddleName() );
        patientMedicationRecordDTO.setPatientLastName( entity.getPatientLastName() );
        patientMedicationRecordDTO.setProviderFirstName( entity.getProviderFirstName() );
        patientMedicationRecordDTO.setProviderMiddleName( entity.getProviderMiddleName() );
        patientMedicationRecordDTO.setProviderLastName( entity.getProviderLastName() );
        patientMedicationRecordDTO.setClinicLocationName( entity.getClinicLocationName() );
        patientMedicationRecordDTO.setProductName( entity.getProductName() );
        patientMedicationRecordDTO.setForm( entity.getForm() );
        patientMedicationRecordDTO.setDose( entity.getDose() );
        patientMedicationRecordDTO.setSchedule( entity.getSchedule() );
        patientMedicationRecordDTO.setRoute( entity.getRoute() );
        patientMedicationRecordDTO.setNpiNumber( entity.getNpiNumber() );
        patientMedicationRecordDTO.setActiveFlag( entity.getActiveFlag() );

        return patientMedicationRecordDTO;
    }

    @Override
    public PatientMedicationRecord patientMedicationRecordDTOtoEntity(PatientMedicationRecordDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientMedicationRecord patientMedicationRecord = new PatientMedicationRecord();

        patientMedicationRecord.setPatientMedicationId( dto.getPatientMedicationId() );
        patientMedicationRecord.setPatientId( dto.getPatientId() );
        patientMedicationRecord.setFrequency( dto.getFrequency() );
        patientMedicationRecord.setIcd10Code( dto.getIcd10Code() );
        patientMedicationRecord.setIsActiveMedication( dto.getIsActiveMedication() );
        patientMedicationRecord.setMedicationDuration( dto.getMedicationDuration() );
        patientMedicationRecord.setRefillCount( dto.getRefillCount() );
        patientMedicationRecord.setStartDate( dto.getStartDate() );
        patientMedicationRecord.setEndDate( dto.getEndDate() );
        patientMedicationRecord.setDiscontinuedDate( dto.getDiscontinuedDate() );
        patientMedicationRecord.setDiscontinueReason( dto.getDiscontinueReason() );
        patientMedicationRecord.setEncounterId( dto.getEncounterId() );
        patientMedicationRecord.setMedicationId( dto.getMedicationId() );
        patientMedicationRecord.setPatientFirstName( dto.getPatientFirstName() );
        patientMedicationRecord.setPatientMiddleName( dto.getPatientMiddleName() );
        patientMedicationRecord.setPatientLastName( dto.getPatientLastName() );
        patientMedicationRecord.setProviderFirstName( dto.getProviderFirstName() );
        patientMedicationRecord.setProviderMiddleName( dto.getProviderMiddleName() );
        patientMedicationRecord.setProviderLastName( dto.getProviderLastName() );
        patientMedicationRecord.setClinicLocationName( dto.getClinicLocationName() );
        patientMedicationRecord.setProductName( dto.getProductName() );
        patientMedicationRecord.setForm( dto.getForm() );
        patientMedicationRecord.setDose( dto.getDose() );
        patientMedicationRecord.setSchedule( dto.getSchedule() );
        patientMedicationRecord.setRoute( dto.getRoute() );
        patientMedicationRecord.setNpiNumber( dto.getNpiNumber() );
        patientMedicationRecord.setActiveFlag( dto.getActiveFlag() );

        return patientMedicationRecord;
    }

    @Override
    public List<PatientMedicationRecordDTO> entityListToPatientMedicationRecordDTOList(List<PatientMedicationRecord> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PatientMedicationRecordDTO> list = new ArrayList<PatientMedicationRecordDTO>();
        for ( PatientMedicationRecord patientMedicationRecord : entities ) {
            list.add( entitytoPatientMedicationRecordDTO( patientMedicationRecord ) );
        }

        return list;
    }
}
