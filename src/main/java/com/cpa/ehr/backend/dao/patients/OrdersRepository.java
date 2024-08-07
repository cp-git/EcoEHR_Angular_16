package com.cpa.ehr.backend.dao.patients;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.patients.constants.OrdersConstants;
import com.cpa.ehr.backend.dao.patients.entities.Orders;

@Transactional
@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Long> {
	
	@Query(value = OrdersConstants.FIND_ALL_BY_PATIENT_ID, nativeQuery = true)
	List<Orders> findOrdersByPatientId(@Param("patientId") Long patientId);
	
	@Query(value = OrdersConstants.FIND_ALL_BY_PATIENT_ID_ENC_ID, nativeQuery = true)
	List<Orders> findOrdersByPatientIdEncId(@Param("patientId") Long patientId,@Param("encounterId") Long encounterId);
}