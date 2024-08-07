package com.cpa.ehr.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.admin.constants.ClinicLocationConstants;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;



/**
 * Repository interface for Clinic Location Entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Repository
@Transactional
public interface ClinicLocationRepository extends JpaRepository<ClinicLocation, Long> {
	
	@Query(value = ClinicLocationConstants.FIND_ALL_CLINIC_LOCATION, nativeQuery = true)
	List <ClinicLocation> findAllActiveClinicLocations(@Param("organizationId") Long organizationId);
	
	@Query(value = ClinicLocationConstants.FIND_ORG_BY_ID, nativeQuery = true)
	ClinicLocation findActiveOneByClinicLocationId(@Param("locationId") Long id);
	
	//commented code
}