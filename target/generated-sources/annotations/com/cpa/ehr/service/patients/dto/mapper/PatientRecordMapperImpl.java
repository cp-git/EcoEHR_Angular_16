package com.cpa.ehr.service.patients.dto.mapper;

import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-05T12:37:53+0530",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class PatientRecordMapperImpl extends PatientRecordMapper {

    @Override
    public PatientRecordDTO entityToPatientRecordDTO(PatientRecord entity) {
        if ( entity == null ) {
            return null;
        }

        PatientRecordDTO patientRecordDTO = new PatientRecordDTO();

        patientRecordDTO.setPatientId( entity.getPatientId() );
        patientRecordDTO.setActiveFlag( entity.getActiveFlag() );
        patientRecordDTO.setAdditionalInfo( entity.getAdditionalInfo() );
        patientRecordDTO.setDob( entity.getDob() );
        patientRecordDTO.setEmrId( entity.getEmrId() );
        patientRecordDTO.setFirstName( entity.getFirstName() );
        patientRecordDTO.setGender( entity.getGender() );
        patientRecordDTO.setLastName( entity.getLastName() );
        patientRecordDTO.setMiddleName( entity.getMiddleName() );
        patientRecordDTO.setPatientApartmentNo( entity.getPatientApartmentNo() );
        patientRecordDTO.setPatientCity( entity.getPatientCity() );
        if ( entity.getPatientImage() != null ) {
            byte[] patientImage = entity.getPatientImage();
            patientRecordDTO.setPatientImage( Arrays.copyOf( patientImage, patientImage.length ) );
        }
        patientRecordDTO.setPatientState( entity.getPatientState() );
        patientRecordDTO.setPatientStreetAddress( entity.getPatientStreetAddress() );
        patientRecordDTO.setPrimaryEmail( entity.getPrimaryEmail() );
        patientRecordDTO.setSecondaryEmail( entity.getSecondaryEmail() );
        patientRecordDTO.setPrimaryNo( entity.getPrimaryNo() );
        patientRecordDTO.setSecondaryNo( entity.getSecondaryNo() );
        patientRecordDTO.setZipCode( entity.getZipCode() );
        patientRecordDTO.setPrimaryLocation( entity.getPrimaryLocation() );
        patientRecordDTO.setOrganizationId( entity.getOrganizationId() );
        patientRecordDTO.setPrimaryProvider( entity.getPrimaryProvider() );
        patientRecordDTO.setProviderFirstName( entity.getProviderFirstName() );
        patientRecordDTO.setProviderMiddleName( entity.getProviderMiddleName() );
        patientRecordDTO.setProviderLastName( entity.getProviderLastName() );
        patientRecordDTO.setProviderFlag( entity.getProviderFlag() );
        patientRecordDTO.setProviderType( entity.getProviderType() );
        patientRecordDTO.setDesignation( entity.getDesignation() );
        patientRecordDTO.setMobileNo( entity.getMobileNo() );
        patientRecordDTO.setBusinessPhoneNo( entity.getBusinessPhoneNo() );
        patientRecordDTO.setEmail( entity.getEmail() );
        patientRecordDTO.setNpiNumber( entity.getNpiNumber() );
        patientRecordDTO.setClinicCity( entity.getClinicCity() );
        patientRecordDTO.setClinicAddressDoorNo( entity.getClinicAddressDoorNo() );
        patientRecordDTO.setClinicAddressState( entity.getClinicAddressState() );
        patientRecordDTO.setClinicAddressStreet( entity.getClinicAddressStreet() );
        patientRecordDTO.setClinicAddressZip( entity.getClinicAddressZip() );
        patientRecordDTO.setClinicContactEmail( entity.getClinicContactEmail() );
        patientRecordDTO.setClinicContactName( entity.getClinicContactName() );
        patientRecordDTO.setEinNumber( entity.getEinNumber() );
        patientRecordDTO.setClinicFaxNo( entity.getClinicFaxNo() );
        patientRecordDTO.setClinicLocName( entity.getClinicLocName() );
        patientRecordDTO.setClinicPrimaryNo( entity.getClinicPrimaryNo() );
        patientRecordDTO.setCreatedDate( entity.getCreatedDate() );
        patientRecordDTO.setCreatedBy( entity.getCreatedBy() );
        patientRecordDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        patientRecordDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        patientRecordDTO.setMrn( entity.getMrn() );

        return patientRecordDTO;
    }

    @Override
    public PatientRecord patientRecordDTOToEntity(PatientRecordDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientRecord patientRecord = new PatientRecord();

        patientRecord.setMrn( dto.getMrn() );
        patientRecord.setPatientId( dto.getPatientId() );
        patientRecord.setActiveFlag( dto.getActiveFlag() );
        patientRecord.setAdditionalInfo( dto.getAdditionalInfo() );
        patientRecord.setDob( dto.getDob() );
        patientRecord.setEmrId( dto.getEmrId() );
        patientRecord.setFirstName( dto.getFirstName() );
        patientRecord.setGender( dto.getGender() );
        patientRecord.setLastName( dto.getLastName() );
        patientRecord.setMiddleName( dto.getMiddleName() );
        patientRecord.setPatientApartmentNo( dto.getPatientApartmentNo() );
        patientRecord.setPatientCity( dto.getPatientCity() );
        if ( dto.getPatientImage() != null ) {
            byte[] patientImage = dto.getPatientImage();
            patientRecord.setPatientImage( Arrays.copyOf( patientImage, patientImage.length ) );
        }
        patientRecord.setPatientState( dto.getPatientState() );
        patientRecord.setPatientStreetAddress( dto.getPatientStreetAddress() );
        patientRecord.setPrimaryEmail( dto.getPrimaryEmail() );
        patientRecord.setSecondaryEmail( dto.getSecondaryEmail() );
        patientRecord.setPrimaryNo( dto.getPrimaryNo() );
        patientRecord.setSecondaryNo( dto.getSecondaryNo() );
        patientRecord.setZipCode( dto.getZipCode() );
        patientRecord.setPrimaryLocation( dto.getPrimaryLocation() );
        patientRecord.setOrganizationId( dto.getOrganizationId() );
        patientRecord.setPrimaryProvider( dto.getPrimaryProvider() );
        patientRecord.setProviderFirstName( dto.getProviderFirstName() );
        patientRecord.setProviderMiddleName( dto.getProviderMiddleName() );
        patientRecord.setProviderLastName( dto.getProviderLastName() );
        patientRecord.setProviderFlag( dto.getProviderFlag() );
        patientRecord.setProviderType( dto.getProviderType() );
        patientRecord.setDesignation( dto.getDesignation() );
        patientRecord.setMobileNo( dto.getMobileNo() );
        patientRecord.setBusinessPhoneNo( dto.getBusinessPhoneNo() );
        patientRecord.setEmail( dto.getEmail() );
        patientRecord.setNpiNumber( dto.getNpiNumber() );
        patientRecord.setClinicCity( dto.getClinicCity() );
        patientRecord.setClinicAddressDoorNo( dto.getClinicAddressDoorNo() );
        patientRecord.setClinicAddressState( dto.getClinicAddressState() );
        patientRecord.setClinicAddressStreet( dto.getClinicAddressStreet() );
        patientRecord.setClinicAddressZip( dto.getClinicAddressZip() );
        patientRecord.setClinicContactEmail( dto.getClinicContactEmail() );
        patientRecord.setClinicContactName( dto.getClinicContactName() );
        patientRecord.setEinNumber( dto.getEinNumber() );
        patientRecord.setClinicFaxNo( dto.getClinicFaxNo() );
        patientRecord.setClinicLocName( dto.getClinicLocName() );
        patientRecord.setClinicPrimaryNo( dto.getClinicPrimaryNo() );
        patientRecord.setCreatedDate( dto.getCreatedDate() );
        patientRecord.setCreatedBy( dto.getCreatedBy() );
        patientRecord.setLastUpdatedDate( dto.getLastUpdatedDate() );
        patientRecord.setLastUpdatedBy( dto.getLastUpdatedBy() );

        return patientRecord;
    }

    @Override
    public List<PatientRecordDTO> entityListToPatientRecordDTOList(List<PatientRecord> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PatientRecordDTO> list = new ArrayList<PatientRecordDTO>();
        for ( PatientRecord patientRecord : entities ) {
            list.add( entityToPatientRecordDTO( patientRecord ) );
        }

        return list;
    }
}
