package com.cpa.ehr.service.admin.dto.mapper;

import com.cpa.ehr.backend.dao.admin.entities.MasterLookup;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;
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
public class MasterLookupMapperImpl extends MasterLookupMapper {

    @Override
    public MasterLookupDTO entityToMasterLookupDTO(MasterLookup entity) {
        if ( entity == null ) {
            return null;
        }

        MasterLookupDTO masterLookupDTO = new MasterLookupDTO();

        masterLookupDTO.setLookupId( entity.getLookupId() );
        masterLookupDTO.setLookupType( entity.getLookupType() );
        masterLookupDTO.setLookupCode( entity.getLookupCode() );
        masterLookupDTO.setLookupDesc( entity.getLookupDesc() );
        masterLookupDTO.setCreatedDate( entity.getCreatedDate() );
        masterLookupDTO.setCreatedBy( entity.getCreatedBy() );
        masterLookupDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        masterLookupDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        masterLookupDTO.setOrganizationId( entity.getOrganization().getOrganizationId() );
        masterLookupDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return masterLookupDTO;
    }

    @Override
    public MasterLookup masterLookupDTOToEntity(MasterLookupDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MasterLookup masterLookup = new MasterLookup();

        masterLookup.setLookupId( dto.getLookupId() );
        masterLookup.setLookupType( dto.getLookupType() );
        masterLookup.setLookupCode( dto.getLookupCode() );
        masterLookup.setLookupDesc( dto.getLookupDesc() );
        masterLookup.setCreatedDate( dto.getCreatedDate() );
        masterLookup.setCreatedBy( dto.getCreatedBy() );
        masterLookup.setLastUpdatedDate( dto.getLastUpdatedDate() );
        masterLookup.setLastUpdatedBy( dto.getLastUpdatedBy() );

        masterLookup.setOrganization( orgMapperRepo.findOne(dto.getOrganizationId()) );
        masterLookup.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return masterLookup;
    }

    @Override
    public List<MasterLookupDTO> entityListToMasterLookupDTOList(List<MasterLookup> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MasterLookupDTO> list = new ArrayList<MasterLookupDTO>();
        for ( MasterLookup masterLookup : entities ) {
            list.add( entityToMasterLookupDTO( masterLookup ) );
        }

        return list;
    }
}
