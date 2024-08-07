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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;
import com.cpa.ehr.util.FormatConverterUtils;




/**
 * REST Interface to access Staff Roles 
 * information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class StaffRolesWebService {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(StaffRolesWebService.class);

	@Autowired
	private StaffRolesService staffRolesService;
	
	
	@Autowired
	private EHRBaseService ehrBaseService;

	/**
	 * Create a New Staff Roles
	 * 
	 * @param staffRolesDTO
	 * 		DTO of the Staff Roles
	 * @param result
	 * 		Object of BindingResult
	 * @return StaffRolesDTO
	 * 		New Staff Roles persisted in DB
	 */
	@CrossOrigin
	@PostMapping("/createStaffRoles")
	public ResponseEntity<StaffRolesDTO> createStaffRoles(@Valid @RequestBody StaffRolesDTO staffRolesDTO, BindingResult result) {
		if(staffRolesDTO.getAuthority().equalsIgnoreCase("TRY_ME")) {
			FormatConverterUtils.setInitialStudDefaultValues(staffRolesDTO);
		}else {
			StaffMember loginUser = ehrBaseService.currentUser();
			FormatConverterUtils.setInitialDefaultValues(staffRolesDTO, loginUser);
		}
		
		//staffRolesDTO.setAuthority("ROLE_USER");
		StaffRolesDTO createdStaffRole = staffRolesService.persistStaffRoles(staffRolesDTO);
//		System.out.println("createdStaffRole ----------------- "+createdStaffRole);
		return new ResponseEntity<> (createdStaffRole, HttpStatus.CREATED);
	}	

	@PutMapping("/modifyStaffRolesById")
	public ResponseEntity<StaffRolesDTO> modifyStaffRolesById(@RequestBody StaffRolesDTO staffRolesDTO) {
		StaffMember loginUser = ehrBaseService.currentUser();
		FormatConverterUtils.setInitialDefaultValues(staffRolesDTO, loginUser);
		StaffRolesDTO updatedStaffRoles = staffRolesService.updateStaffRolesById(staffRolesDTO);
		return new ResponseEntity<> (updatedStaffRoles, HttpStatus.OK); 
	}	
	
}
	
