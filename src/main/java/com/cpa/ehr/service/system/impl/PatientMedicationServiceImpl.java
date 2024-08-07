package com.cpa.ehr.service.system.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.system.PatientMedicationRecordRepository;
import com.cpa.ehr.backend.dao.system.PatientMedicationRepository;

import com.cpa.ehr.backend.dao.system.entities.PatientMedication;
import com.cpa.ehr.backend.dao.system.entities.PatientMedicationRecord;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.PatientMedicationService;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
import com.cpa.ehr.service.system.dto.PatientMedicationDTO;
import com.cpa.ehr.service.system.dto.PatientMedicationRecordDTO;

import com.cpa.ehr.service.system.dto.mapper.PatientMedicationMapper;
import com.cpa.ehr.service.system.dto.mapper.PatientMedicationRecordMapper;

@Service
public class PatientMedicationServiceImpl implements PatientMedicationService {

	private static final Logger LOG = LoggerFactory.getLogger(PatientMedicationServiceImpl.class);

	@Autowired
	private PatientMedicationMapper patientMedicationMapper;

	@Autowired
	private PatientMedicationRepository patientMedicationRepository;

	@Autowired
	private PatientMedicationRecordRepository patientMedicationRecordRepository;

	@Autowired
	private PatientMedicationRecordMapper patientMedicationRecordMapper;

	@Autowired
	private EHRBaseService ehrBaseService;

	@Autowired
	private EmailService emailService;

	@Override
	public PatientMedicationDTO persistPatientMedication(PatientMedicationDTO patientMedicationDTO) {
		try {
			if (patientMedicationDTO != null) {
				PatientMedication newPatMedication = patientMedicationMapper
						.patientMedicationDTOtoEntity(patientMedicationDTO);
				PatientMedication createdPatientMedication = patientMedicationRepository.saveAndFlush(newPatMedication);
				return (createdPatientMedication != null)
						? patientMedicationMapper.entitytoPatientMedicationDTO(createdPatientMedication)
						: null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting patient medication  {}  " + "{" + patientMedicationDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting patient medication {} ", e);
		}
		return null;
	}

	@Override
	public List<PatientMedicationRecordDTO> retrieveAllPatientMedicationRecord(Long patientId) {
		try {
			List<PatientMedicationRecord> patientMedicationRecordList = patientMedicationRecordRepository
					.patientmedicationRecordList(patientId);
			return (patientMedicationRecordList != null)
					? patientMedicationRecordMapper.entityListToPatientMedicationRecordDTOList(patientMedicationRecordList)
					: null;
		}catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in retrieveAllPatientMedicationRecord  {}  " + "{" + patientId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
		}
		
		return null;

	}

	@Override
	public void inActivePatientMedication(PatientMedicationDTO patientMed) {
		try {
			PatientMedication patientMedication = patientMedicationRepository.findOne(patientMed.getPatientMedicationId());
			patientMedication.setEncounterId(patientMed.getEncounterId());
			patientMedication.setIsActiveMedication("N");
			patientMedication.setLastUpdatedDate(patientMed.getLastUpdatedDate());
			patientMedication.setLastUpdatedBy(patientMed.getLastUpdatedBy());
			patientMedication.setDiscontinuedDate(patientMed.getDiscontinuedDate());
			patientMedication.setDiscontinueReason(patientMed.getDiscontinueReason());
			patientMedicationRepository.saveAndFlush(patientMedication);
		}catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in inActivePatientMedication  {}  " + "{" + patientMed + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
		}
	}

	@Override
	public void deletePatientMedication(Long encounterId) {
		StaffMember loginUser = ehrBaseService.currentUser();
		List<PatientMedication> activeMedicationList = patientMedicationRepository.findActiveMedications(encounterId);
		List<PatientMedication> inActiveMedicationList = patientMedicationRepository
				.findinActiveMedications(encounterId);

		for (PatientMedication patientMedication : activeMedicationList) {
			patientMedication.setLastUpdatedBy(loginUser.getLoginId());
			patientMedication.setLastUpdatedDate(new Date());
			patientMedication.setActiveFlag("N");
			patientMedicationRepository.saveAndFlush(patientMedication);
		}
		for (PatientMedication patientMedication : inActiveMedicationList) {
			patientMedication.setLastUpdatedBy(loginUser.getLoginId());
			patientMedication.setLastUpdatedDate(new Date());
			patientMedication.setDiscontinueReason(null);
			patientMedication.setDiscontinuedDate(null);
			patientMedication.setIsActiveMedication("Y");
			patientMedicationRepository.saveAndFlush(patientMedication);

		}

	}

	@Override
	public List<PatientMedicationDTO> retrieveAllPatientMedicationByencId(Long encounterId) {
		try {
			if (encounterId != 0) {
				List<PatientMedication> patientmedicationlist = patientMedicationRepository
						.patientmedicationlist(encounterId);
				return (patientmedicationlist != null)
						? patientMedicationMapper.entityListToPatientMedicationDTOList(patientmedicationlist)
						: null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while fetching patient medication  {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while fetching patient medication {} ", e);
		}
		return null;
	}

}
