package com.cpa.ehr.web.rest.students;

import java.util.HashMap;
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
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.cpa.ehr.backend.dao.students.entities.StudentDetails;
import com.cpa.ehr.service.students.StudentDetailsService;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;

@RestController
@RequestMapping("/api/rest/students")
@CrossOrigin(origins = { "http://localhost:4300" })
public class StudentDetailsWebService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentDetailsService.class);

	@Autowired
	private StudentDetailsService studentDetailsService;

	@PostMapping("/createStudentDetails")
	public ResponseEntity<StudentDetailsDTO> insertStudentDetails(
			@Valid @RequestBody StudentDetailsDTO studentDetailsDTO, BindingResult result, HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		StudentDetailsDTO studDTO = null;
		try {
			ResponseEntity<StudentDetailsDTO> entity = this.validateStudentData(studentDetailsDTO, result);
			if (entity.getStatusCode().value() == 200) {
				StudentDetailsDTO createdStudent = studentDetailsService.persistStudentDetails(entity.getBody());
				
				return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(headers, entity.getStatusCode());
			}
		} catch (Exception e) {
			LOG.error("Error while inserting Orders {}", e);
		}

		return new ResponseEntity<>(studDTO, headers, HttpStatus.CREATED);

	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentDetailsDTO>> getAllStudents() {
		List<StudentDetailsDTO> studentDTO = studentDetailsService.retrieveAllStudents();
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}

	@GetMapping("/getStudentRecordByStudentId")
	public ResponseEntity<StudentRecordDTO> getStudentRecordByStudentId(@RequestParam("stuId") Long stuId) {
		// StudentDetails sdetail = ehrBaseService.currentUser();
		StudentRecordDTO studentRecordsDTO = studentDetailsService.retrieveStudentRecordStudentId(stuId);
		return new ResponseEntity<>(studentRecordsDTO, HttpStatus.OK);
	}

	@GetMapping("/getStuentByStudentId")
	public ResponseEntity<StudentDetailsDTO> getStudentDetailsStudentId(@RequestParam("stuId") Long stuId) {
		StudentDetailsDTO studentDetailsDTO = studentDetailsService.retrieveStudentDetailsStudentId(stuId);
		return new ResponseEntity<>(studentDetailsDTO, HttpStatus.OK);
	}

	@PutMapping("/modifyStudentDetails")
	public ResponseEntity<StudentDetailsDTO> modifyStudentDetails(@RequestBody StudentDetailsDTO studentDetailsDTO,
			BindingResult result) {
		ResponseEntity<StudentDetailsDTO> entity = this.validateStudentData(studentDetailsDTO, result);
		if (entity.getStatusCode().value() == 200) {
			StudentDetailsDTO updatedStudent = studentDetailsService.modifyStudentDetails(entity.getBody());
			return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
		} else {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}

	public ResponseEntity<StudentDetailsDTO> validateStudentData(@Valid StudentDetailsDTO studentDetailsDTO,
			BindingResult result) {
		List<StudentDetailsDTO> studentDTOList = studentDetailsService.retrieveAllStudents();
		HttpHeaders headers = new HttpHeaders();
		for (StudentDetailsDTO student : studentDTOList) {

			System.out.println("-------------Compare");
			if (!(student.getStuId().equals(studentDetailsDTO.getStuId()))
					&& (student.getFirstName().trim().equalsIgnoreCase(studentDetailsDTO.getFirstName().trim()))
					&& (student.getLastName().trim().equalsIgnoreCase(studentDetailsDTO.getLastName().trim()))) {
				return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
			}
		}
		if (result.hasErrors()) {
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		// StudentDetails loginUser = ehrBaseService.currentUser();
		// System.out.println("-------------------------------");
		// System.out.println(loginUser);
		// FormatConverterUtils.setInitialDefaultValues(studentDetailsDTO, loginUser);
		// System.out.println(studentDetailsDTO);
		return new ResponseEntity<>(studentDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/getListOfActiveStudentsfromsView")
	public ResponseEntity<List<StudentRecordDTO>> getListOfActiveStudents() {
		// StudentDetails sdetail;
		List<StudentRecordDTO> studentListResp = studentDetailsService.retrieveAllActiveStudents();

		for (StudentRecordDTO object : studentListResp) {
			System.out.println("Data" + object);

			if (object.getUserName() == "userName" && (object.getPassword() == "password"))
			{
				System.out.println("return success");

			}
			else
			{
				System.out.println("return failure");
			}

		}

		return new ResponseEntity<>(studentListResp, HttpStatus.OK);
	}
}
