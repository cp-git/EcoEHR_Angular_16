package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.EncAsessment;
import com.cpa.ehr.service.system.dto.EncAsessmentDTO;
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
public class EncAsessmentMapperImpl extends EncAsessmentMapper {

    @Override
    public EncAsessmentDTO convertEntityToEncAsessmentDTO(EncAsessment entity) {
        if ( entity == null ) {
            return null;
        }

        EncAsessmentDTO encAsessmentDTO = new EncAsessmentDTO();

        encAsessmentDTO.setEncAsessmentId( entity.getEncAsessmentId() );
        encAsessmentDTO.setEncounterId( entity.getEncounterId() );
        encAsessmentDTO.setPatientId( entity.getPatientId() );
        encAsessmentDTO.setIcd10Code( entity.getIcd10Code() );
        encAsessmentDTO.setIcd10CodeDescription( entity.getIcd10CodeDescription() );
        encAsessmentDTO.setCreatedBy( entity.getCreatedBy() );
        encAsessmentDTO.setCreatedDate( entity.getCreatedDate() );
        encAsessmentDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        encAsessmentDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );

        encAsessmentDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return encAsessmentDTO;
    }

    @Override
    public EncAsessment convertEncAsessmentDTOToEntity(EncAsessmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EncAsessment encAsessment = new EncAsessment();

        encAsessment.setEncAsessmentId( dto.getEncAsessmentId() );
        encAsessment.setEncounterId( dto.getEncounterId() );
        encAsessment.setPatientId( dto.getPatientId() );
        encAsessment.setIcd10Code( dto.getIcd10Code() );
        encAsessment.setIcd10CodeDescription( dto.getIcd10CodeDescription() );
        encAsessment.setCreatedBy( dto.getCreatedBy() );
        encAsessment.setCreatedDate( dto.getCreatedDate() );
        encAsessment.setLastUpdatedBy( dto.getLastUpdatedBy() );
        encAsessment.setLastUpdatedDate( dto.getLastUpdatedDate() );

        encAsessment.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return encAsessment;
    }

    @Override
    public List<EncAsessmentDTO> entityListToEncAsessmentDTOList(List<EncAsessment> list) {
        if ( list == null ) {
            return null;
        }

        List<EncAsessmentDTO> list_ = new ArrayList<EncAsessmentDTO>();
        for ( EncAsessment encAsessment : list ) {
            list_.add( convertEntityToEncAsessmentDTO( encAsessment ) );
        }

        return list_;
    }
}
