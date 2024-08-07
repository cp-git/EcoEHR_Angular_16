package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.ChiefCompliantDetails;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
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
public class ChiefCompliantDetailsMapperImpl extends ChiefCompliantDetailsMapper {

    @Override
    public ChiefCompliantDetailsDTO entityToChiefCompliantDetailsDTO(ChiefCompliantDetails entity) {
        if ( entity == null ) {
            return null;
        }

        ChiefCompliantDetailsDTO chiefCompliantDetailsDTO = new ChiefCompliantDetailsDTO();

        chiefCompliantDetailsDTO.setIcd10CodeDescription( entity.getIcd10CodeDescription() );
        chiefCompliantDetailsDTO.setChiefCompliantDtlId( entity.getChiefCompliantDtlId() );
        chiefCompliantDetailsDTO.setIcd10Code( entity.getIcd10Code() );
        chiefCompliantDetailsDTO.setCreatedDate( entity.getCreatedDate() );
        chiefCompliantDetailsDTO.setCreatedBy( entity.getCreatedBy() );
        chiefCompliantDetailsDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        chiefCompliantDetailsDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        chiefCompliantDetailsDTO.setEncounterId( entity.getEncounter().getEncounterId() );
        chiefCompliantDetailsDTO.setPrimaryFlag( FormatConverterUtils.convertPrimaryFlagtoBoolean(entity.getPrimaryFlag()) );

        return chiefCompliantDetailsDTO;
    }

    @Override
    public ChiefCompliantDetails chiefCompliantDetailsDTOToEntity(ChiefCompliantDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ChiefCompliantDetails chiefCompliantDetails = new ChiefCompliantDetails();

        chiefCompliantDetails.setChiefCompliantDtlId( dto.getChiefCompliantDtlId() );
        chiefCompliantDetails.setIcd10Code( dto.getIcd10Code() );
        chiefCompliantDetails.setCreatedDate( dto.getCreatedDate() );
        chiefCompliantDetails.setCreatedBy( dto.getCreatedBy() );
        chiefCompliantDetails.setLastUpdatedDate( dto.getLastUpdatedDate() );
        chiefCompliantDetails.setLastUpdatedBy( dto.getLastUpdatedBy() );
        chiefCompliantDetails.setIcd10CodeDescription( dto.getIcd10CodeDescription() );

        chiefCompliantDetails.setPrimaryFlag( FormatConverterUtils.convertBooleantoPrimaryFlag(dto.getPrimaryFlag()) );
        chiefCompliantDetails.setEncounter( encRepo.findOne(dto.getEncounterId()) );

        return chiefCompliantDetails;
    }

    @Override
    public List<ChiefCompliantDetailsDTO> entityListToCompliantDetailsDTOList(List<ChiefCompliantDetails> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ChiefCompliantDetailsDTO> list = new ArrayList<ChiefCompliantDetailsDTO>();
        for ( ChiefCompliantDetails chiefCompliantDetails : entities ) {
            list.add( entityToChiefCompliantDetailsDTO( chiefCompliantDetails ) );
        }

        return list;
    }
}
