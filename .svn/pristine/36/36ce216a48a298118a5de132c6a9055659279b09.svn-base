package com.cpa.ehr.backend.dao.admin;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.admin.constants.StaffRolesConstants;
import com.cpa.ehr.backend.dao.admin.entities.StaffRoles;

/**
 * Repository interface for Staff Roles Entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Repository
@Transactional
public interface StaffRolesRepository extends JpaRepository<StaffRoles, Long> {
	
	@Query(value = StaffRolesConstants.FIND_BY_STAFF_ID, nativeQuery = true)
	StaffRoles findActiveOneByStaffId(@Param("staffId") Long id);

	
	
}
