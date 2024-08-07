package com.cpa.ehr.web.rest.admin;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffDetailsService;
import com.cpa.ehr.service.admin.dto.StaffDetailsDTO;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;


/**
 * REST Interface to access Staff Member 
 * information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class StaffDetailsWebService {
	private static final Logger LOG = LoggerFactory.getLogger(StaffDetailsWebService.class);

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private StaffDetailsService staffDetailsService;
	
	@GetMapping("/getActiveStaffMemberFromView")
	public ResponseEntity<StaffDetailsDTO> getActiveStaffMemberById(@RequestParam("staffId")Long id) {
		StaffDetailsDTO staffDetailsResp = staffDetailsService.retrieveStaffDetailsById(id);
		return new ResponseEntity<> (staffDetailsResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getCCMProviders")
	public ResponseEntity<List<StaffDetailsDTO>> getCCMProviders() {
		LOG.debug("Request to fetch all staff members!");
		StaffMember staff = ehrBaseService.currentUser();
		List<StaffDetailsDTO> staffMemberListResp = staffDetailsService.retrieveAllCCMProviders(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (staffMemberListResp, HttpStatus.OK); 
	}	
	
	@GetMapping("/getListOfActiveStaffMembersfromsView")
	public ResponseEntity<List<StaffDetailsDTO>> getListOfActiveStaffMembers() {
		LOG.debug("Request to fetch all staff members!");
		StaffMember staff = ehrBaseService.currentUser();
		List<StaffDetailsDTO> staffMemberListResp = staffDetailsService.retrieveAllStaffMembers(staff.getOrganization().getOrganizationId());
		return new ResponseEntity<> (staffMemberListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getListOfActiveStudentMembersfromsView")
	public ResponseEntity<List<StaffDetailsDTO>> getListOfActiveStudentMembersfromsView() {
		LOG.debug("Request to fetch all students members!");
		//StaffMember staff = ehrBaseService.currentUser();
		List<StaffDetailsDTO> staffMemberListResp = staffDetailsService.retrieveAllStudentMembers();
		return new ResponseEntity<> (staffMemberListResp, HttpStatus.OK);
	}

}
