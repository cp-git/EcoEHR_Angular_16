package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.system.SystemsRepository;
import com.cpa.ehr.backend.dao.system.entities.Systems;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.SystemsService;
import com.cpa.ehr.service.system.dto.SystemsDTO;
import com.cpa.ehr.service.system.dto.mapper.SystemMapper;

@Service
public class SystemsServiceImpl implements SystemsService{
	private static final Logger LOG = LoggerFactory.getLogger(SystemsServiceImpl.class);
	
	@Autowired
	private SystemsRepository systemRepo;
	
	@Autowired
	private SystemMapper systemMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<SystemsDTO> retrieveAllSystems() {
		try {
			List<Systems> systemsList = systemRepo.findAll(new Sort(Sort.Direction.ASC,"systemId"));
			return (systemsList != null) ? systemMapper.entityListToSystemDTOList(systemsList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all systems {}  \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all systems {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public SystemsDTO getSystemCodeDetails(String sysCode) {
		try {
			Systems systemsDetails = systemRepo.findReferenceLinksForSys(sysCode);
			return (systemsDetails != null) ? systemMapper.entityToSystemDTO(systemsDetails) : null;
			
		}catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all systems {}  " + "{" + sysCode + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			LOG.error("Error while retrieving all systems {} ", e);
		}
		return null;
	}

}