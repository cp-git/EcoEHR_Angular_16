package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.Medication;
import com.cpa.ehr.service.system.dto.MedicationDTO;


@Mapper(componentModel = "spring")
public interface MedicationMapper {
	
	public abstract MedicationDTO entityToMedicationDTO(Medication entity);
	
	/**
	 * Maps QuestionGroupDTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of QuestionGroup
	 * @return ActivityType
	 * 		Entity of QuestionGroup
	 */
	public abstract Medication medicationDTOToEntity(MedicationDTO dto);
	
	/**
	 * Maps List of QuestionGroup Entities to DTOs
	 * 
	 * @param entities
	 * 		List of QuestionGroup entities
	 * @return 
	 * 		List of QuestionGroups DTOs
	 */
	public abstract List<MedicationDTO> entityListToMedicationDTOList(List<Medication> entities);

}
