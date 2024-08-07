package com.cpa.ehr.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;


/**
 * Mapper for the entity ClinicLocation and its DTO called ClinicLocation DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class ClinicLocationMapper {

	@Autowired
	public OrganizationRepository orgMapperRepo;

	/**
	 * Maps ClinicLocation Entity to DTO
	 * 
	 * @param entity
	 * 		Entity of ClinicLocation
	 * @return ClinicLocationDTO 
	 * 		DTO of ClinicLocation
	 */
	@Mapping(target = "organizationId", expression = "java(entity.getOrganization().getOrganizationId())")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract ClinicLocationDTO entityToClinicLocationDTO(ClinicLocation entity);

	/**
	 * Maps ClinicLocation DTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of ClinicLocation
	 * @return ActivityType
	 * 		Entity of ClinicLocation
	 */
	@Mapping(target = "organization", expression = "java(orgMapperRepo.findOne(dto.getOrganizationId()))")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract ClinicLocation clinicLocationDTOToEntity(ClinicLocationDTO dto);

	/**
	 * Maps List of ClinicLocation Entities to DTOs
	 * 
	 * @param entities
	 * 		List of ClinicLocation entities
	 * @return 
	 * 		List of ClinicLocation DTOs
	 */
	public abstract List<ClinicLocationDTO> entityListToClinicLocationDTOList(List<ClinicLocation> entities);

}

