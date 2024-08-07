package com.cpa.ehr.web.rest.students;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.util.FormatConverterUtils;
import com.cpa.ehr.backend.dao.students.entities.StudentDetails;
import com.cpa.ehr.service.students.StudentValidationService;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;
import com.cpa.ehr.service.students.impl.StudentValidationServiceImpl;

@RestController
@RequestMapping("/api/rest/students")
@CrossOrigin(origins = { "http://localhost:4300" })
public class StudentValidationWebService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentValidationService.class);

	@Autowired
	private StudentValidationService studentVService;

//	@PostMapping("/validateusernamepassword")
//	public ResponseEntity<StudentDetailsDTO> updateStudentLastAction(
//			@Valid @RequestBody StudentDetailsDTO studentDetailsDTO, BindingResult result, HttpServletRequest request) 
//	{
//
//		System.out.println("----------------IN createStudentDetails--------------");
//		HttpHeaders headers = new HttpHeaders();
//		if (result.hasErrors()) {
//			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
//		}
//		StudentDetailsDTO studDTO = null;
//		try {
//			System.out.println("In try........");
//			ResponseEntity<StudentDetailsDTO> entity = this.validateStudentData(studentDetailsDTO, result);
//			if (entity.getStatusCode().value() == 200) {
//				StudentDetailsDTO createdStudent = studentDetailsService.persistStudentDetails(entity.getBody());
//				return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
//			} else {
//				return new ResponseEntity<>(headers, entity.getStatusCode());
//			}
//		} catch (Exception e) {
//			LOG.error("Error while inserting Orders {}", e);
//		}
//
//		return new ResponseEntity<>(studDTO, headers, HttpStatus.CREATED);
//
//	}
	@PostMapping("/validateusernamepassword")
	public ResponseEntity<List<StudentRecordDTO>> updateStudentLastAction(
			@RequestParam("userName") String userName,@RequestParam("password") String password ) 
	{
		// StudentDetails sdetail;
		System.out.println("validation:"+ userName + password);
		studentVService.CheckUsernamePassword(userName,password);
		//List<StudentRecordDTO> studentListResp = (List<StudentRecordDTO>) studentVService.CheckUsernamePassword();
 
		 StudentValidationServiceImpl data=new StudentValidationServiceImpl();
		 data.CheckUsernamePassword(userName, password);
		 
		
		
		return null;

	}
}