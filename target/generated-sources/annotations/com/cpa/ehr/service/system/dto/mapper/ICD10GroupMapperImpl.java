package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.ICD10Group;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;
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
public class ICD10GroupMapperImpl implements ICD10GroupMapper {

    @Override
    public ICD10GroupDTO entityToICD10Group(ICD10Group entity) {
        if ( entity == null ) {
            return null;
        }

        ICD10GroupDTO iCD10GroupDTO = new ICD10GroupDTO();

        iCD10GroupDTO.setCount( entity.getCount() );
        iCD10GroupDTO.setGroupId( entity.getGroupId() );
        iCD10GroupDTO.setGroupRange( entity.getGroupRange() );
        iCD10GroupDTO.setGroupDescription( entity.getGroupDescription() );
        iCD10GroupDTO.setCreatedDate( entity.getCreatedDate() );
        iCD10GroupDTO.setCreatedBy( entity.getCreatedBy() );
        iCD10GroupDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        iCD10GroupDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        return iCD10GroupDTO;
    }

    @Override
    public List<ICD10GroupDTO> entityListToICD10GroupDTOList(List<ICD10Group> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ICD10GroupDTO> list = new ArrayList<ICD10GroupDTO>();
        for ( ICD10Group iCD10Group : entities ) {
            list.add( entityToICD10Group( iCD10Group ) );
        }

        return list;
    }
}
