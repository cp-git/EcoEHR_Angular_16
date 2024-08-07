
package com.cpa.ehr.web.rest.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.service.system.QuestionGroupService;
import com.cpa.ehr.service.system.dto.QuestionGroupDTO;


@RestController
@RequestMapping("/api/rest/questionGroups")
@CrossOrigin(origins = { "http://localhost:4300" })
public class QuestionGroupWebService {
	private static final Logger LOG = LoggerFactory.getLogger(QuestionGroupWebService.class);
	@Autowired
	private QuestionGroupService questionGroupService;
	
	@GetMapping("/getAllQuestionGroups")
	public ResponseEntity<List<QuestionGroupDTO>> getListOfQuestions() {
		List<QuestionGroupDTO> groupListResp=null;
		try {
		 groupListResp = questionGroupService.retrieveAllQuestionGroups();
		}
		 catch (Exception e) {
				LOG.error("Error while retrieving all Question group List {}",e);
	    }
		return new ResponseEntity<> (groupListResp, HttpStatus.OK); 
	}
}
