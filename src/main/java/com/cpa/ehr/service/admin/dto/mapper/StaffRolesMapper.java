package com.cpa.ehr.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.entities.StaffRoles;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;

/**
 * Mapper for the entity StaffRoles and its DTO called StaffRoles DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class StaffRolesMapper {

	@Autowired
	public StaffMemberRepository staffMemberMapperRepo;

	/**
	 * Maps StaffRoles Entity to DTO
	 * 
	 * @param entity
	 * 		Entity of StaffRoles
	 * @return StaffRolesDTO 
	 * 		DTO of StaffRoles
	 */
	@Mapping(target = "staffId", expression = "java(entity.getStaff().getStaffId())")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract StaffRolesDTO entityToStaffRolesDTO(StaffRoles entity);

	/**
	 * Maps StaffRoles DTO to Entity 
	 * 
	 * 
	 * @param dto
	 * 		DTO of StaffRoles
	 * @return ActivityType
	 * 		Entity of StaffRoles
	 */
	@Mapping(target = "staff", expression = "java(staffMemberMapperRepo.findOne(dto.getStaffId()))")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract StaffRoles staffRolesDTOToEntity(StaffRolesDTO dto);

	/**
	 * Maps List of StaffRoles Entities to DTOs
	 * 
	 * @param entities
	 * 		List of StaffRoles entities
	 * @return 
	 * 		List of StaffRoles DTOs
	 */
	public abstract List<StaffRolesDTO> entityListToStaffRolesDTOList(List<StaffRoles> entities);

}
