package com.cpa.ehr.service.admin;

import java.util.List;

import com.cpa.ehr.service.admin.dto.OrganizationDTO;


/**
 * Interface OrganizationService holds all the interfaces
 * supported for performing CRUD operations against 
 * Organization Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public interface OrganizationService {

	
	/**
	 * Retrieves list of all active organizations
	 * 
	 * @return List of all active organizations
	 */
	List <OrganizationDTO> retrieveAllActiveOrganizations();
	
	
}
