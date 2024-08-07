package com.cpa.ehr.backend.dao.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpa.ehr.backend.dao.admin.constants.StaffPaymentDetailsConstants;
import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.backend.dao.admin.entities.StaffRoles;

public interface StaffPaymentDetailsRepository extends JpaRepository<StaffPaymentDetails, Long>{

	@Query(value = StaffPaymentDetailsConstants.FIND_PAYMENT_DETAILS, nativeQuery = true)
	StaffPaymentDetails findStaffPaymentStatus(@Param("staffId") Long id);
	
	@Query(value =  StaffPaymentDetailsConstants.GET_PAYMENT_STATUS_BY_ID, nativeQuery = true)
	Optional<StaffPaymentDetails>  getStaffPaymentStatus(@Param("staffId") Long staffId);
	
}
