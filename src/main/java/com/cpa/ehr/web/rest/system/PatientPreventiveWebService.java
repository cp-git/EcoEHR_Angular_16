package com.cpa.ehr.web.rest.system;


import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.system.PatientPreventiveCareService;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
import com.cpa.ehr.service.system.dto.PatientPreventiveCareDTO;
import com.cpa.ehr.util.FormatConverterUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/rest/patientPreventive")
@CrossOrigin(origins = { "http://localhost:4300" })
public class PatientPreventiveWebService {

	private static final Logger LOG = LoggerFactory.getLogger( PatientPreventiveWebService.class);


	@Autowired
	private  PatientPreventiveCareService patientPreventiveCareService;

	@Autowired
	private EHRBaseService ehrBaseService;

	@PostMapping("/createPatientPreventiveCare")
	public ResponseEntity<PatientPreventiveCareDTO> insertPatientPreventiveCare(@Valid @RequestBody List<PatientPreventiveCareDTO> patientPreventiveCareDTO,
			BindingResult result) {
		HttpHeaders headers = new HttpHeaders();
		StaffMember loginUser = ehrBaseService.currentUser();
		for (PatientPreventiveCareDTO patientPreventiveCareDTOObj : patientPreventiveCareDTO) {
			FormatConverterUtils.setInitialDefaultValues(patientPreventiveCareDTOObj, loginUser);
			patientPreventiveCareService.persistPatientPreventiveCare(patientPreventiveCareDTOObj);
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/getAllPatientPreventiveCare")
	public ResponseEntity<List<PatientPreventiveCareDTO>> getAllPatientPreventiveCare() {
		List<PatientPreventiveCareDTO> patientPreventiveCareDTOResp=null;
		try {
			patientPreventiveCareDTOResp = patientPreventiveCareService.retrieveAllPatientPreventiveCare();
		} catch (Exception e) {
			LOG.error("Error while retrieving all  PatientPreventiveCare {}",e);
		}
		return new ResponseEntity<>(patientPreventiveCareDTOResp, HttpStatus.OK);
	}

	@GetMapping("/getPatientPreventiveCareById")
	public ResponseEntity<List<PatientPreventiveCareDTO>> getPatientPreventiveCareById(@RequestParam("patientID1") Long patientId) {
		List<PatientPreventiveCareDTO> patientPreventiveCareDTOResp=null;
		try {
			patientPreventiveCareDTOResp= patientPreventiveCareService.retrievePatientPreventiveCareById(patientId);
			
		} catch (Exception e) {
			LOG.error("Error while retrieving all  PatientAllergy {}",e);
		}
		return new ResponseEntity<>(patientPreventiveCareDTOResp , HttpStatus.OK);
	}
		
//		List<PatientPreventiveCareDTO> patientPreventiveCareDTO = null;
//		System.out.println("inside the service of pc patient id");
//		try {
//			System.out.println("Patient Id: "+patientId);
//			patientPreventiveCareDTO =  patientPreventiveCareService.retrievePatientPreventiveCareById(patientId);
//			System.out.println("PatientPreventive------------------------>>> "+patientPreventiveCareDTO);
//		} catch (Exception e) {
//			LOG.error("Error while retrieving By PatientPreventiveCare ID {}",e);
//		}
//		return new ResponseEntity<>(patientPreventiveCareDTO , HttpStatus.OK);
	

	@PutMapping("/modifyPatientPreventiveCare")
	public ResponseEntity<PatientPreventiveCareDTO> modifyPatientPreventiveCare(@Valid @RequestBody PatientPreventiveCareDTO patientPreventiveCareDTO,
			BindingResult result){
		if(result.hasErrors()){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}

		HttpHeaders headers = new HttpHeaders();
		PatientPreventiveCareDTO datapatientPreventiveCareDTO=null;
		try {
			datapatientPreventiveCareDTO = patientPreventiveCareService.modifyPatientPreventiveCare(patientPreventiveCareDTO);
		} catch (Exception e) {
			LOG.error("Error while inserting  Data {}",e);
		}
		return new ResponseEntity<>(datapatientPreventiveCareDTO, headers, HttpStatus.CREATED);
	}

}










