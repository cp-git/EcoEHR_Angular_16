package com.cpa.ehr.service.admin.dto.mapper;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
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
public class StaffMemberMapperImpl extends StaffMemberMapper {

    @Override
    public StaffMemberDTO entityToStaffMemberDTO(StaffMember entity) {
        if ( entity == null ) {
            return null;
        }

        StaffMemberDTO staffMemberDTO = new StaffMemberDTO();

        staffMemberDTO.setStaffId( entity.getStaffId() );
        staffMemberDTO.setLoginId( entity.getLoginId() );
        staffMemberDTO.setLoginKey( entity.getLoginKey() );
        staffMemberDTO.setFirstName( entity.getFirstName() );
        staffMemberDTO.setMiddleName( entity.getMiddleName() );
        staffMemberDTO.setLastName( entity.getLastName() );
        staffMemberDTO.setStaffImage( entity.getStaffImage() );
        staffMemberDTO.setProviderType( entity.getProviderType() );
        staffMemberDTO.setDesignation( entity.getDesignation() );
        staffMemberDTO.setProviderFlag( entity.getProviderFlag() );
        staffMemberDTO.setMobileNo( entity.getMobileNo() );
        staffMemberDTO.setBusinessPhoneNo( entity.getBusinessPhoneNo() );
        staffMemberDTO.setEmail( entity.getEmail() );
        staffMemberDTO.setNpiNumber( entity.getNpiNumber() );
        staffMemberDTO.setLastClient( entity.getLastClient() );
        staffMemberDTO.setLastAction( entity.getLastAction() );
        staffMemberDTO.setLastLoginDate( entity.getLastLoginDate() );
        staffMemberDTO.setLastActionDate( entity.getLastActionDate() );
        staffMemberDTO.setCreatedDate( entity.getCreatedDate() );
        staffMemberDTO.setCreatedBy( entity.getCreatedBy() );
        staffMemberDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        staffMemberDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        staffMemberDTO.setLicenseState( entity.getLicenseState() );
        staffMemberDTO.setLicenseNumber( entity.getLicenseNumber() );
        staffMemberDTO.setLicenseExpDate( entity.getLicenseExpDate() );
        staffMemberDTO.setDeaNumber( entity.getDeaNumber() );
        staffMemberDTO.setDeaExpDate( entity.getDeaExpDate() );
        staffMemberDTO.setMalpracticeCoverage( entity.getMalpracticeCoverage() );
        staffMemberDTO.setMalpracticeExpiration( entity.getMalpracticeExpiration() );
        staffMemberDTO.setDob( entity.getDob() );
        staffMemberDTO.setGender( entity.getGender() );
        staffMemberDTO.setSsn( entity.getSsn() );

        staffMemberDTO.setOrganizationId( entity.getOrganization().getOrganizationId() );
        staffMemberDTO.setClinicLocationId( entity.getClinicLocation().getLocationId() );
        staffMemberDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return staffMemberDTO;
    }

    @Override
    public StaffMember staffMemberDTOToEntity(StaffMemberDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StaffMember staffMember = new StaffMember();

        staffMember.setStaffId( dto.getStaffId() );
        staffMember.setLoginId( dto.getLoginId() );
        staffMember.setLoginKey( dto.getLoginKey() );
        staffMember.setFirstName( dto.getFirstName() );
        staffMember.setMiddleName( dto.getMiddleName() );
        staffMember.setLastName( dto.getLastName() );
        staffMember.setStaffImage( dto.getStaffImage() );
        staffMember.setProviderType( dto.getProviderType() );
        staffMember.setDesignation( dto.getDesignation() );
        staffMember.setProviderFlag( dto.getProviderFlag() );
        staffMember.setMobileNo( dto.getMobileNo() );
        staffMember.setBusinessPhoneNo( dto.getBusinessPhoneNo() );
        staffMember.setEmail( dto.getEmail() );
        staffMember.setNpiNumber( dto.getNpiNumber() );
        staffMember.setLastClient( dto.getLastClient() );
        staffMember.setLastAction( dto.getLastAction() );
        staffMember.setLastLoginDate( dto.getLastLoginDate() );
        staffMember.setLastActionDate( dto.getLastActionDate() );
        staffMember.setCreatedDate( dto.getCreatedDate() );
        staffMember.setCreatedBy( dto.getCreatedBy() );
        staffMember.setLastUpdatedDate( dto.getLastUpdatedDate() );
        staffMember.setLastUpdatedBy( dto.getLastUpdatedBy() );
        staffMember.setLicenseState( dto.getLicenseState() );
        staffMember.setLicenseNumber( dto.getLicenseNumber() );
        staffMember.setLicenseExpDate( dto.getLicenseExpDate() );
        staffMember.setDeaNumber( dto.getDeaNumber() );
        staffMember.setDeaExpDate( dto.getDeaExpDate() );
        staffMember.setMalpracticeCoverage( dto.getMalpracticeCoverage() );
        staffMember.setMalpracticeExpiration( dto.getMalpracticeExpiration() );
        staffMember.setDob( dto.getDob() );
        staffMember.setGender( dto.getGender() );
        staffMember.setSsn( dto.getSsn() );

        staffMember.setClinicLocation( clinicLocMapperRepo.findOne(dto.getClinicLocationId()) );
        staffMember.setOrganization( orgMapperRepo.findOne(dto.getOrganizationId()) );
        staffMember.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return staffMember;
    }

    @Override
    public List<StaffMemberDTO> entityListToStaffMemberDTOList(List<StaffMember> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StaffMemberDTO> list = new ArrayList<StaffMemberDTO>();
        for ( StaffMember staffMember : entities ) {
            list.add( entityToStaffMemberDTO( staffMember ) );
        }

        return list;
    }
}
