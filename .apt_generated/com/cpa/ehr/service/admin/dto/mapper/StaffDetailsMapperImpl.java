package com.cpa.ehr.service.admin.dto.mapper;

import com.cpa.ehr.backend.dao.admin.entities.StaffDetails;
import com.cpa.ehr.service.admin.dto.StaffDetailsDTO;
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
public class StaffDetailsMapperImpl extends StaffDetailsMapper {

    @Override
    public StaffDetailsDTO entityToStaffDetailsDTO(StaffDetails entity) {
        if ( entity == null ) {
            return null;
        }

        StaffDetailsDTO staffDetailsDTO = new StaffDetailsDTO();

        staffDetailsDTO.setNpiNumber( entity.getNpiNumber() );
        staffDetailsDTO.setStaffId( entity.getStaffId() );
        staffDetailsDTO.setLoginId( entity.getLoginId() );
        staffDetailsDTO.setLoginKey( entity.getLoginKey() );
        staffDetailsDTO.setFirstName( entity.getFirstName() );
        staffDetailsDTO.setMiddleName( entity.getMiddleName() );
        staffDetailsDTO.setLastName( entity.getLastName() );
        staffDetailsDTO.setProviderFlag( entity.getProviderFlag() );
        staffDetailsDTO.setDesignation( entity.getDesignation() );
        staffDetailsDTO.setLastLoginDt( entity.getLastLoginDt() );
        staffDetailsDTO.setLastActionDt( entity.getLastActionDt() );
        staffDetailsDTO.setLastAction( entity.getLastAction() );
        staffDetailsDTO.setLastClient( entity.getLastClient() );
        staffDetailsDTO.setMobileNo( entity.getMobileNo() );
        staffDetailsDTO.setBusinessPhoneNo( entity.getBusinessPhoneNo() );
        staffDetailsDTO.setProviderType( entity.getProviderType() );
        staffDetailsDTO.setEmail( entity.getEmail() );
        staffDetailsDTO.setStaffImage( entity.getStaffImage() );
        staffDetailsDTO.setStaffrole( entity.getStaffrole() );
        staffDetailsDTO.setStaffAddressId( entity.getStaffAddressId() );
        staffDetailsDTO.setLocName( entity.getLocName() );
        staffDetailsDTO.setAddressDoorNo( entity.getAddressDoorNo() );
        staffDetailsDTO.setAddressStreet( entity.getAddressStreet() );
        staffDetailsDTO.setAddressCity( entity.getAddressCity() );
        staffDetailsDTO.setAddressState( entity.getAddressState() );
        staffDetailsDTO.setAddressZip( entity.getAddressZip() );
        staffDetailsDTO.setCreatedDate( entity.getCreatedDate() );
        staffDetailsDTO.setCreatedBy( entity.getCreatedBy() );
        staffDetailsDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        staffDetailsDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        staffDetailsDTO.setLicenseState( entity.getLicenseState() );
        staffDetailsDTO.setLicenseNumber( entity.getLicenseNumber() );
        staffDetailsDTO.setLicenseExpDate( entity.getLicenseExpDate() );
        staffDetailsDTO.setDeaNumber( entity.getDeaNumber() );
        staffDetailsDTO.setDeaExpDate( entity.getDeaExpDate() );
        staffDetailsDTO.setMalpracticeCoverage( entity.getMalpracticeCoverage() );
        staffDetailsDTO.setMalpracticeExpiration( entity.getMalpracticeExpiration() );
        staffDetailsDTO.setDob( entity.getDob() );
        staffDetailsDTO.setGender( entity.getGender() );
        staffDetailsDTO.setSsn( entity.getSsn() );

        staffDetailsDTO.setOrganizationId( entity.getOrganizationId() );
        staffDetailsDTO.setStaffRoleId( entity.getStaffRoleId() );
        staffDetailsDTO.setLocationId( entity.getLocationId() );
        staffDetailsDTO.setPaymentStatus(entity.getPaymentStatus());
        staffDetailsDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return staffDetailsDTO;
    }

    @Override
    public List<StaffDetailsDTO> entityListToStaffDetailsDTOList(List<StaffDetails> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StaffDetailsDTO> list = new ArrayList<StaffDetailsDTO>();
        for ( StaffDetails staffDetails : entities ) {
            list.add( entityToStaffDetailsDTO( staffDetails ) );
        }

        return list;
    }
}
