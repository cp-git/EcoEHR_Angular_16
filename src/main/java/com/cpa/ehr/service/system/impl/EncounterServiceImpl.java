package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.EncounterService;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.cpa.ehr.service.system.dto.mapper.EncounterMapper;

@Service
public class EncounterServiceImpl implements EncounterService {
	private static final Logger LOG = LoggerFactory.getLogger(EncounterServiceImpl.class);

	@Autowired
	private EncounterMapper encounterMapper;

	@Autowired
	private EncounterRepository encounterRepo;

	@Autowired
	private ClinicLocationRepository clinicLocRepo;

	@Autowired
	private StaffMemberRepository staffMemberRepo;

	@Autowired
	private EHRBaseService ehrBaseService;

	@Autowired
	private EmailService emailService;

	@Override
	public EncounterDTO persistEncounter(EncounterDTO encounterDTO) {
		try {
			if (encounterDTO != null) {
				Encounter encounterToInsert = encounterMapper.encounterDTOToEntity(encounterDTO);
				Encounter insertedEncounter = encounterRepo.save(encounterToInsert);
				return (insertedEncounter != null) ? encounterMapper.entityToEncounterDTO(insertedEncounter) : null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting encounter  {}  " + "{" + encounterDTO
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			LOG.error("Error while inserting encounter {} ", e);
		}
		return null;
	}

	@Override
	public List<EncounterDTO> retrieveAllEncounterByPatientId(Long patientId) {
		try {
			List<Encounter> encounter = encounterRepo.findAllEncounterByPatientId(patientId);
			return (encounter != null) ? encounterMapper.entityListToEncounterDTOList(encounter) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all encounters by patientId {}  " + "{" + patientId
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			LOG.error("Error while retrieving all encounters by patientId {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<EncounterDTO> retrieveAllEncounterByPatientIdForStud(Long patientId, Date lastLoginDate) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	@Override
	public EncounterDTO retrieveEncounterByEncounterId(Long encounterId) {
		try {
			Encounter encounter = encounterRepo.findOne(encounterId);
			return (encounter != null) ? encounterMapper.entityToEncounterDTO(encounter) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving encounter by encounterId  {}  " + "{" + encounterId
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while retrieving encounter by encounterId {} ", e);
		}
		return null;
	}

	@Override
	public EncounterDTO modifyEncounter(Long encounterId, Long templateId, String examName, String isEdited) {
		try {
			Encounter encounterToUpdate = encounterRepo.findOne(encounterId);

			if (encounterToUpdate != null) {
				checkExamNameForTemplateId(templateId, examName, encounterToUpdate);
				Encounter updatedEncounter = encounterRepo.save(encounterToUpdate);
				return (updatedEncounter != null) ? encounterMapper.entityToEncounterDTO(updatedEncounter) : null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating encounter  {}  " + "{" + templateId
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while updating encounter {} ", e);
		}
		return null;
	}

	private void checkExamNameForTemplateId(Long templateId, String examName, Encounter encounterToUpdate) {
		if (examName.trim().equals("CARDIOVASCULAR EXAM")) {
			encounterToUpdate.setCardioExamTempId(templateId);
		} else if (examName.trim().equals("DETAILED-NEURO EXAM")) {
			encounterToUpdate.setDetailedExamTempId(templateId);
		} else if (examName.trim().equals("EYE EXAM")) {
			encounterToUpdate.setEyeExamTempId(templateId);
		} else if (examName.trim().equals("PHYSICAL EXAM")) {
			encounterToUpdate.setPhysicalExamTempId(templateId);
		} else {
			encounterToUpdate.setSimpleNeuroExamTempId(templateId);
		}
	}

	@Override
	public EncounterDTO modifyCompletedEncounter(EncounterDTO encounterDTO) {
		try {
			Encounter encounterToUpdate = encounterRepo.findOne(encounterDTO.getEncounterId());
			if (encounterToUpdate != null) {
				encounterToUpdate.setLastUpdatedDate(encounterDTO.getLastUpdatedDate());
				encounterToUpdate.setLastUpdatedBy(encounterDTO.getLastUpdatedBy());
				encounterToUpdate.setCompletionDate(new Date());
				Encounter updatedEncounter = encounterRepo.save(encounterToUpdate);
				return (updatedEncounter != null) ? encounterMapper.entityToEncounterDTO(updatedEncounter) : null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating encounter {}  " + "{" + encounterDTO
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while updating encounter {} ", e);
		}
		return null;
	}

	@Override
	public void removeEncounterByEncId(Long encounterId) {
		// TODO Auto-generated method stub
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			Encounter encounterToDelete = encounterRepo.findOne(encounterId);
			if (encounterToDelete != null) {
				encounterToDelete.setLastUpdatedBy(loginUser.getLoginId());
				encounterToDelete.setLastUpdatedDate(new Date());
				encounterToDelete.setActiveFlag("N");
				encounterRepo.saveAndFlush(encounterToDelete);
			}
		} catch (Exception e) {

			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing Encounter {}  " + "{" + encounterId
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			LOG.error("Error while removing Encounter {}", e);
		}
	}

	@Override
	public EncounterDTO modifyEncounterByEncId(EncounterDTO encounterDTO) {
		try {

			Encounter encounterToUpdate = encounterRepo.findOne(encounterDTO.getEncounterId());

			encounterToUpdate.setPatientId(encounterDTO.getPatientId());
			encounterToUpdate.setEncounterDate(encounterDTO.getEncounterDate());
			encounterToUpdate.setChiefCompliant(encounterDTO.getChiefCompliant());
			encounterToUpdate.setEmId(encounterDTO.getEmId());
			encounterToUpdate.setLastUpdatedDate(encounterDTO.getLastUpdatedDate());
			encounterToUpdate.setLastUpdatedBy(encounterDTO.getLastUpdatedBy());
			encounterToUpdate.setPatientUniqueCharacters(encounterDTO.getPatientUniqueCharacters());

			encounterRepo.saveAndFlush(encounterToUpdate);
			return (encounterToUpdate != null) ? encounterMapper.entityToEncounterDTO(encounterToUpdate) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating Encounter {}  " + "{" + encounterDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while updating Encounter {}", e);
		}
		return null;
	}

}
