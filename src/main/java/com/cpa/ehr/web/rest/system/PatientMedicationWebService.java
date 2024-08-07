package com.cpa.ehr.web.rest.system;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.exception.entities.EhrBaseException;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
import com.cpa.ehr.service.system.PatientMedicationService;
import com.cpa.ehr.service.system.dto.PatientMedicationDTO;
import com.cpa.ehr.service.system.dto.PatientMedicationRecordDTO;
import com.cpa.ehr.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/patientMedication")
@CrossOrigin(origins = { "http://localhost:4300" })
public class PatientMedicationWebService {

	@Autowired
	EHRBaseService ehrbaseservice;
	@Autowired
	PatientMedicationService patientMedicationService;

	@GetMapping("/getListOfPatientMedication")
	public ResponseEntity<List<PatientMedicationRecordDTO>> getListOfPatientMedication(@RequestParam("patientId") Long patientId) {
		List<PatientMedicationRecordDTO> medResp = patientMedicationService.retrieveAllPatientMedicationRecord(patientId);
		return new ResponseEntity<>(medResp, HttpStatus.OK);
	}

	@PostMapping("/createPatientMedication")
	public ResponseEntity<PatientMedicationDTO> createPatientMedication(
			@Valid @RequestBody List<PatientMedicationDTO> patientMedicationDTO, BindingResult result)
			throws EhrBaseException, SQLException {
		StaffMember loginUser = ehrbaseservice.currentUser();
		HttpHeaders headers = new HttpHeaders();
		if(result.hasErrors())
		{
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		for (PatientMedicationDTO patientMedicationDTOSingleObj : patientMedicationDTO) {
			FormatConverterUtils.setInitialDefaultValues(patientMedicationDTOSingleObj, loginUser);
			System.out.println(patientMedicationDTOSingleObj);
			patientMedicationService.persistPatientMedication(patientMedicationDTOSingleObj);
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/deletePatientMedication")
	public ResponseEntity<Void> inActivePatientMedications(@RequestBody PatientMedicationDTO patientMedicationDTO)
	{
		StaffMember loginUser = ehrbaseservice.currentUser();
		FormatConverterUtils.setInitialDefaultValues(patientMedicationDTO, loginUser);
		patientMedicationService.inActivePatientMedication(patientMedicationDTO);
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}

//	encId
	@GetMapping("/getListPatientMedicationByEncId")
	public ResponseEntity<List<PatientMedicationDTO>> getListofPatientMedicationByencId(@RequestParam("encounterId")Long encounterId)
	{
		List<PatientMedicationDTO> patientmedicationlist = patientMedicationService.retrieveAllPatientMedicationByencId(encounterId);
		return new ResponseEntity<>(patientmedicationlist,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePatientMedicationByenc")
	public ResponseEntity<Void> deletePatientMedicationByEnc(@RequestParam("encounterId")Long encounterId)
	{
		
		patientMedicationService.deletePatientMedication(encounterId);
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}
}
