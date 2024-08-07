package com.cpa.ehr.service.patients.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;


/**
 * Mapper for the entity PatientDetails and its DTO called PatientDetails DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class PatientDetailsMapper {
	@Autowired
	public OrganizationRepository orgRepo;

	@Autowired
	public ClinicLocationRepository clinicLocRepo;

	@Autowired
	public StaffMemberRepository staffMemberRepo;

	@Mapping(target = "clinicLocationId", expression = "java(entity.getClinicLocation().getLocationId())")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	@Mapping(target = "organizationId", expression = "java(entity.getOrganization().getOrganizationId())")
	@Mapping(target = "staffId", expression = "java(entity.getStaffMember().getStaffId())")
	public abstract PatientDetailsDTO entityToPatientDetailsDTO(PatientDetails entity);

	@Mapping(target = "clinicLocation", expression = "java(clinicLocRepo.findOne(dto.getClinicLocationId()))")
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	@Mapping(target = "organization", expression = "java(orgRepo.findOne(dto.getOrganizationId()))")
	@Mapping(target = "staffMember", expression = "java(staffMemberRepo.findOne(dto.getStaffId()))")
	public abstract PatientDetails patientDetailsDTOToEntity(PatientDetailsDTO dto);

	public abstract List<PatientDetailsDTO> entityListToPatientDetailsDTOList(List<PatientDetails> entities);
	



}

