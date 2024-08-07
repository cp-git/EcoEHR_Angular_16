package com.cpa.ehr.web.rest.admin;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cpa.ehr.service.admin.ClinicLocationService;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
import com.cpa.ehr.util.FormatConverterUtils;


/**
 * REST Interface to access Patient's Clinic 
 * Locations information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class ClinicLocationsWebService {
	private static final Logger LOG = LoggerFactory.getLogger(ClinicLocationsWebService.class);

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private ClinicLocationService clinicLocService;


	@GetMapping("/getListOfClinicLocations")
	public ResponseEntity<List <ClinicLocationDTO>> getListOfActiveClinicLocations() {
		StaffMember staff = ehrBaseService.currentUser();
		List<ClinicLocationDTO> clinicLocListResp = clinicLocService.retrieveAllClinicLocations(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (clinicLocListResp, HttpStatus.OK); 
	}	
	
	
	@PostMapping("/createClinicLocation")
	public ResponseEntity<ClinicLocationDTO> insertClinicLocation(@RequestBody ClinicLocationDTO clinicLocationDTO, BindingResult result) {
		ResponseEntity<ClinicLocationDTO> entity = this.validateClinicLocation(clinicLocationDTO,result);
		if(entity.getStatusCode().value() == 200) {
			ClinicLocationDTO createdClinicLoc = clinicLocService.persistClinicLocation(entity.getBody());
			return new ResponseEntity<>(createdClinicLoc, HttpStatus.CREATED);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}
	
	@GetMapping("/getClinicLocationById")
	public ResponseEntity<ClinicLocationDTO> getActiveClinicLocationById(@RequestParam("locationId") Long clinicLocId){
		ClinicLocationDTO clinicLocResp = clinicLocService.retrieveClinicLocationById(clinicLocId);
		return new ResponseEntity<> (clinicLocResp, HttpStatus.OK); 
	}
	
	@PutMapping("/modifyClinicLocationById")
	public ResponseEntity<ClinicLocationDTO> modifyClinicLocationById(@RequestBody ClinicLocationDTO clinicLocationDTO, BindingResult result){
		ResponseEntity<ClinicLocationDTO> entity = this.validateClinicLocation(clinicLocationDTO,result);
		if(entity.getStatusCode().value() == 200) {
			ClinicLocationDTO updatedClinicLoc = clinicLocService.updateClinicLocationById(entity.getBody());
			return new ResponseEntity<>(updatedClinicLoc, HttpStatus.OK);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}
	
	@DeleteMapping("/removeClinicLocationById")
	public ResponseEntity<Void> removeClinicLocationById(@RequestParam("locationId") Long clinicLocId) {
		if(clinicLocService.checkClinicLocationInUse(clinicLocId)) {
			clinicLocService.removeClinicLocationById(clinicLocId);
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
		    return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
		}
	}
	
	public ResponseEntity<ClinicLocationDTO> validateClinicLocation(@Valid ClinicLocationDTO clinicLocDTO, BindingResult result){
		StaffMember staff = ehrBaseService.currentUser();
		List<ClinicLocationDTO> clinicLocDTOList = clinicLocService.retrieveAllClinicLocations(staff.getOrganization().getOrganizationId());
		HttpHeaders headers= new HttpHeaders();
		for(ClinicLocationDTO clinic : clinicLocDTOList) {
			if(!(clinic.getLocationId().equals(clinicLocDTO.getLocationId())) && 
					(clinic.getLocationName().trim().equalsIgnoreCase(clinicLocDTO.getLocationName().trim()))) {
				return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
			}
		}
		if (result.hasErrors()) {
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		FormatConverterUtils.setInitialDefaultValues(clinicLocDTO, staff);
		return new ResponseEntity<>(clinicLocDTO, HttpStatus.OK);
	}
	
}
