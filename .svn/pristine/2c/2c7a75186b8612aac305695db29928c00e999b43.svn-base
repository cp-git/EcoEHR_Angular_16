package com.cpa.ehr.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.entities.MasterLookup;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class MasterLookupMapper {
	
	@Autowired
	public OrganizationRepository orgMapperRepo;
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	@Mapping(target = "organizationId", expression = "java(entity.getOrganization().getOrganizationId())")
	public abstract MasterLookupDTO entityToMasterLookupDTO(MasterLookup entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	@Mapping(target = "organization", expression = "java(orgMapperRepo.findOne(dto.getOrganizationId()))")
	public abstract MasterLookup masterLookupDTOToEntity(MasterLookupDTO dto);

	public abstract List<MasterLookupDTO> entityListToMasterLookupDTOList(List<MasterLookup> entities);
}
