package com.cpa.ehr.backend.dao.admin;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.admin.constants.RoleConstants;
import com.cpa.ehr.backend.dao.admin.entities.Role;

/**
 * Repository interface for Role Entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
	/*
	 * Find One Active Role By Authority
	 * 
	 * @param authority
	 * 		Unique Identifier of the Role
	 * 
	 * @return role
	 * 		Optionally return an Role when a suitable match for the Authority is found
	 */
	@Query(value = RoleConstants.FIND_ROLE_BY_AUTH, nativeQuery = true)
	Role findActiveRoleByAuthority(@Param("authority") String authority);	

}
