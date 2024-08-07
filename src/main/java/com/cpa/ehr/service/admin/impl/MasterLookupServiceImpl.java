package com.cpa.ehr.service.admin.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.admin.MasterLookupRepository;
import com.cpa.ehr.backend.dao.admin.entities.MasterLookup;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;
import com.cpa.ehr.service.admin.dto.mapper.MasterLookupMapper;
import com.cpa.ehr.service.home.EmailService;

@Service
public class MasterLookupServiceImpl implements MasterLookupService {
	private static final Logger LOG = LoggerFactory.getLogger(MasterLookupServiceImpl.class);
	
	@Autowired
	private MasterLookupRepository masterLookupRepo;
	
	@Autowired
	private MasterLookupMapper masterLookupMapper;
	
	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<String> retrieveAllMasterLookupType(Long organizationId) {
		try {
			return masterLookupRepo.findAllMasterLookupType(organizationId);
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all Master Lookup Types {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all Master Lookup Types {} ", e);
		}
		return Collections.emptyList();
	}
	

	@Override
	public List<MasterLookupDTO> retrieveAllMasterLookup(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllActiveMasterLookup(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all Master Lookup Types {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all Master Lookup {} ", e);
		}
		return Collections.emptyList();
	}
	
	
	@Override
	public List<MasterLookupDTO> retrieveAllAddressStates(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllAddressStates(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving address states {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving address states {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllPatientStatus(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllPatientStatus(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving patient states {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllCredentials(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllCredentials(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving credential {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving credential {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllProviderTypes(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllProviderTypes(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving credential {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving credential {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllSpecialisationForStud() {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllSpecialiazationTypes();
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving credential {} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving credential {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllFrequency(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllFrequency(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving frequency {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			LOG.error("Error while retrieving frequency {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllRoute(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllRoute(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving Route {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving Route {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllTitle(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllTitle(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving status {}  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public MasterLookupDTO persistMasterLookup(MasterLookupDTO masterLookupDTO) {
		try {
			if(masterLookupDTO != null) {
				MasterLookup newMasterLookup = masterLookupMapper.masterLookupDTOToEntity(masterLookupDTO);
				MasterLookup createdMasterLookup = masterLookupRepo.save(newMasterLookup);
				return (createdMasterLookup != null) ? masterLookupMapper.entityToMasterLookupDTO(createdMasterLookup) : null;
			}
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting master lookup{}  " + "{" + masterLookupDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting master lookup{} ", e);
		}
		return null;
	}


	@Override
	public void deleteMasterLookupById(Long lookupId) {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			MasterLookup masterToDelete = masterLookupRepo.findOne(lookupId);
			if (masterToDelete != null) {
				masterToDelete.setLastUpdatedBy(loginUser.getLoginId());
				masterToDelete.setLastUpdatedDate(new Date());
				masterToDelete.setActiveFlag("N");
				masterLookupRepo.saveAndFlush(masterToDelete);
			}
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing Master Lookup  " + "{" + lookupId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while removing Master Lookup" ,e);
		}
	}


	@Override
	public List<MasterLookupDTO> retriveAllMasterLookupByRefill(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllMasterLookUpByRefillType(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing patient status  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}


	@Override
	public List<MasterLookupDTO> retriveAllMasterLookupByDISCONTINUEDREASON(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllMasterLookUpByDISCONTINUEDREASONType(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving patient status  " + "{" + organizationId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}


	@Override
	public List<MasterLookupDTO> retrieveAllRace(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllRace(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}


	@Override
	public List<MasterLookupDTO> retrieveAllEthnicity(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllEthnicity(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	
	}


	@Override
	public List<MasterLookupDTO> retrieveAllLanguage(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllLanguages(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}
}
