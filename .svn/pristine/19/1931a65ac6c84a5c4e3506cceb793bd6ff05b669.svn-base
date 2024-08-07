package com.cpa.ehr.service.patients.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;


@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class PatientRecordMapper {
	@Autowired
	public OrganizationRepository orgRepo;

	@Autowired
	public ClinicLocationRepository clinicLocRepo;

	@Autowired
	public StaffMemberRepository staffMemberRepo;

	
	public abstract PatientRecordDTO entityToPatientRecordDTO(PatientRecord entity);

	
	public abstract PatientRecord patientRecordDTOToEntity(PatientRecordDTO dto);
	
	public abstract List<PatientRecordDTO> entityListToPatientRecordDTOList(List<PatientRecord> entities);


}

