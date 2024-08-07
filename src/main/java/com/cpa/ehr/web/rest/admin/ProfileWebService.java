package com.cpa.ehr.web.rest.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.security.SecurityContextService;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;
import com.cpa.ehr.service.system.dto.RequestForDemoDTO;


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
public class ProfileWebService {
	
	
	@Autowired
	private SecurityContextService securityContextService;
	
	@Autowired
	private StaffRolesService staffRolesService;
	
	@Autowired
	private EHRBaseService ehrBaseService;
	
	@GetMapping("/isAdmin")
	public ResponseEntity<Boolean> isAdmin(HttpServletRequest request) {
		StaffRolesDTO role= staffRolesService.retrieveStaffRolesByStaffId(securityContextService.currentUser().getStaffId());
		if(role.getAuthority().contentEquals("ROLE_ADMIN")) 
			return new ResponseEntity<>(true, HttpStatus.OK);
		else return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<StaffMember> getProfile(HttpServletRequest request) {
		StaffMember staff = ehrBaseService.currentUser();
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentInfo")
	public ResponseEntity<StaffPaymentDetails> getPaymentStatus(HttpServletRequest request){
		StaffPaymentDetails staff = ehrBaseService.getPaymentStatus();
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}
	
}