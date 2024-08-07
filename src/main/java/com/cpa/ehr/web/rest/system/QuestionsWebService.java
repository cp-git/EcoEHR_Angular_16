package com.cpa.ehr.web.rest.system;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.service.system.QuestionsService;
import com.cpa.ehr.service.system.dto.QuestionGroupDTO;
import com.cpa.ehr.service.system.dto.QuestionRecordDTO;

@RestController
@RequestMapping("/api/rest/questions")
@CrossOrigin(origins = { "http://localhost:4300" })
public class QuestionsWebService {
	private static final Logger LOG = LoggerFactory.getLogger(QuestionsWebService.class);
	@Autowired
	private QuestionsService questionsService;
	
	@GetMapping("/getListOfAllQuestionsBySystemId")
	public ResponseEntity<List<QuestionRecordDTO>> getListOfAllQuestionsBySystemId(@RequestParam("systemId") Long systemId)throws SQLException{
		List<QuestionRecordDTO> questionsListResp=null;
		try {
	    questionsListResp = questionsService.retrieveAllQuestionsBySystemId(systemId);
		}
		 catch (Exception e) {
				LOG.error("Error while retrieving all Questions List {}",e);
	    }
		return new ResponseEntity<> (questionsListResp, HttpStatus.OK); 
	}
}
