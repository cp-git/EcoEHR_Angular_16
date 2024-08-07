package com.cpa.ehr.service.patients.dto.mapper;

import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-05T12:37:52+0530",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class PatientDetailsMapperImpl extends PatientDetailsMapper {

    @Override
    public PatientDetailsDTO entityToPatientDetailsDTO(PatientDetails entity) {
        if ( entity == null ) {
            return null;
        }

        PatientDetailsDTO patientDetailsDTO = new PatientDetailsDTO();

        patientDetailsDTO.setRace( entity.getRace() );
        patientDetailsDTO.setEthnicity( entity.getEthnicity() );
        patientDetailsDTO.setPatientLanguage( entity.getPatientLanguage() );
        patientDetailsDTO.setPatientId( entity.getPatientId() );
        if ( entity.getPatientImage() != null ) {
            byte[] patientImage = entity.getPatientImage();
            patientDetailsDTO.setPatientImage( Arrays.copyOf( patientImage, patientImage.length ) );
        }
        patientDetailsDTO.setFirstName( entity.getFirstName() );
        patientDetailsDTO.setMiddleName( entity.getMiddleName() );
        patientDetailsDTO.setLastName( entity.getLastName() );
        patientDetailsDTO.setGender( entity.getGender() );
        patientDetailsDTO.setTitle( entity.getTitle() );
        patientDetailsDTO.setDob( entity.getDob() );
        patientDetailsDTO.setPrimaryEmail( entity.getPrimaryEmail() );
        patientDetailsDTO.setSecondaryEmail( entity.getSecondaryEmail() );
        patientDetailsDTO.setPrimaryNo( entity.getPrimaryNo() );
        patientDetailsDTO.setSecondaryNo( entity.getSecondaryNo() );
        patientDetailsDTO.setPatientStreetAddress( entity.getPatientStreetAddress() );
        patientDetailsDTO.setPatientApartmentNo( entity.getPatientApartmentNo() );
        patientDetailsDTO.setPatientCity( entity.getPatientCity() );
        patientDetailsDTO.setPatientState( entity.getPatientState() );
        patientDetailsDTO.setZipCode( entity.getZipCode() );
        patientDetailsDTO.setEmrId( entity.getEmrId() );
        patientDetailsDTO.setAdditionalInfo( entity.getAdditionalInfo() );
        patientDetailsDTO.setCreatedDate( entity.getCreatedDate() );
        patientDetailsDTO.setCreatedBy( entity.getCreatedBy() );
        patientDetailsDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        patientDetailsDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        patientDetailsDTO.setpInsName( entity.getpInsName() );
        patientDetailsDTO.setpInsRelationship( entity.getpInsRelationship() );
        patientDetailsDTO.setsInsRelationship( entity.getsInsRelationship() );
        patientDetailsDTO.setsInsName( entity.getsInsName() );
        patientDetailsDTO.setpInsCompany( entity.getpInsCompany() );
        patientDetailsDTO.setsInsCompany( entity.getsInsCompany() );
        patientDetailsDTO.setpInsPlanName( entity.getpInsPlanName() );
        patientDetailsDTO.setsInsPlanName( entity.getsInsPlanName() );
        patientDetailsDTO.setpInsId( entity.getpInsId() );
        patientDetailsDTO.setsInsId( entity.getsInsId() );
        patientDetailsDTO.setpInsGroup( entity.getpInsGroup() );
        patientDetailsDTO.setsInsGroup( entity.getsInsGroup() );
        patientDetailsDTO.setpInsDob( entity.getpInsDob() );
        patientDetailsDTO.setsInsDob( entity.getsInsDob() );
        patientDetailsDTO.setpInsSsn( entity.getpInsSsn() );
        patientDetailsDTO.setsInsSsn( entity.getsInsSsn() );
        patientDetailsDTO.setpInsEmployer( entity.getpInsEmployer() );
        patientDetailsDTO.setsInsEmployer( entity.getsInsEmployer() );
        patientDetailsDTO.setLicenseNo( entity.getLicenseNo() );
        patientDetailsDTO.setSsn( entity.getSsn() );
        patientDetailsDTO.setAge( entity.getAge() );
        patientDetailsDTO.setBuildingNo( entity.getBuildingNo() );
        patientDetailsDTO.setMrn( entity.getMrn() );

        patientDetailsDTO.setOrganizationId( entity.getOrganization().getOrganizationId() );
        patientDetailsDTO.setClinicLocationId( entity.getClinicLocation().getLocationId() );
        patientDetailsDTO.setStaffId( entity.getStaffMember().getStaffId() );
        patientDetailsDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return patientDetailsDTO;
    }

    @Override
    public PatientDetails patientDetailsDTOToEntity(PatientDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientDetails patientDetails = new PatientDetails();

        patientDetails.setRace( dto.getRace() );
        patientDetails.setEthnicity( dto.getEthnicity() );
        patientDetails.setPatientLanguage( dto.getPatientLanguage() );
        patientDetails.setPatientId( dto.getPatientId() );
        if ( dto.getPatientImage() != null ) {
            byte[] patientImage = dto.getPatientImage();
            patientDetails.setPatientImage( Arrays.copyOf( patientImage, patientImage.length ) );
        }
        patientDetails.setFirstName( dto.getFirstName() );
        patientDetails.setMiddleName( dto.getMiddleName() );
        patientDetails.setLastName( dto.getLastName() );
        patientDetails.setGender( dto.getGender() );
        patientDetails.setTitle( dto.getTitle() );
        patientDetails.setDob( dto.getDob() );
        patientDetails.setPrimaryEmail( dto.getPrimaryEmail() );
        patientDetails.setSecondaryEmail( dto.getSecondaryEmail() );
        patientDetails.setPrimaryNo( dto.getPrimaryNo() );
        patientDetails.setSecondaryNo( dto.getSecondaryNo() );
        patientDetails.setPatientStreetAddress( dto.getPatientStreetAddress() );
        patientDetails.setPatientApartmentNo( dto.getPatientApartmentNo() );
        patientDetails.setPatientCity( dto.getPatientCity() );
        patientDetails.setPatientState( dto.getPatientState() );
        patientDetails.setZipCode( dto.getZipCode() );
        patientDetails.setEmrId( dto.getEmrId() );
        patientDetails.setAdditionalInfo( dto.getAdditionalInfo() );
        patientDetails.setCreatedDate( dto.getCreatedDate() );
        patientDetails.setCreatedBy( dto.getCreatedBy() );
        patientDetails.setLastUpdatedDate( dto.getLastUpdatedDate() );
        patientDetails.setLastUpdatedBy( dto.getLastUpdatedBy() );
        patientDetails.setpInsName( dto.getpInsName() );
        patientDetails.setpInsRelationship( dto.getpInsRelationship() );
        patientDetails.setsInsRelationship( dto.getsInsRelationship() );
        patientDetails.setsInsName( dto.getsInsName() );
        patientDetails.setpInsCompany( dto.getpInsCompany() );
        patientDetails.setsInsCompany( dto.getsInsCompany() );
        patientDetails.setpInsPlanName( dto.getpInsPlanName() );
        patientDetails.setsInsPlanName( dto.getsInsPlanName() );
        patientDetails.setpInsId( dto.getpInsId() );
        patientDetails.setsInsId( dto.getsInsId() );
        patientDetails.setpInsGroup( dto.getpInsGroup() );
        patientDetails.setsInsGroup( dto.getsInsGroup() );
        patientDetails.setpInsDob( dto.getpInsDob() );
        patientDetails.setsInsDob( dto.getsInsDob() );
        patientDetails.setpInsSsn( dto.getpInsSsn() );
        patientDetails.setsInsSsn( dto.getsInsSsn() );
        patientDetails.setpInsEmployer( dto.getpInsEmployer() );
        patientDetails.setsInsEmployer( dto.getsInsEmployer() );
        patientDetails.setLicenseNo( dto.getLicenseNo() );
        patientDetails.setSsn( dto.getSsn() );
        patientDetails.setAge( dto.getAge() );
        patientDetails.setBuildingNo( dto.getBuildingNo() );
        patientDetails.setMrn( dto.getMrn() );

        patientDetails.setClinicLocation( clinicLocRepo.findOne(dto.getClinicLocationId()) );
        patientDetails.setStaffMember( staffMemberRepo.findOne(dto.getStaffId()) );
        patientDetails.setOrganization( orgRepo.findOne(dto.getOrganizationId()) );
        patientDetails.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return patientDetails;
    }

    @Override
    public List<PatientDetailsDTO> entityListToPatientDetailsDTOList(List<PatientDetails> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PatientDetailsDTO> list = new ArrayList<PatientDetailsDTO>();
        for ( PatientDetails patientDetails : entities ) {
            list.add( entityToPatientDetailsDTO( patientDetails ) );
        }

        return list;
    }
}
