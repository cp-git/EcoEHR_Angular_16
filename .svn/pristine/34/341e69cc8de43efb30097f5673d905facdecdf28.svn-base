package com.cpa.ehr.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.service.admin.dto.OrganizationDTO;


/**
 * Mapper for the entity Organization and its DTO called Organization DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public interface OrganizationMapper {

	/**
	 * Maps Organization Entity to DTO
	 * 
	 * @param entity
	 * 		Entity of Organization
	 * @return OrganizationDTO 
	 * 		DTO of Organization
	 */
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract OrganizationDTO entityToOrganizationDTO(Organization entity);

	/**
	 * Maps Organization DTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of Organization
	 * @return Organization
	 * 		Entity of Organization
	 */
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract Organization organizationDTOToEntity(OrganizationDTO dto);

	/**
	 * Maps List of Organization Entities to DTOs
	 * 
	 * @param entities
	 * 		List of Organization entities
	 * @return 
	 * 		List of Organization DTOs
	 */
	public abstract List<OrganizationDTO> entityListToOrganizationDTOList(List<Organization> entities);

}
