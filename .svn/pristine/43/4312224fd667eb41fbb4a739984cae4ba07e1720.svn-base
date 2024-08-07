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
import com.cpa.ehr.service.system.ChiefCompliantDetailsService;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/chiefCompliantDtls")
@CrossOrigin(origins = { "http://localhost:4300" })
public class ChiefCompliantDetailsWebService {
	
	@Autowired
	private ChiefCompliantDetailsService chiefCompliantDetailsService;
	
	@Autowired
	private EHRBaseService ehrBaseService;
	
	@PostMapping("/createChiefCompliant")
	public ResponseEntity<ChiefCompliantDetailsDTO> insertChiefCompliantDetails(@Valid @RequestBody List<ChiefCompliantDetailsDTO> chiefCompliantDetailsDTO, BindingResult result,@RequestParam("encounterId") Long encounterId)	throws  SQLException {
		StaffMember loginUser = ehrBaseService.currentUser();
		List<ChiefCompliantDetailsDTO> insertedRecord = chiefCompliantDetailsService.retrieveAllChiefCompliantByEncounterId(encounterId);
		if(result.hasErrors())  {
			HttpHeaders headers= new HttpHeaders();
		    return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
		}
		else {	
		HttpHeaders headers= new HttpHeaders();
		for (ChiefCompliantDetailsDTO chiefCompliantDetailsDTOObj : chiefCompliantDetailsDTO) {
			ChiefCompliantDetailsDTO record = chiefCompliantDetailsService.retrieveCompliantByEncIdAndCode(chiefCompliantDetailsDTOObj.getIcd10Code(),encounterId);
			if(record==null) {           //If Record is new,insert it.
				FormatConverterUtils.setInitialDefaultValues(chiefCompliantDetailsDTOObj, loginUser);
				chiefCompliantDetailsService.persistChiefCompliantDetails(chiefCompliantDetailsDTOObj);
			}
			else {                       //If Record is already in DB,check for Primary Flag & update it.
				if(!record.getPrimaryFlag().equals(chiefCompliantDetailsDTOObj.getPrimaryFlag())) {
					FormatConverterUtils.setInitialDefaultValues(chiefCompliantDetailsDTOObj, loginUser);
					chiefCompliantDetailsService.updateChiefCompliantDetails(record,chiefCompliantDetailsDTOObj);
				}
			}
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	  }
	}
	

	
	@GetMapping("/getAllChiefCompliantByEncounterId")
	public ResponseEntity<List<ChiefCompliantDetailsDTO>> getAllChiefCompliantByEncounterId(@RequestParam("encounterId") Long encounterId) {
		List<ChiefCompliantDetailsDTO> chiefCompliantSetails = chiefCompliantDetailsService.retrieveAllChiefCompliantByEncounterId(encounterId);
		return new ResponseEntity<>(chiefCompliantSetails, HttpStatus.OK);
	}
	
	@GetMapping("/getIcd10DetailsOfLastFiveEncounters")
	public ResponseEntity<List<ChiefCompliantDetailsDTO>> getIcd10DetailsOfLastFiveEncounters(@RequestParam("patientId") Long patientId) {
		List<ChiefCompliantDetailsDTO> icd10Details = chiefCompliantDetailsService.retrieveIcd10DetailsOfLastFiveEncounters(patientId);
		return new ResponseEntity<>(icd10Details, HttpStatus.OK);
	}
	
	@PostMapping("/deleteCompliant")
	public ResponseEntity<Void> deleteCompliant(@RequestBody List<ChiefCompliantDetailsDTO> chiefCompliantDetailsDTO)
	{
		List<ChiefCompliantDetailsDTO> chiefCompliantDetails = chiefCompliantDetailsService.retrieveAllChiefCompliantByEncounterId(chiefCompliantDetailsDTO.get(0).getEncounterId());
		for (ChiefCompliantDetailsDTO chiefCompliantDetailsDTOObj : chiefCompliantDetails) { 
		boolean val = chiefCompliantDetailsDTO.stream().map(ChiefCompliantDetailsDTO::getIcd10Code).anyMatch(chiefCompliantDetailsDTOObj.getIcd10Code()::equals);
		if(val==false) {
			chiefCompliantDetailsService.deleteCompliantById(chiefCompliantDetailsDTOObj.getChiefCompliantDtlId());
		}
	     }
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}
	
}
