/*
 * Created on 2019-04-25 ( Date ISO 2019-04-25 - Time 10:19:38 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.entities.MasterLookup;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.system.PatientAllergyRepository;
import com.cpa.ehr.backend.dao.system.entities.PatientAllergy;
import com.cpa.ehr.backend.dao.system.entities.PatientMedication;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.PatientAllergyService;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
import com.cpa.ehr.service.system.dto.PatientMedicationDTO;
import com.cpa.ehr.service.system.dto.mapper.PatientAllergyMapper;

/**
 * Service implementation for PatientAllergy.
 * 
 */

@Service(value = "patientallergyService")
public class PatientAllergyServiceImpl implements PatientAllergyService {

	private static final Logger LOG = LoggerFactory.getLogger(PatientAllergyServiceImpl.class);

	@Autowired
	private PatientAllergyRepository patientAllergyRepository;

	@Autowired
	private PatientAllergyMapper patientAllergyMapper;

	@Autowired
	private EHRBaseService ehrBaseService;

	@Autowired
	private EmailService emailService;

	@Override
	public List<PatientAllergyDTO> retrieveByPatientId(Long patientId) {

		try {
			List<PatientAllergy> patientAllergyList = patientAllergyRepository
					.getAllPatientAllergyByPatientId(patientId);
			return (patientAllergyList != null)
					? patientAllergyMapper.entityListToPatientAllergyDTOList(patientAllergyList)
					: null;
		} catch (NullPointerException e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in retrieveByPatientId  {}  " + "{" + patientId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error message", e);
		}
		return Collections.emptyList();
	}

	@Override
	public void deletePatientAllergy(Long patientAllergyId) {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			PatientAllergy allergyToDelete = patientAllergyRepository.findOne(patientAllergyId);
			if (allergyToDelete != null) {

				allergyToDelete.setLastUpdatedBy(loginUser.getLoginId());
				allergyToDelete.setLastUpdatedDate(new Date());
				allergyToDelete.setActiveFlag("N");
				patientAllergyRepository.saveAndFlush(allergyToDelete);
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in deletePatientAllergy {}  " + "{" + patientAllergyId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while removing patient allergy", e);
		}
	}

	public PatientAllergyDTO persistPatientAllergy(PatientAllergyDTO patientAllergyDTOpersist) {

		if (patientAllergyDTOpersist != null) {

			PatientAllergy patientAllergy = patientAllergyMapper
					.convertPatientAllergyDTOToEntity(patientAllergyDTOpersist);
			PatientAllergy patientAllergyIn = patientAllergyRepository.saveAndFlush(patientAllergy);
			return (patientAllergyIn != null) ? patientAllergyMapper.convertEntityToPatientAllergyDTO(patientAllergyIn)
					: null;

		}
		return null;
	}

}
