package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.PatientAllergy;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
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
public class PatientAllergyMapperImpl implements PatientAllergyMapper {

    @Override
    public PatientAllergyDTO convertEntityToPatientAllergyDTO(PatientAllergy entity) {
        if ( entity == null ) {
            return null;
        }

        PatientAllergyDTO patientAllergyDTO = new PatientAllergyDTO();

        patientAllergyDTO.setPatientAllergyId( entity.getPatientAllergyId() );
        patientAllergyDTO.setProductName( entity.getProductName() );
        patientAllergyDTO.setForm( entity.getForm() );
        patientAllergyDTO.setRoute( entity.getRoute() );
        patientAllergyDTO.setDose( entity.getDose() );
        patientAllergyDTO.setMedicationId( entity.getMedicationId() );
        patientAllergyDTO.setCreatedDate( entity.getCreatedDate() );
        patientAllergyDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        patientAllergyDTO.setCreatedBy( entity.getCreatedBy() );
        patientAllergyDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        patientAllergyDTO.setEncounterId( entity.getEncounterId() );
        patientAllergyDTO.setPatientId( entity.getPatientId() );

        patientAllergyDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return patientAllergyDTO;
    }

    @Override
    public PatientAllergy convertPatientAllergyDTOToEntity(PatientAllergyDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientAllergy patientAllergy = new PatientAllergy();

        patientAllergy.setPatientAllergyId( dto.getPatientAllergyId() );
        patientAllergy.setProductName( dto.getProductName() );
        patientAllergy.setForm( dto.getForm() );
        patientAllergy.setRoute( dto.getRoute() );
        patientAllergy.setDose( dto.getDose() );
        patientAllergy.setMedicationId( dto.getMedicationId() );
        patientAllergy.setCreatedDate( dto.getCreatedDate() );
        patientAllergy.setLastUpdatedDate( dto.getLastUpdatedDate() );
        patientAllergy.setCreatedBy( dto.getCreatedBy() );
        patientAllergy.setLastUpdatedBy( dto.getLastUpdatedBy() );
        patientAllergy.setEncounterId( dto.getEncounterId() );
        patientAllergy.setPatientId( dto.getPatientId() );

        patientAllergy.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return patientAllergy;
    }

    @Override
    public List<PatientAllergyDTO> entityListToPatientAllergyDTOList(List<PatientAllergy> list) {
        if ( list == null ) {
            return null;
        }

        List<PatientAllergyDTO> list_ = new ArrayList<PatientAllergyDTO>();
        for ( PatientAllergy patientAllergy : list ) {
            list_.add( convertEntityToPatientAllergyDTO( patientAllergy ) );
        }

        return list_;
    }
}
