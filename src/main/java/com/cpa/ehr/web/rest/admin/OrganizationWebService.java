package com.cpa.ehr.web.rest.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.service.admin.OrganizationService;
import com.cpa.ehr.service.admin.dto.OrganizationDTO;


/**
 * REST Interface to access Organization information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
public class OrganizationWebService {
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(OrganizationWebService.class);
	
	@Autowired
	private OrganizationService orgService;
	
	
	
	/**
	 * Fetched list of all active organizations
	 * 
	 * @return 
	 * 		List of all active organizations
	 */
	@GetMapping("/getListOfActiveOrganizations")
	public ResponseEntity<List <OrganizationDTO>> getListOfActiveOrganizations() {
		List<OrganizationDTO> orgsListResp = orgService.retrieveAllActiveOrganizations();
		return new ResponseEntity<> (orgsListResp, HttpStatus.OK); 
	}	
	
	
}
