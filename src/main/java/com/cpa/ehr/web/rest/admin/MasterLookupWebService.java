package com.cpa.ehr.web.rest.admin;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;
import com.cpa.ehr.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class MasterLookupWebService {
	
	@Autowired
	private MasterLookupService masterLookupService;
	
	@Autowired
	private EHRBaseService ehrBaseService;
	
	@GetMapping("/getListOfMasterLookupType")
	public ResponseEntity<List <String>> getListOfMasterLookupType() {
		StaffMember staff = ehrBaseService.currentUser();
		List<String> typeListResp = masterLookupService.retrieveAllMasterLookupType(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (typeListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfMasterLookup")
	public ResponseEntity<List <MasterLookupDTO>> getListOfMasterLookup() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllMasterLookup(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	

	@PostMapping("/createMasterLookup")
	public ResponseEntity<MasterLookupDTO> createMasterLookup(@RequestBody MasterLookupDTO masterLookupDTO, BindingResult result) {
		ResponseEntity<MasterLookupDTO> entity = this.validateMasterLookupData(masterLookupDTO,result);
		if(entity.getStatusCode().value() == 200) {
			MasterLookupDTO createdMasterLookup = masterLookupService.persistMasterLookup(entity.getBody());
			return new ResponseEntity<>(createdMasterLookup, HttpStatus.CREATED);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}
	
	public ResponseEntity<MasterLookupDTO> validateMasterLookupData(@Valid MasterLookupDTO masterLookupDTO, BindingResult result){
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupDTOList = masterLookupService.retrieveAllMasterLookup(staff.getOrganization().getOrganizationId());
		HttpHeaders headers= new HttpHeaders();
		for(MasterLookupDTO masterLookup : masterLookupDTOList) {
			if((masterLookup.getLookupCode().trim().equalsIgnoreCase(masterLookupDTO.getLookupCode().trim())) && 
					(masterLookup.getLookupType().trim().equalsIgnoreCase(masterLookupDTO.getLookupType().trim()))) {
				return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
			}
		}
		if (result.hasErrors()) {
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		StaffMember loginUser = ehrBaseService.currentUser();
		FormatConverterUtils.setInitialDefaultValues(masterLookupDTO, loginUser);
		return new ResponseEntity<>(masterLookupDTO, HttpStatus.OK);
	}

	@PostMapping("/createCredentials")
	public ResponseEntity<MasterLookupDTO> createCredentials(@RequestBody MasterLookupDTO masterLookupDTO) {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> credentialsResp = masterLookupService.retrieveAllCredentials(staff.getOrganization().getOrganizationId());

		Iterator<MasterLookupDTO> itr=credentialsResp.iterator();
		while(itr.hasNext()) {
			String credential = itr.next().getLookupCode().toLowerCase();
			if(credential.contentEquals(masterLookupDTO.getLookupCode().toLowerCase())) {
				HttpHeaders headers= new HttpHeaders();
				return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
			}
		}		

		FormatConverterUtils.setInitialDefaultValues(masterLookupDTO, staff);
		MasterLookupDTO createdCredential = masterLookupService.persistMasterLookup(masterLookupDTO);
		return new ResponseEntity<> (createdCredential, HttpStatus.CREATED); 
	}	
	
	@GetMapping("/getListOfAddressStates")
	public ResponseEntity<List <MasterLookupDTO>> getListOfAddressStates() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllAddressStates(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	

	@GetMapping("/getListOfPatientStatus")
	public ResponseEntity<List <MasterLookupDTO>> getListOfPatientStatus() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllPatientStatus(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfCredentials")
	public ResponseEntity<List <MasterLookupDTO>> getListOfCredentials() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllCredentials(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfProviderTypes")
	public ResponseEntity<List <MasterLookupDTO>> getListOfProviderTypes() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllProviderTypes(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfSpecializationForStud")
	public ResponseEntity<List <MasterLookupDTO>> getListOfSpecializationForStud() {
		//StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllSpecialisationForStud();
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfFrequency")
	public ResponseEntity<List <MasterLookupDTO>> getListOfFrequency() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllFrequency(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getRoute")
	public ResponseEntity<List <MasterLookupDTO>> getRoute() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllRoute(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getTitles")
	public ResponseEntity<List <MasterLookupDTO>> getTitles() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllTitle(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getLanguage")
	public ResponseEntity<List <MasterLookupDTO>> getListOfLanguage() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllLanguage(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getRace")
	public ResponseEntity<List <MasterLookupDTO>> getListOfRace() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllRace(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getEthnicity")
	public ResponseEntity<List <MasterLookupDTO>> getListOfEthnicity() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retrieveAllEthnicity(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@DeleteMapping("/removeMasterLookup")
	public ResponseEntity<Void> deleteMasterLookupById(@RequestParam("lookupId") Long lookupId) {
		masterLookupService.deleteMasterLookupById(lookupId);
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}	
	
	@GetMapping("/getListOfMasterLookupByRefillType")
	public ResponseEntity<List <MasterLookupDTO>> getListOfMasterLookupByRefill() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retriveAllMasterLookupByRefill(staff.getOrganization().getOrganizationId());
		System.out.println("LOokUpType-REFILL: "+masterLookupListResp.toString());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfMasterLookupByDiscontinuesReason")
	public ResponseEntity<List <MasterLookupDTO>> getListOfMasterLookupByDiscontinuedReason() {
		StaffMember staff = ehrBaseService.currentUser();
		List<MasterLookupDTO> masterLookupListResp = masterLookupService.retriveAllMasterLookupByDISCONTINUEDREASON(staff.getOrganization().getOrganizationId());
		System.out.println("LOokUpType-REFILL: "+masterLookupListResp.toString());
		return new ResponseEntity<> (masterLookupListResp, HttpStatus.OK); 
	}
}