

package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.system.QuestionGroupRepository;
import com.cpa.ehr.backend.dao.system.entities.QuestionGroup;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.QuestionGroupService;
import com.cpa.ehr.service.system.dto.QuestionGroupDTO;
import com.cpa.ehr.service.system.dto.mapper.QuestionGroupMapper;


@Service
public class QuestionGroupServiceImpl implements QuestionGroupService{
	private static final Logger LOG = LoggerFactory.getLogger(QuestionGroupServiceImpl.class);
	
	@Autowired
	private QuestionGroupRepository questionGroupRepo;
	
	@Autowired
	private QuestionGroupMapper questionGroupMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<QuestionGroupDTO> retrieveAllQuestionGroups(){
		try {
			List<QuestionGroup> groupList = questionGroupRepo.findAllQuestionsGroups();
			return (groupList != null) ? questionGroupMapper.entityListToQuestionGroupDTOList(groupList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all question groups {}  \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all question groups {} ", e);
		}
		return Collections.emptyList();
	}

}