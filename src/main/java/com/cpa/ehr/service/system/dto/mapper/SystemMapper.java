package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.Systems;
import com.cpa.ehr.service.system.dto.SystemsDTO;


@Mapper(componentModel = "spring")
public interface SystemMapper {
	
	public abstract SystemsDTO entityToSystemDTO(Systems entity);
	
	/**
	 * Maps System DTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of System
	 * @return ActivityType
	 * 		Entity of System
	 */
	public abstract Systems systemDTOToEntity(SystemsDTO dto);
	
	/**
	 * Maps List of System Entities to DTOs
	 * 
	 * @param entities
	 * 		List of System entities
	 * @return 
	 * 		List of System DTOs
	 */
	public abstract List<SystemsDTO> entityListToSystemDTOList(List<Systems> entities);

}
