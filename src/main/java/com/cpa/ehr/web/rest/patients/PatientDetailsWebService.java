package com.cpa.ehr.web.rest.patients;

import java.util.List;
import javax.validation.Valid;
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
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.patients.PatientDetailsService;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/patients")
@CrossOrigin(origins = { "http://localhost:4300" })
public class PatientDetailsWebService {

	@Autowired
	private PatientDetailsService patientDetailsService;

	@Autowired
	private EHRBaseService ehrBaseService;

	@PostMapping("/createPatientDetails")
	public ResponseEntity<PatientDetailsDTO> insertPatientDetails(@RequestBody PatientDetailsDTO patientDetailsDTO,
			BindingResult result) {

		ResponseEntity<PatientDetailsDTO> entity = this.validatePatientData(patientDetailsDTO, result);
		if (entity.getStatusCode().value() == 200) {
			PatientDetailsDTO createdPatient = patientDetailsService.persistPatientDetails(entity.getBody());
			return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
		} else {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}

	@GetMapping("/getAllPatients")
	public ResponseEntity<List<PatientDetailsDTO>> getAllPatients() {
		List<PatientDetailsDTO> patientDTO = patientDetailsService.retrieveAllPatients();
		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}

	@GetMapping("/getPatientRecordByPatientId")
	public ResponseEntity<PatientRecordDTO> getPatientRecordByPatientId(@RequestParam("patientId") Long patientId) {
		StaffMember staff = ehrBaseService.currentUser();
		PatientRecordDTO patientRecordsDTO = patientDetailsService.retrievePatientRecordPatientId(patientId,
				staff.getOrganization().getOrganizationId());
		return new ResponseEntity<>(patientRecordsDTO, HttpStatus.OK);
	}

	@GetMapping("/getPatientByPatientId")
	public ResponseEntity<PatientDetailsDTO> getPatientDetailsPatientId(@RequestParam("patientId") Long patientId) {
		PatientDetailsDTO patientDetailsDTO = patientDetailsService.retrievePatientDetailsPatientId(patientId);
		return new ResponseEntity<>(patientDetailsDTO, HttpStatus.OK);
	}

	@PutMapping("/modifyPatientDetails")
	public ResponseEntity<PatientDetailsDTO> modifyPatientDetails(@RequestBody PatientDetailsDTO patientDetailsDTO,
			BindingResult result) {
		ResponseEntity<PatientDetailsDTO> entity = this.validatePatientData(patientDetailsDTO, result);
		if (entity.getStatusCode().value() == 200) {
			PatientDetailsDTO updatedPatient = patientDetailsService.modifyPatientDetails(entity.getBody());
			return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
		} else {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}

	public ResponseEntity<PatientDetailsDTO> validatePatientData(@Valid PatientDetailsDTO patientDetailsDTO,
			BindingResult result) {
		List<PatientDetailsDTO> patientDTOList = patientDetailsService.retrieveAllPatients();
		HttpHeaders headers = new HttpHeaders();
		for (PatientDetailsDTO patient : patientDTOList) {

			if (!(patient.getPatientId().equals(patientDetailsDTO.getPatientId()))
					&& (patient.getFirstName().trim().equalsIgnoreCase(patientDetailsDTO.getFirstName().trim()))
					&& (patient.getLastName().trim().equalsIgnoreCase(patientDetailsDTO.getLastName().trim()))
					&& (patient.getDob().compareTo(patientDetailsDTO.getDob()) == 0)) {
				return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
			}
		}
		if (result.hasErrors()) {
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		StaffMember loginUser = ehrBaseService.currentUser();
		FormatConverterUtils.setInitialDefaultValues(patientDetailsDTO, loginUser);
		return new ResponseEntity<>(patientDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/getListOfActivePatientsfromsView")
	public ResponseEntity<List<PatientRecordDTO>> getListOfActivePatients() {
		StaffMember staff = ehrBaseService.currentUser();
		List<PatientRecordDTO> patientListResp = patientDetailsService
				.retrieveAllActivePatients(staff.getOrganization().getOrganizationId());

		return new ResponseEntity<>(patientListResp, HttpStatus.OK);
	}

	@GetMapping("/getListOfActivePatientByUserId")
	public ResponseEntity<List<PatientRecordDTO>> getListOfActivePatientByUserId() {
		StaffMember staff = ehrBaseService.currentUser();

		List<PatientRecordDTO> patientListResp = patientDetailsService
				.retrieveAllActivePatientsByUserId(staff.getLoginId(), staff.getLastLoginDate());

		return new ResponseEntity<>(patientListResp, HttpStatus.OK);
	}
}