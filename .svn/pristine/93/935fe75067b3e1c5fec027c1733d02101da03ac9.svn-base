package com.cpa.ehr.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.entities.StaffDetails;
import com.cpa.ehr.service.admin.dto.StaffDetailsDTO;

/**
 * Mapper for the entity StaffMember and its DTO called StaffMember DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class StaffDetailsMapper {

	@Autowired
	public OrganizationRepository orgMapperRepo;

	@Autowired
	public ClinicLocationRepository clinicLocMapperRepo;
	
	
	/**
	 * Maps StaffMember Entity to DTO
	 * 
	 * @param entity
	 * 		Entity of StaffMember
	 * @return StaffMemberDTO 
	 * 		DTO of StaffMember
	 */
	
		@Mapping(target = "organizationId", expression = "java(entity.getOrganizationId())")
		@Mapping(target = "locationId", expression = "java(entity.getLocationId())")
		@Mapping(target="staffRoleId", expression="java(entity.getStaffRoleId())")
		@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	
	public abstract StaffDetailsDTO entityToStaffDetailsDTO(StaffDetails entity);

	/**
	 * Maps List of StaffMember Entities to DTOs
	 * 
	 * @param entities
	 * 		List of StaffMember entities
	 * @return 
	 * 		List of StaffMember DTOs
	 */
	public abstract List<StaffDetailsDTO> entityListToStaffDetailsDTOList(List<StaffDetails> entities);
}
