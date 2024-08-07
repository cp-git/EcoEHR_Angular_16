package com.cpa.ehr.service.preventivecare.dto.mapper;

import com.cpa.ehr.backend.dao.preventivecare.entities.MasterPreventiveCare;
import com.cpa.ehr.service.preventivecare.dto.MasterPreventiveCareDTO;
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
public class MasterPreventiveCareMapperImpl extends MasterPreventiveCareMapper {

    @Override
    public MasterPreventiveCareDTO convertEntityToMasterPreventiveCareDTO(MasterPreventiveCare entity) {
        if ( entity == null ) {
            return null;
        }

        MasterPreventiveCareDTO masterPreventiveCareDTO = new MasterPreventiveCareDTO();

        masterPreventiveCareDTO.setPreventiveCareId( entity.getPreventiveCareId() );
        masterPreventiveCareDTO.setTestName( entity.getTestName() );
        masterPreventiveCareDTO.setGender( entity.getGender() );
        masterPreventiveCareDTO.setAge( entity.getAge() );
        masterPreventiveCareDTO.setFrequency( entity.getFrequency() );
        masterPreventiveCareDTO.setRecurringEvent( entity.getRecurringEvent() );
        masterPreventiveCareDTO.setReminderEmailDate( entity.getReminderEmailDate() );

        return masterPreventiveCareDTO;
    }

    @Override
    public MasterPreventiveCare convertMasterPreventiveCareDTOToEntity(MasterPreventiveCareDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MasterPreventiveCare masterPreventiveCare = new MasterPreventiveCare();

        masterPreventiveCare.setPreventiveCareId( dto.getPreventiveCareId() );
        masterPreventiveCare.setTestName( dto.getTestName() );
        masterPreventiveCare.setGender( dto.getGender() );
        masterPreventiveCare.setAge( dto.getAge() );
        masterPreventiveCare.setFrequency( dto.getFrequency() );
        masterPreventiveCare.setRecurringEvent( dto.getRecurringEvent() );
        masterPreventiveCare.setReminderEmailDate( dto.getReminderEmailDate() );

        return masterPreventiveCare;
    }

    @Override
    public List<MasterPreventiveCareDTO> entityListToMasterPreventiveCareDTOList(List<MasterPreventiveCare> list) {
        if ( list == null ) {
            return null;
        }

        List<MasterPreventiveCareDTO> list_ = new ArrayList<MasterPreventiveCareDTO>();
        for ( MasterPreventiveCare masterPreventiveCare : list ) {
            list_.add( convertEntityToMasterPreventiveCareDTO( masterPreventiveCare ) );
        }

        return list_;
    }
}
