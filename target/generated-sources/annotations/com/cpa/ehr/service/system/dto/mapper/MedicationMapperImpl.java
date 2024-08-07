package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.Medication;
import com.cpa.ehr.service.system.dto.MedicationDTO;
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
public class MedicationMapperImpl implements MedicationMapper {

    @Override
    public MedicationDTO entityToMedicationDTO(Medication entity) {
        if ( entity == null ) {
            return null;
        }

        MedicationDTO medicationDTO = new MedicationDTO();

        medicationDTO.setMedicationId( entity.getMedicationId() );
        medicationDTO.setForm( entity.getForm() );
        medicationDTO.setDose( entity.getDose() );
        medicationDTO.setRoute( entity.getRoute() );
        medicationDTO.setSchedule( entity.getSchedule() );

        return medicationDTO;
    }

    @Override
    public Medication medicationDTOToEntity(MedicationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Medication medication = new Medication();

        medication.setMedicationId( dto.getMedicationId() );
        medication.setForm( dto.getForm() );
        medication.setDose( dto.getDose() );
        medication.setRoute( dto.getRoute() );
        medication.setSchedule( dto.getSchedule() );

        return medication;
    }

    @Override
    public List<MedicationDTO> entityListToMedicationDTOList(List<Medication> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MedicationDTO> list = new ArrayList<MedicationDTO>();
        for ( Medication medication : entities ) {
            list.add( entityToMedicationDTO( medication ) );
        }

        return list;
    }
}
