package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.system.ICD10GroupRepository;
import com.cpa.ehr.backend.dao.system.entities.ICD10Group;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.ICD10GroupService;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;
import com.cpa.ehr.service.system.dto.mapper.ICD10GroupMapper;


@Service
public class ICD10GroupServiceImpl implements ICD10GroupService{
	private static final Logger LOG = LoggerFactory.getLogger(ICD10GroupServiceImpl.class);
	
	@Autowired
	private ICD10GroupRepository icd10GroupRepo;
	
	@Autowired
	private ICD10GroupMapper icd10GroupMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<ICD10GroupDTO> retrieveAllICD10Groups() {
		try {
			List<ICD10Group> groupList = icd10GroupRepo.findAllIcdGroup();
			return (groupList != null) ? icd10GroupMapper.entityListToICD10GroupDTOList(groupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving retrieving all icd10 groups {}  \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all icd10 groups {} ", e);
		}
		return Collections.emptyList();
	}

}
