package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.service.system.dto.EncounterDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class EncounterMapper {

	@Autowired
	public ClinicLocationRepository clinicLocRepo;

	@Autowired
	public StaffMemberRepository staffMemberRepo;

	@Autowired
	public OrganizationRepository orgRepo;


	@Mapping(target = "locationId", expression = "java(entity.getClinicLocation().getLocationId())")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	@Mapping(target = "staffId", expression = "java(entity.getStaffMember().getStaffId())")
	@Mapping(target = "organizationId", expression = "java(entity.getOrganization().getOrganizationId())")
	public abstract EncounterDTO entityToEncounterDTO(Encounter entity);

	@Mapping(target = "clinicLocation", expression = "java(clinicLocRepo.findOne(dto.getLocationId()))")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	@Mapping(target = "staffMember", expression = "java(staffMemberRepo.findOne(dto.getStaffId()))")
	@Mapping(target = "organization", expression = "java(orgRepo.findOne(dto.getOrganizationId()))")
	public abstract Encounter encounterDTOToEntity(EncounterDTO dto);

	public abstract List<EncounterDTO> entityListToEncounterDTOList(List<Encounter> entities);
}
