package com.cpa.ehr.backend.dao.admin;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.admin.constants.OrganizationConstants;
import com.cpa.ehr.backend.dao.admin.entities.Organization;



/**
 * 
 * Repository interface for Organization entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Repository
@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	/*
	 * Find List of All Active Organizations
	 * 
	 * @return organization
	 * 		returns list of all active Organizations
	 */
	@Query(value = OrganizationConstants.SELECT_BASE, nativeQuery = true)
	List <Organization> findAllActiveOrganizations();
	
	@Query(value = OrganizationConstants.FIND_ORG_BY_ID, nativeQuery = true)
	Organization findActiveOneByOrganizationId(@Param("organizationId") Long id);

}
