package com.cpa.ehr.service.system.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.system.EncAsessmentRepository;
import com.cpa.ehr.backend.dao.system.entities.EncAsessment;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.backend.dao.system.entities.PatientAllergy;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.EncAsessmentService;
import com.cpa.ehr.service.system.dto.EncAsessmentDTO;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
import com.cpa.ehr.service.system.dto.mapper.EncAsessmentMapper;

import java.util.Collections;
import java.util.List;

@Service
public class EncAsessmentServiceImpl implements EncAsessmentService {

	private static final Logger LOG = LoggerFactory.getLogger(EncAsessmentServiceImpl.class);

	@Autowired
	private EncAsessmentRepository encAsessmentRepository;

	@Autowired
	private EncAsessmentMapper encAsessmentMapper;

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private EmailService emailService;

	public EncAsessmentDTO persistEncAsessment(EncAsessmentDTO encAsessmentDTOpersist) {
		try {
			if (encAsessmentDTOpersist != null) {

				EncAsessment encAsessment = encAsessmentMapper.convertEncAsessmentDTOToEntity(encAsessmentDTOpersist);
				EncAsessment encAsessmentIn = encAsessmentRepository.save(encAsessment);
				return (encAsessmentIn != null) ? encAsessmentMapper.convertEntityToEncAsessmentDTO(encAsessmentIn)
						: null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting EncAsessment {}  " + "{" + encAsessmentDTOpersist + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting EncAsessment {} ", e);
		}
		return null;
	}

	public List<EncAsessmentDTO> getAllEncAssessmentByEncounterId(Long encounterId) {

		try {
			List<EncAsessment> encAssessmentList = encAsessmentRepository.getAllEncAssessmentByEncounterId(encounterId);
			return (encAssessmentList != null) ? encAsessmentMapper.entityListToEncAsessmentDTOList(encAssessmentList)
					: null;
		} catch (NullPointerException e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in getAllEncAssessmentByEncounterId {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error message", e);
		}
		return Collections.emptyList();
	}

	public List<EncAsessmentDTO> retrieveAllEncAsessment() {
		try {
			List<EncAsessment> encAsessmentList = encAsessmentRepository.findAll();
			return (encAsessmentList != null) ? encAsessmentMapper.entityListToEncAsessmentDTOList(encAsessmentList)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in retrieveAllEncAsessment {} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error message", e);
		}
		return Collections.emptyList();

	}

	public void deleteById(Long encAsessmentId) {
		try {
			EncAsessment assessmentToDelete = encAsessmentRepository.findOne(encAsessmentId);
			if (assessmentToDelete != null) {
				StaffMember loginUser = ehrBaseService.currentUser();
				assessmentToDelete.setLastUpdatedBy(loginUser.getLoginId());
				assessmentToDelete.setLastUpdatedDate(new Date());
				assessmentToDelete.setActiveFlag("N");
				encAsessmentRepository.saveAndFlush(assessmentToDelete);
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in removing Encounter Assessment {}  " + "{" + encAsessmentId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while removing Encounter Assessment {}", e);
		}

	}

	@Override
	public EncAsessmentDTO retrieveEncAsessmentById(Long encAsessmentId) {
		try {
			EncAsessment encassessment = encAsessmentRepository.findOne(encAsessmentId);
			return (encassessment != null) ? encAsessmentMapper.convertEntityToEncAsessmentDTO(encassessment) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in retrieveEncAsessmentById {}  " + "{" + encAsessmentId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error message", e);
		}
		return null;
	}

}
