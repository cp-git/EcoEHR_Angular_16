package com.cpa.ehr.service.patients.impl;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.patients.LabResultsRepository;
import com.cpa.ehr.backend.dao.patients.entities.LabResults;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.patients.LabResultsService;
import com.cpa.ehr.service.patients.dto.LabResultsDTO;
import com.cpa.ehr.service.patients.dto.mapper.LabResultsMapper;

/**
 * Service implementation for LabResults.
 * 
 * @author Somesh Biswas version 3.0.0
 */
@Service
public class LabResultsServiceImpl implements LabResultsService {

	private static final Logger LOG = LoggerFactory.getLogger(LabResultsServiceImpl.class);

	@Autowired
	private LabResultsRepository labResultsRepository;

	@Autowired
	private LabResultsMapper labResultsMapper;
	
	@Autowired
	private EmailService emailService;

	public LabResultsDTO persistLabResults(LabResultsDTO labResultsDTOpersist) {
		try {
			if (labResultsDTOpersist != null) {
				LabResults labResults = labResultsMapper.convertLabResultsDTOToEntity(labResultsDTOpersist);
				System.out.println(labResults.toString());
				LabResults labResultsIn = labResultsRepository.saveAndFlush(labResults);
				return (labResultsIn != null) ? labResultsMapper.convertEntityToLabResultsDTO(labResultsIn) : null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting labresults{}  " + "{" + labResultsDTOpersist + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting LabResults {} ", e);
		}
		return null;
	}

	public LabResultsDTO retrieveLabResultsById(Long labId) {

		// try {
		//
		// LabResults labResults = labResultsRepository.findById(labId).get();
		// return (labResults != null) ?
		// labResultsMapper.convertEntityToLabResultsDTO(labResults) :null;
		// }
		// catch (Exception e){
		// LOG.error("Error Message",e);
		// }
		return null;
	}

	public List<LabResultsDTO> retrievePatientLabResultsById(Long patientId) {
		try {

			List<LabResults> labResultsList = labResultsRepository.findPatientLabResultsByPatientId(patientId);
			return (labResultsList != null) ? labResultsMapper.entityListToLabResultsDTOList(labResultsList) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in {} retrievePatientLabResultsById " + "{" + patientId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			LOG.error("Error message", e);
		}
		return Collections.emptyList();

	}

	public List<LabResultsDTO> retrieveAllLabResults() {
		try {
			List<LabResults> labResultsList = labResultsRepository.findAll();
			return (labResultsList != null) ? labResultsMapper.entityListToLabResultsDTOList(labResultsList) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error in {} retrieveAllLabResults \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			LOG.error("Error message", e);
		}
		return Collections.emptyList();

	}

	public LabResultsDTO modifyLabResults(LabResultsDTO labResultsDTOUpdate) {
		// try{
		// if(labResultsDTOUpdate !=null){
		// LabResults labResults =
		// labResultsRepository.findById(labResultsDTOUpdate.getLabId()).get();
		// LabResults labResultsUpdate = labResultsRepository.save(labResults);
		// return (labResultsUpdate !=null) ?
		// labResultsMapper.convertEntityToLabResultsDTO(labResultsUpdate) : null;
		//
		// }
		// }
		// catch (Exception e){
		// LOG.error("Error while updating LabResults {} ", e);
		// }
		return null;
	}

	public void deleteById(Long labId) {

	}

}