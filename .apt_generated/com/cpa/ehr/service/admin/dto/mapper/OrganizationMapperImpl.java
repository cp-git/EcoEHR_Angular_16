package com.cpa.ehr.service.admin.dto.mapper;

import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.service.admin.dto.OrganizationDTO;
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
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDTO entityToOrganizationDTO(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationDTO organizationDTO = new OrganizationDTO();

        organizationDTO.setOrganizationId( entity.getOrganizationId() );
        organizationDTO.setOrganizationName( entity.getOrganizationName() );
        organizationDTO.setOrganizationContactName( entity.getOrganizationContactName() );
        organizationDTO.setOrganizationContactEmail( entity.getOrganizationContactEmail() );
        organizationDTO.setOrganizationContactPhone( entity.getOrganizationContactPhone() );
        organizationDTO.setOrganizationContactFax( entity.getOrganizationContactFax() );
        organizationDTO.setOrganizationContactWeb( entity.getOrganizationContactWeb() );
        organizationDTO.setOrganizationLogo( entity.getOrganizationLogo() );
        organizationDTO.setOrganizationTaxId( entity.getOrganizationTaxId() );
        organizationDTO.setAddressDoorNo( entity.getAddressDoorNo() );
        organizationDTO.setAddressStreet1( entity.getAddressStreet1() );
        organizationDTO.setAddressStreet2( entity.getAddressStreet2() );
        organizationDTO.setAddressCity( entity.getAddressCity() );
        organizationDTO.setAddressState( entity.getAddressState() );
        organizationDTO.setAddressZip( entity.getAddressZip() );
        organizationDTO.setCreatedDate( entity.getCreatedDate() );
        organizationDTO.setCreatedBy( entity.getCreatedBy() );
        organizationDTO.setNpiNumber( entity.getNpiNumber() );
        organizationDTO.setEinNumber( entity.getEinNumber() );
        organizationDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        organizationDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        organizationDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return organizationDTO;
    }

    @Override
    public Organization organizationDTOToEntity(OrganizationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setOrganizationId( dto.getOrganizationId() );
        organization.setOrganizationName( dto.getOrganizationName() );
        organization.setOrganizationContactName( dto.getOrganizationContactName() );
        organization.setOrganizationContactEmail( dto.getOrganizationContactEmail() );
        organization.setOrganizationContactPhone( dto.getOrganizationContactPhone() );
        organization.setOrganizationContactFax( dto.getOrganizationContactFax() );
        organization.setOrganizationContactWeb( dto.getOrganizationContactWeb() );
        organization.setOrganizationLogo( dto.getOrganizationLogo() );
        organization.setOrganizationTaxId( dto.getOrganizationTaxId() );
        organization.setAddressDoorNo( dto.getAddressDoorNo() );
        organization.setAddressStreet1( dto.getAddressStreet1() );
        organization.setAddressStreet2( dto.getAddressStreet2() );
        organization.setAddressCity( dto.getAddressCity() );
        organization.setAddressState( dto.getAddressState() );
        organization.setAddressZip( dto.getAddressZip() );
        organization.setCreatedDate( dto.getCreatedDate() );
        organization.setCreatedBy( dto.getCreatedBy() );
        organization.setLastUpdatedDate( dto.getLastUpdatedDate() );
        organization.setLastUpdatedBy( dto.getLastUpdatedBy() );
        organization.setNpiNumber( dto.getNpiNumber() );
        organization.setEinNumber( dto.getEinNumber() );

        organization.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return organization;
    }

    @Override
    public List<OrganizationDTO> entityListToOrganizationDTOList(List<Organization> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrganizationDTO> list = new ArrayList<OrganizationDTO>();
        for ( Organization organization : entities ) {
            list.add( entityToOrganizationDTO( organization ) );
        }

        return list;
    }
}
