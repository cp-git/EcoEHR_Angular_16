package com.cpa.ehr.service.system.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.system.QuestionsRepository;
import com.cpa.ehr.backend.dao.system.entities.OptionRecord;
import com.cpa.ehr.backend.dao.system.entities.QuestionRecord;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.QuestionsService;
import com.cpa.ehr.service.system.dto.QuestionRecordDTO;
import com.cpa.ehr.service.system.dto.mapper.QuestionRecordMapper;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	private static final Logger LOG = LoggerFactory.getLogger(QuestionsServiceImpl.class);

	@Autowired
	private QuestionsRepository questionsRepo;

	@Autowired
	private QuestionRecordMapper questRecordMapper;
	
	@Autowired
	private EmailService emailService;

	@Override
	public List<QuestionRecordDTO> retrieveAllQuestionsBySystemId(Long systemId) {
		try {
			long questionId = 0;
			List<Object> questionsList;
			questionsList = questionsRepo.findAllQuestionsBySystemId(systemId);
			List<QuestionRecord> questRecordList = new ArrayList<>();
			Iterator<Object> itr = questionsList.iterator();
			while (itr.hasNext()) {
				QuestionRecord item = new QuestionRecord();
				Object[] obj = (Object[]) itr.next();
				Iterator<Object> itr1 = questionsList.iterator();
				List<Object> questList = new ArrayList<>();
				List<OptionRecord> optionRecordList = new ArrayList<>();
				if (Long.parseLong(String.valueOf(obj[1])) != questionId) {
					while (itr1.hasNext()) {
						OptionRecord optRecord = new OptionRecord();
						Object[] obj1 = (Object[]) itr1.next();
						if (Long.parseLong(String.valueOf(obj1[1])) == Long.parseLong(String.valueOf(obj[1]))) {
							if (String.valueOf(obj1[0]) == "null") {
								optRecord.setOptionId((long) 0);
							} else {
								optRecord.setOptionId(Long.parseLong(String.valueOf(obj1[0])));
							}
							optRecord.setOptionNames(String.valueOf(obj1[5]));
							optionRecordList.add(optRecord);
							questList.add(obj1);
						}
					}
					item.setQuestionId(Long.parseLong(String.valueOf(obj[1])));
					item.setSystemId(Long.parseLong(String.valueOf(obj[2])));
					item.setQuestionGroupId(Long.parseLong(String.valueOf(obj[3])));
					item.setQuestionDesc(String.valueOf(obj[4]));
					item.setOptionType(String.valueOf(obj[6]));
					item.setOptionRecord(optionRecordList);
					questRecordList.add(item);
				}
				questionId = Long.parseLong(String.valueOf(obj[1]));
			}

			return (questionsList != null) ? questRecordMapper.entityListToQuestionRecordDTOList(questRecordList)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all questions by systemId {}  " + "{" + systemId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all questions by systemId {} ", e);
		}
		return Collections.emptyList();
	}
}
