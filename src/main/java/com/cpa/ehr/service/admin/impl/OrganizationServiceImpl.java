package com.cpa.ehr.service.admin.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.service.admin.OrganizationService;
import com.cpa.ehr.service.admin.dto.OrganizationDTO;
import com.cpa.ehr.service.admin.dto.mapper.OrganizationMapper;

/**
 * Implementation for the Organization Service
 * 
 * OrganizationService holds all the interfaces
 * supported for performing CRUD operations against 
 * Organization Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Autowired
	private OrganizationMapper orgMapper;
	


	/**
	 * Retrieves list of all active organizations
	 * 
	 * @return List of all active organizations
	 */
	@Override
	public List<OrganizationDTO> retrieveAllActiveOrganizations() {
		List<Organization> orgsList = orgRepo.findAllActiveOrganizations();
		return (orgsList != null) ? orgMapper.entityListToOrganizationDTOList(orgsList) : Collections.emptyList();
	}

	
}
