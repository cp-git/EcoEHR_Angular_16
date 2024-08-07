package com.cpa.ehr.web.rest.preventivecare;


import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.service.preventivecare.MasterPreventiveCareService;
import com.cpa.ehr.service.preventivecare.dto.MasterPreventiveCareDTO;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/rest/masterpreventive")
@CrossOrigin(origins = { "http://localhost:4300" })
public class MasterPreventiveCareWebService {

	private static final Logger LOG = LoggerFactory.getLogger( MasterPreventiveCareWebService.class);


	@Autowired
	private  MasterPreventiveCareService masterPreventiveCareService;

	
//	@PostMapping("/createMasterPreventiveCare")
//	public ResponseEntity<MasterPreventiveCareDTO> insertMasterPreventiveCare(@Valid @RequestBody MasterPreventiveCareDTO masterPreventiveCareDTO,
//			BindingResult result){
//				if(result.hasErrors()){
//			HttpHeaders headers = new HttpHeaders();
//			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
//			}
//
//			HttpHeaders headers = new HttpHeaders();
//			MasterPreventiveCareDTO datamasterPreventiveCareDTO=null;
//			try {
//			datamasterPreventiveCareDTO = masterPreventiveCareService.persistMasterPreventiveCare(masterPreventiveCareDTO);
//			} catch (Exception e) {
//				LOG.error("Error while inserting MasterPreventiveCare {}",e);
//			}
//			return new ResponseEntity<>(datamasterPreventiveCareDTO, headers, HttpStatus.CREATED);
//	}

	@GetMapping("/getAllMasterPreventiveCare")
	public ResponseEntity<List<MasterPreventiveCareDTO>> getAllMasterPreventiveCare(@RequestParam("patientId") Long patientId) {
		System.out.println("B4--------------");
		List<MasterPreventiveCareDTO> masterPreventiveCareDTOResp=null;
		System.out.println("Patient Id----------------"+patientId);
		
		try {
			 
			masterPreventiveCareDTOResp = masterPreventiveCareService.retrieveAllMasterPreventiveCare(patientId);
			System.out.println("Returning in web ser-->"+masterPreventiveCareDTOResp);
			
		} catch (Exception e) {
			LOG.error("Error while retrieving all  MasterPreventiveCare {}",e);
		}
		return new ResponseEntity<>(masterPreventiveCareDTOResp, HttpStatus.OK);
	}

//		@GetMapping("/getMasterPreventiveCareById")
//	public ResponseEntity<MasterPreventiveCareDTO> getMasterPreventiveCareById(@RequestParam("id") Long preventiveCareId) {
//	MasterPreventiveCareDTO masterPreventiveCareDTO = null;
//		try {
//			masterPreventiveCareDTO =  masterPreventiveCareService.retrieveMasterPreventiveCareById( preventiveCareId);
//		} catch (Exception e) {
//			LOG.error("Error while retrieving By MasterPreventiveCare ID {}",e);
//		}
//		return new ResponseEntity<>(masterPreventiveCareDTO , HttpStatus.OK);
//	}


	
//	@PutMapping("/modifyMasterPreventiveCare")
//	public ResponseEntity<MasterPreventiveCareDTO> modifyMasterPreventiveCare(@Valid @RequestBody MasterPreventiveCareDTO masterPreventiveCareDTO,
//			BindingResult result){
//				if(result.hasErrors()){
//			HttpHeaders headers = new HttpHeaders();
//			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
//			}
//
//			HttpHeaders headers = new HttpHeaders();
//			MasterPreventiveCareDTO datamasterPreventiveCareDTO=null;
//			try {
//			datamasterPreventiveCareDTO = masterPreventiveCareService.modifyMasterPreventiveCare(masterPreventiveCareDTO);
//			} catch (Exception e) {
//				LOG.error("Error while inserting  Data {}",e);
//			}
//			return new ResponseEntity<>(datamasterPreventiveCareDTO, headers, HttpStatus.CREATED);
//	}


//	@DeleteMapping("/removeMasterPreventiveCareById")
//	public ResponseEntity<Void> removeMasterPreventiveCareById(@Valid @RequestParam("id") Long preventiveCareId){
//	MasterPreventiveCareDTO masterPreventiveCareDTO = masterPreventiveCareService.retrieveMasterPreventiveCareById(preventiveCareId);
//	if(masterPreventiveCareDTO !=null){
//	masterPreventiveCareService.deleteById( preventiveCareId);
//	HttpHeaders headers= new HttpHeaders();
//			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
//	
//	}
//
//	else{
//	HttpHeaders headers= new HttpHeaders();
//		    return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
//	}
//	
//	}

}










