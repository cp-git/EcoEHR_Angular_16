package com.cpa.ehr.service.admin.dto.mapper;

import com.cpa.ehr.backend.dao.admin.entities.StaffRoles;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;
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
public class StaffRolesMapperImpl extends StaffRolesMapper {

    @Override
    public StaffRolesDTO entityToStaffRolesDTO(StaffRoles entity) {
        if ( entity == null ) {
            return null;
        }

        StaffRolesDTO staffRolesDTO = new StaffRolesDTO();

        staffRolesDTO.setStaffRoleId( entity.getStaffRoleId() );
        staffRolesDTO.setAuthority( entity.getAuthority() );
        staffRolesDTO.setCreatedDate( entity.getCreatedDate() );
        staffRolesDTO.setCreatedBy( entity.getCreatedBy() );
        staffRolesDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        staffRolesDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        staffRolesDTO.setStaffId( entity.getStaff().getStaffId() );
        staffRolesDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return staffRolesDTO;
    }

    @Override
    public StaffRoles staffRolesDTOToEntity(StaffRolesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StaffRoles staffRoles = new StaffRoles();

        staffRoles.setStaffRoleId( dto.getStaffRoleId() );
        staffRoles.setAuthority( dto.getAuthority() );
        staffRoles.setCreatedDate( dto.getCreatedDate() );
        staffRoles.setCreatedBy( dto.getCreatedBy() );
        staffRoles.setLastUpdatedDate( dto.getLastUpdatedDate() );
        staffRoles.setLastUpdatedBy( dto.getLastUpdatedBy() );

        staffRoles.setStaff( staffMemberMapperRepo.findOne(dto.getStaffId()) );
        staffRoles.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return staffRoles;
    }

    @Override
    public List<StaffRolesDTO> entityListToStaffRolesDTOList(List<StaffRoles> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StaffRolesDTO> list = new ArrayList<StaffRolesDTO>();
        for ( StaffRoles staffRoles : entities ) {
            list.add( entityToStaffRolesDTO( staffRoles ) );
        }

        return list;
    }
}
