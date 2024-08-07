package com.cpa.ehr.service.patients;
import com.cpa.ehr.service.patients.dto.OrdersDTO;

import java.util.List;


public interface OrdersService {

	OrdersDTO persistOrders(OrdersDTO ordersDTOpersist) ;

	List<OrdersDTO> retrieveOrdersByPatientId(Long orderId);
	
	List<OrdersDTO> retrieveOrdersByPatientIdEncId(Long orderId,Long encId);

	List<OrdersDTO> retrieveAllOrders();

	OrdersDTO retrieveOrdersById(Long patientId);
	
	OrdersDTO modifyOrders(OrdersDTO ordersDTOUpdate);

	public void deleteById(Long orderId);
}