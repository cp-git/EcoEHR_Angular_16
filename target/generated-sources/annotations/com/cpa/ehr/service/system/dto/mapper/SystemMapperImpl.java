package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.Systems;
import com.cpa.ehr.service.system.dto.SystemsDTO;
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
public class SystemMapperImpl implements SystemMapper {

    @Override
    public SystemsDTO entityToSystemDTO(Systems entity) {
        if ( entity == null ) {
            return null;
        }

        SystemsDTO systemsDTO = new SystemsDTO();

        systemsDTO.setSystemId( entity.getSystemId() );
        systemsDTO.setSystemType( entity.getSystemType() );
        systemsDTO.setSystemCode( entity.getSystemCode() );
        systemsDTO.setSystemDesc( entity.getSystemDesc() );
        systemsDTO.setSystemOrder( entity.getSystemOrder() );
        systemsDTO.setQuestionGroupCount( entity.getQuestionGroupCount() );
        systemsDTO.setActiveFlag( entity.getActiveFlag() );
        systemsDTO.setCreatedDate( entity.getCreatedDate() );
        systemsDTO.setCreatedBy( entity.getCreatedBy() );
        systemsDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        systemsDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        systemsDTO.setExternalLinks( entity.getExternalLinks() );

        return systemsDTO;
    }

    @Override
    public Systems systemDTOToEntity(SystemsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Systems systems = new Systems();

        systems.setSystemId( dto.getSystemId() );
        systems.setSystemType( dto.getSystemType() );
        systems.setSystemCode( dto.getSystemCode() );
        systems.setSystemDesc( dto.getSystemDesc() );
        systems.setSystemOrder( dto.getSystemOrder() );
        systems.setQuestionGroupCount( dto.getQuestionGroupCount() );
        systems.setActiveFlag( dto.getActiveFlag() );
        systems.setCreatedDate( dto.getCreatedDate() );
        systems.setCreatedBy( dto.getCreatedBy() );
        systems.setLastUpdatedDate( dto.getLastUpdatedDate() );
        systems.setLastUpdatedBy( dto.getLastUpdatedBy() );
        systems.setExternalLinks( dto.getExternalLinks() );

        return systems;
    }

    @Override
    public List<SystemsDTO> entityListToSystemDTOList(List<Systems> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SystemsDTO> list = new ArrayList<SystemsDTO>();
        for ( Systems systems : entities ) {
            list.add( entityToSystemDTO( systems ) );
        }

        return list;
    }
}
