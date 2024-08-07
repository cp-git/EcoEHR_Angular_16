package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.system.ChiefCompliantDetailsRepository;
import com.cpa.ehr.backend.dao.system.entities.ChiefCompliantDetails;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.ChiefCompliantDetailsService;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.cpa.ehr.service.system.dto.mapper.ChiefCompliantDetailsMapper;

@Service
public class ChiefCompliantDetailsServiceImpl implements ChiefCompliantDetailsService {
	private static final Logger LOG = LoggerFactory.getLogger(ChiefCompliantDetailsServiceImpl.class);

	@Autowired
	private ChiefCompliantDetailsMapper chiefCompliantDetailsMapper;

	@Autowired
	private ChiefCompliantDetailsRepository chiefCompliantDetailsRepo;
	
	@Autowired
	private EmailService emailService;

	@Override
	public ChiefCompliantDetailsDTO persistChiefCompliantDetails(ChiefCompliantDetailsDTO chiefCompliantDetailsDTO) {
		try {
			if (chiefCompliantDetailsDTO != null) {
				ChiefCompliantDetails chiefCompliantDetailsToInsert = chiefCompliantDetailsMapper
						.chiefCompliantDetailsDTOToEntity(chiefCompliantDetailsDTO);
				ChiefCompliantDetails insertedChiefCompliantDetails = chiefCompliantDetailsRepo
						.save(chiefCompliantDetailsToInsert);
				return (insertedChiefCompliantDetails != null)
						? chiefCompliantDetailsMapper.entityToChiefCompliantDetailsDTO(insertedChiefCompliantDetails)
						: null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting Chief Compliant Details {}  " + "{" + chiefCompliantDetailsDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			LOG.error("Error while inserting Chief Compliant Details {} ", e);
		}
		return null;
	}

	@Override
	public List<ChiefCompliantDetailsDTO> retrieveAllChiefCompliantByEncounterId(Long encounterId) {
		try {
			List<ChiefCompliantDetails> chiefCompliant = chiefCompliantDetailsRepo
					.findAllChiefCompliantByEncounterId(encounterId);
			return (chiefCompliant != null)
					? chiefCompliantDetailsMapper.entityListToCompliantDetailsDTOList(chiefCompliant)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all Chief Compliant By EncounterId {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all Chief Compliant By EncounterId {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ChiefCompliantDetailsDTO> retrieveIcd10DetailsOfLastFiveEncounters(Long patientId) {
		try {
			List<ChiefCompliantDetails> icd10Details = chiefCompliantDetailsRepo
					.findIcd10DetailsOfLastFiveEncounters(patientId);
			return (icd10Details != null)
					? chiefCompliantDetailsMapper.entityListToCompliantDetailsDTOList(icd10Details)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all Chief Compliant By EncounterId {}  " + "{" + patientId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all Chief Compliant By EncounterId {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public ChiefCompliantDetailsDTO retrieveCompliantByEncIdAndCode(String icd10Code, Long encounterId) {
		try {
			ChiefCompliantDetails chiefCompliant = chiefCompliantDetailsRepo.findCompliantByEncIdAndCode(icd10Code,
					encounterId);
			return (chiefCompliant != null)
					? chiefCompliantDetailsMapper.entityToChiefCompliantDetailsDTO(chiefCompliant)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all Chief Compliant By EncounterId {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving Chief Compliant By EncounterId {} ", e);
		}
		return null;
	}

	@Override
	public ChiefCompliantDetailsDTO updateChiefCompliantDetails(ChiefCompliantDetailsDTO recordToUpdate,
			ChiefCompliantDetailsDTO chiefCompliantDetailsDTO) {
		try {
			if (recordToUpdate != null) {
				recordToUpdate.setPrimaryFlag(chiefCompliantDetailsDTO.getPrimaryFlag());
				recordToUpdate.setLastUpdatedDate(chiefCompliantDetailsDTO.getLastUpdatedDate());
				recordToUpdate.setLastUpdatedBy(chiefCompliantDetailsDTO.getLastUpdatedBy());
				System.out.println(recordToUpdate);
				ChiefCompliantDetails recordEntity = chiefCompliantDetailsMapper
						.chiefCompliantDetailsDTOToEntity(recordToUpdate);
				ChiefCompliantDetails updatedcompliant = chiefCompliantDetailsRepo.save(recordEntity);
				return (updatedcompliant != null)
						? chiefCompliantDetailsMapper.entityToChiefCompliantDetailsDTO(updatedcompliant)
						: null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating compliant{}  " + "{" +  recordToUpdate + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while updating compliant {} ", e);
		}
		return null;
	}

	@Override
	public void deleteCompliantById(Long chiefCompliantDtlId) {
		// TODO Auto-generated method stub
		try {
			ChiefCompliantDetails recordToDelete = chiefCompliantDetailsRepo.findOne(chiefCompliantDtlId);
			if (recordToDelete != null) {
				chiefCompliantDetailsRepo.delete(chiefCompliantDtlId);
//				encounterToDelete.setActiveFlag("N");
//				encounterRepo.saveAndFlush(encounterToDelete);
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing compliant {}  " + "{" + chiefCompliantDtlId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while removing compliant {}", e);
		}
	}

}
