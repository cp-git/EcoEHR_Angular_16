package com.cpa.ehr.service.admin.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;


/**
 * Mapper for the entity StaffMember and its DTO called StaffMember DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class StaffMemberMapper {

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
	@Mapping(target = "clinicLocationId", expression = "java(entity.getClinicLocation().getLocationId())")
	@Mapping(target = "organizationId", expression = "java(entity.getOrganization().getOrganizationId())")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract StaffMemberDTO entityToStaffMemberDTO(StaffMember entity);

	/**
	 * Maps StaffMember DTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of StaffMember
	 * @return ActivityType
	 * 		Entity of StaffMember
	 */
	@Mapping(target = "clinicLocation", expression = "java(clinicLocMapperRepo.findOne(dto.getClinicLocationId()))")
	@Mapping(target = "organization", expression = "java(orgMapperRepo.findOne(dto.getOrganizationId()))")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract StaffMember staffMemberDTOToEntity(StaffMemberDTO dto);

	/**
	 * Maps List of StaffMember Entities to DTOs
	 * 
	 * @param entities
	 * 		List of StaffMember entities
	 * @return 
	 * 		List of StaffMember DTOs
	 */
	public abstract List<StaffMemberDTO> entityListToStaffMemberDTOList(List<StaffMember> entities);


}
