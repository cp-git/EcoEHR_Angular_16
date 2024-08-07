package com.cpa.ehr.service.admin.dto.mapper;

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
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
public class ClinicLocationMapperImpl extends ClinicLocationMapper {

    @Override
    public ClinicLocationDTO entityToClinicLocationDTO(ClinicLocation entity) {
        if ( entity == null ) {
            return null;
        }

        ClinicLocationDTO clinicLocationDTO = new ClinicLocationDTO();

        clinicLocationDTO.setBuildingNo( entity.getBuildingNo() );
        clinicLocationDTO.setLocationId( entity.getLocationId() );
        clinicLocationDTO.setLocationName( entity.getLocationName() );
        clinicLocationDTO.setAddressStreet( entity.getAddressStreet() );
        clinicLocationDTO.setAddressDoorNo( entity.getAddressDoorNo() );
        clinicLocationDTO.setAddressCity( entity.getAddressCity() );
        clinicLocationDTO.setAddressState( entity.getAddressState() );
        clinicLocationDTO.setAddressZip( entity.getAddressZip() );
        clinicLocationDTO.setContactName( entity.getContactName() );
        clinicLocationDTO.setContactEmail( entity.getContactEmail() );
        clinicLocationDTO.setPrimaryNo( entity.getPrimaryNo() );
        clinicLocationDTO.setFaxNo( entity.getFaxNo() );
        clinicLocationDTO.setEinNumber( entity.getEinNumber() );
        clinicLocationDTO.setCreatedDate( entity.getCreatedDate() );
        clinicLocationDTO.setCreatedBy( entity.getCreatedBy() );
        clinicLocationDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        clinicLocationDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        clinicLocationDTO.setOrganizationId( entity.getOrganization().getOrganizationId() );
        clinicLocationDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return clinicLocationDTO;
    }

    @Override
    public ClinicLocation clinicLocationDTOToEntity(ClinicLocationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClinicLocation clinicLocation = new ClinicLocation();

        clinicLocation.setLocationId( dto.getLocationId() );
        clinicLocation.setLocationName( dto.getLocationName() );
        clinicLocation.setAddressStreet( dto.getAddressStreet() );
        clinicLocation.setAddressDoorNo( dto.getAddressDoorNo() );
        clinicLocation.setAddressCity( dto.getAddressCity() );
        clinicLocation.setAddressState( dto.getAddressState() );
        clinicLocation.setAddressZip( dto.getAddressZip() );
        clinicLocation.setBuildingNo( dto.getBuildingNo() );
        clinicLocation.setContactName( dto.getContactName() );
        clinicLocation.setContactEmail( dto.getContactEmail() );
        clinicLocation.setPrimaryNo( dto.getPrimaryNo() );
        clinicLocation.setFaxNo( dto.getFaxNo() );
        clinicLocation.setEinNumber( dto.getEinNumber() );
        clinicLocation.setCreatedDate( dto.getCreatedDate() );
        clinicLocation.setCreatedBy( dto.getCreatedBy() );
        clinicLocation.setLastUpdatedDate( dto.getLastUpdatedDate() );
        clinicLocation.setLastUpdatedBy( dto.getLastUpdatedBy() );

        clinicLocation.setOrganization( orgMapperRepo.findOne(dto.getOrganizationId()) );
        clinicLocation.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return clinicLocation;
    }

    @Override
    public List<ClinicLocationDTO> entityListToClinicLocationDTOList(List<ClinicLocation> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClinicLocationDTO> list = new ArrayList<ClinicLocationDTO>();
        for ( ClinicLocation clinicLocation : entities ) {
            list.add( entityToClinicLocationDTO( clinicLocation ) );
        }

        return list;
    }
}
