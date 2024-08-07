package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.Medication;
import com.cpa.ehr.service.system.dto.MedicationDTO;
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
public class MedicationMapperImpl implements MedicationMapper {

    @Override
    public MedicationDTO entityToMedicationDTO(Medication entity) {
        if ( entity == null ) {
            return null;
        }

        MedicationDTO medicationDTO = new MedicationDTO();

        medicationDTO.setMedicationId( entity.getMedicationId() );
        medicationDTO.setProductName( entity.getProductName() );
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
        medication.setProductName( dto.getProductName() );
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
