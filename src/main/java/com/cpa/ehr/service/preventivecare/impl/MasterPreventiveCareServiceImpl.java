package com.cpa.ehr.service.preventivecare.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.patients.PatientRecordRepository;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;
import com.cpa.ehr.backend.dao.preventivecare.MasterPreventiveCareRepository;
import com.cpa.ehr.backend.dao.preventivecare.entities.MasterPreventiveCare;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.service.preventivecare.MasterPreventiveCareService;
import com.cpa.ehr.service.preventivecare.dto.MasterPreventiveCareDTO;
import com.cpa.ehr.service.preventivecare.dto.mapper.MasterPreventiveCareMapper;

import java.util.Collections;
import java.util.List;

@Service
public class MasterPreventiveCareServiceImpl implements MasterPreventiveCareService {

	private static final Logger LOG = LoggerFactory.getLogger(MasterPreventiveCareServiceImpl.class);

	@Autowired
	private MasterPreventiveCareRepository masterPreventiveCareRepository;

	@Autowired
	private MasterPreventiveCareMapper masterPreventiveCareMapper;

	@Autowired
	private PatientRecordRepository patientRecordRepo;

	@Autowired
	private EmailService emailService;
//	public MasterPreventiveCareDTO persistMasterPreventiveCare(MasterPreventiveCareDTO masterPreventiveCareDTOpersist){
//	try{
//	if(masterPreventiveCareDTOpersist !=null){
//		
//
//	 MasterPreventiveCare masterPreventiveCare = masterPreventiveCareMapper.convertMasterPreventiveCareDTOToEntity(masterPreventiveCareDTOpersist);
//	 MasterPreventiveCare masterPreventiveCareIn =  masterPreventiveCareRepository.saveAndFlush(masterPreventiveCare);
//	return (masterPreventiveCareIn !=null) ?  masterPreventiveCareMapper.convertEntityToMasterPreventiveCareDTO(masterPreventiveCareIn) : null;
//	}
//}
//		catch (Exception e){
//			LOG.error("Error while inserting MasterPreventiveCare {} ", e);
//		}
//return null;
//	}
//
// public MasterPreventiveCareDTO retrieveMasterPreventiveCareById(Long preventiveCareId){
//
//	try {
//		
//			MasterPreventiveCare masterPreventiveCare = masterPreventiveCareRepository.findById(preventiveCareId).get();
//			return (masterPreventiveCare != null) ?  masterPreventiveCareMapper.convertEntityToMasterPreventiveCareDTO(masterPreventiveCare) :null;
//		}
//		catch (Exception e){
//			LOG.error("Error Message",e);
//		}
//		return null;
//	}

	public List<MasterPreventiveCareDTO> retrieveAllMasterPreventiveCare(long pid) {
		try {
			PatientRecord patient = patientRecordRepo.findOne(pid);
			String genFirstword = patient.getGender().substring(0, 1).toUpperCase();
			List<MasterPreventiveCare> masterPreventiveCareList;
			if (genFirstword.equals("U")) {
				masterPreventiveCareList = masterPreventiveCareRepository.getAllMasterPreventive();
			} else {
				masterPreventiveCareList = masterPreventiveCareRepository
						.getAllMasterPreventiveByGender(patient.getGender().substring(0, 1).toUpperCase());

			}
			return (masterPreventiveCareList != null)
					? masterPreventiveCareMapper.entityListToMasterPreventiveCareDTOList(masterPreventiveCareList)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieveAllMasterPreventiveCare " + "{" + pid + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			LOG.error("Error message", e);
		}
		return Collections.emptyList();

	}

//public 	MasterPreventiveCareDTO modifyMasterPreventiveCare(MasterPreventiveCareDTO masterPreventiveCareDTOUpdate){
//	try{
//	if(masterPreventiveCareDTOUpdate !=null){
//					MasterPreventiveCare  masterPreventiveCare = masterPreventiveCareRepository.findById(masterPreventiveCareDTOUpdate.getPreventiveCareId()).get();
//	 MasterPreventiveCare masterPreventiveCareUpdate =  masterPreventiveCareRepository.save(masterPreventiveCare);
//	return (masterPreventiveCareUpdate !=null) ?  masterPreventiveCareMapper.convertEntityToMasterPreventiveCareDTO(masterPreventiveCareUpdate) : null;
//					
//	}
//}
//	catch (Exception e){
//			LOG.error("Error while updating MasterPreventiveCare {} ", e);
//		}
//return null;
//	}

}
