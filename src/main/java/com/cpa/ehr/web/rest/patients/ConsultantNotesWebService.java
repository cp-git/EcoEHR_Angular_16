package com.cpa.ehr.web.rest.patients;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.patients.ConsultantNotesService;
import com.cpa.ehr.service.patients.dto.ConsultantNotesDTO;
import com.cpa.ehr.util.FormatConverterUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/rest/consultantnotes")
@CrossOrigin(origins = { "http://localhost:4300" })
public class ConsultantNotesWebService {

	private static final Logger LOG = LoggerFactory.getLogger( ConsultantNotesWebService.class);

	@Autowired
	private  ConsultantNotesService consultantNotesService;
	
	@Autowired
	private EHRBaseService ehrBaseService;


	@PostMapping("/createConsultantNotes")
	public ResponseEntity<ConsultantNotesDTO> insertConsultantNotes(@RequestBody ConsultantNotesDTO consultantNotesDTO,
			BindingResult result){
		HttpHeaders headers = new HttpHeaders();
		if(result.hasErrors()){
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		ConsultantNotesDTO dataconsultantNotesDTO=null;
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			FormatConverterUtils.setInitialDefaultValues(consultantNotesDTO, loginUser);
			dataconsultantNotesDTO = consultantNotesService.persistConsultantNotes(consultantNotesDTO);
		} catch (Exception e) {
			LOG.error("Error while inserting ConsultantNotes {}",e);
		}
		return new ResponseEntity<>(dataconsultantNotesDTO, headers, HttpStatus.CREATED);
	}

	@GetMapping("/getAllConsultantNotes")
	public ResponseEntity<List<ConsultantNotesDTO>> getAllConsultantNotes() {
		List<ConsultantNotesDTO> consultantNotesDTOResp=null;
		try {
			consultantNotesDTOResp = consultantNotesService.retrieveAllConsultantNotes();
		} catch (Exception e) {
			LOG.error("Error while retrieving all  ConsultantNotes {}",e);
		}
		return new ResponseEntity<>(consultantNotesDTOResp, HttpStatus.OK);
	}

	@GetMapping("/getConsultantNotesById")
	public ResponseEntity<ConsultantNotesDTO> getConsultantNotesById(@RequestParam("id") Long consultantNotesId) {
		ConsultantNotesDTO consultantNotesDTO = null;
		try {
			consultantNotesDTO =  consultantNotesService.retrieveConsultantNotesById( consultantNotesId);
		} catch (Exception e) {
			LOG.error("Error while retrieving By ConsultantNotes ID {}",e);
		}
		return new ResponseEntity<>(consultantNotesDTO , HttpStatus.OK);
	}

	@GetMapping("/getPatientConsultantNotesById")
	public ResponseEntity<List<ConsultantNotesDTO>> getPatientConsultantNotesById(@RequestParam("patientId") Long patientId) {
		List<ConsultantNotesDTO> patientConsultantNotesDTOResp=null;
		try {
			patientConsultantNotesDTOResp= consultantNotesService.retrievePatientConsultantNotesById(patientId);

		} catch (Exception e) {
			LOG.error("Error while retrieving all  ConsultantNotes By ID {}",e);
		}
		return new ResponseEntity<>(patientConsultantNotesDTOResp , HttpStatus.OK);
	}

	@PutMapping("/modifyConsultantNotes")
	public ResponseEntity<ConsultantNotesDTO> modifyConsultantNotes(@Valid @RequestBody ConsultantNotesDTO consultantNotesDTO,
			BindingResult result){
		if(result.hasErrors()){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		HttpHeaders headers = new HttpHeaders();
		ConsultantNotesDTO dataconsultantNotesDTO=null;
		try {
			dataconsultantNotesDTO = consultantNotesService.modifyConsultantNotes(consultantNotesDTO);
		} catch (Exception e) {
			LOG.error("Error while inserting  Data {}",e);
		}
		return new ResponseEntity<>(dataconsultantNotesDTO, headers, HttpStatus.CREATED);
	}


	@DeleteMapping("/removeConsultantNotesById")
	public ResponseEntity<Void> removeConsultantNotesById(@Valid @RequestParam("id") Long consultantNotesId){
		ConsultantNotesDTO consultantNotesDTO = consultantNotesService.retrieveConsultantNotesById(consultantNotesId);
		if(consultantNotesDTO !=null){
			consultantNotesService.deleteById( consultantNotesId);
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}
		else{
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
		}

	}

}









