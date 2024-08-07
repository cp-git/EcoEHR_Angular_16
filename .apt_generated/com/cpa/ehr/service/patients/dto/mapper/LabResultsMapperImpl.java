package com.cpa.ehr.service.patients.dto.mapper;

import com.cpa.ehr.backend.dao.patients.entities.LabResults;
import com.cpa.ehr.service.patients.dto.LabResultsDTO;
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
public class LabResultsMapperImpl extends LabResultsMapper {

    @Override
    public LabResultsDTO convertEntityToLabResultsDTO(LabResults entity) {
        if ( entity == null ) {
            return null;
        }

        LabResultsDTO labResultsDTO = new LabResultsDTO();

        labResultsDTO.setLabId( entity.getLabId() );
        labResultsDTO.setPatientId( entity.getPatientId() );
        labResultsDTO.setResultsComments( entity.getResultsComments() );
        labResultsDTO.setDocumentLink( entity.getDocumentLink() );
        labResultsDTO.setLabDate( entity.getLabDate() );
        labResultsDTO.setCreatedDate( entity.getCreatedDate() );
        labResultsDTO.setCreatedBy( entity.getCreatedBy() );
        labResultsDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        labResultsDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        labResultsDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return labResultsDTO;
    }

    @Override
    public LabResults convertLabResultsDTOToEntity(LabResultsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LabResults labResults = new LabResults();

        labResults.setLabId( dto.getLabId() );
        labResults.setPatientId( dto.getPatientId() );
        labResults.setResultsComments( dto.getResultsComments() );
        labResults.setDocumentLink( dto.getDocumentLink() );
        labResults.setLabDate( dto.getLabDate() );
        labResults.setCreatedDate( dto.getCreatedDate() );
        labResults.setCreatedBy( dto.getCreatedBy() );
        labResults.setLastUpdatedDate( dto.getLastUpdatedDate() );
        labResults.setLastUpdatedBy( dto.getLastUpdatedBy() );

        labResults.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return labResults;
    }

    @Override
    public List<LabResultsDTO> entityListToLabResultsDTOList(List<LabResults> list) {
        if ( list == null ) {
            return null;
        }

        List<LabResultsDTO> list_ = new ArrayList<LabResultsDTO>();
        for ( LabResults labResults : list ) {
            list_.add( convertEntityToLabResultsDTO( labResults ) );
        }

        return list_;
    }
}
