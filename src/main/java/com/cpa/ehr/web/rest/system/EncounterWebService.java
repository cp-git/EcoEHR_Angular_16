package com.cpa.ehr.web.rest.system;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.system.EncounterService;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.cpa.ehr.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/encounter")
@CrossOrigin(origins = { "http://localhost:4300" })
public class EncounterWebService {

	@Autowired
	private EncounterService encounterService;

	@Autowired
	private EHRBaseService ehrBaseService;

	@PostMapping("/createEncounter")
	public ResponseEntity<EncounterDTO> insertEncounter(@Valid @RequestBody EncounterDTO encounterDTO,
			BindingResult result) throws SQLException {
		StaffMember loginUser = ehrBaseService.currentUser();
		if (result.hasErrors()) {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
		} else {
			FormatConverterUtils.setInitialDefaultValues(encounterDTO, loginUser);
			EncounterDTO createdEnc = encounterService.persistEncounter(encounterDTO);
			return new ResponseEntity<>(createdEnc, HttpStatus.CREATED);
		}
	}

	@GetMapping("/getAllEncounterByPatientId")
	public ResponseEntity<List<EncounterDTO>> getAllEncounterByPatientId(@RequestParam("patientId") Long patientId) {
		StaffMember staffDetails = ehrBaseService.currentUser();

		if (staffDetails.getDesignation() == "TRY_ME") {
			List<EncounterDTO> encDTO = encounterService.retrieveAllEncounterByPatientIdForStud(
					staffDetails.getStaffId(), staffDetails.getLastLoginDate());
		} else {
			List<EncounterDTO> encDTO = encounterService.retrieveAllEncounterByPatientId(patientId);
			return new ResponseEntity<>(encDTO, HttpStatus.OK);
		}
		return null;
	}

	@GetMapping("/getEncounterByEncounterId")
	public ResponseEntity<EncounterDTO> getEncounterByEncounterId(@RequestParam("encounterId") Long encounterId) {
		EncounterDTO encDTO = encounterService.retrieveEncounterByEncounterId(encounterId);
		return new ResponseEntity<>(encDTO, HttpStatus.OK);
	}

	@GetMapping("/updateEncounter")
	public ResponseEntity<EncounterDTO> updateEncounter(@RequestParam("encounterId") Long encounterId,
			@RequestParam("templateId") Long templateId, @RequestParam("examName") String examName, @RequestParam("isEdited") String edited) {

		EncounterDTO createdEnc = encounterService.modifyEncounter(encounterId, templateId, examName,edited);
		return new ResponseEntity<>(createdEnc, HttpStatus.OK);
	}

	@PutMapping("/updateCompletedEncounter")
	public ResponseEntity<EncounterDTO> updateCompletedEncounter(@RequestBody EncounterDTO encounterDTO) {
		StaffMember loginUser = ehrBaseService.currentUser();
		FormatConverterUtils.setInitialDefaultValues(encounterDTO, loginUser);
		EncounterDTO updateEncounterDTO = encounterService.modifyCompletedEncounter(encounterDTO);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(updateEncounterDTO, HttpStatus.OK);
	}

	@PutMapping("/updateEncounterByEncounterID")
	public ResponseEntity<EncounterDTO> updateEncounterByEncounterId(@RequestBody EncounterDTO encounterDTO) {
		StaffMember loginUser = ehrBaseService.currentUser();
		FormatConverterUtils.setInitialDefaultValues(encounterDTO, loginUser);
		EncounterDTO updateEncounterDTO = encounterService.modifyEncounterByEncId(encounterDTO);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(updateEncounterDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEncounter")
	public ResponseEntity<Void> deleteEncounter(@RequestParam("encounterId") Long encounterId) {
		encounterService.removeEncounterByEncId(encounterId);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);

	}

}