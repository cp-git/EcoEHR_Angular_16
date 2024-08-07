package com.cpa.ehr.service.patients.impl;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.patients.OrdersRepository;
import com.cpa.ehr.backend.dao.patients.entities.Orders;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.patients.OrdersService;
import com.cpa.ehr.service.patients.dto.OrdersDTO;
import com.cpa.ehr.service.patients.dto.mapper.OrdersMapper;

@Service
public class OrdersServiceImpl implements OrdersService {

	private static final Logger LOG = LoggerFactory.getLogger(OrdersServiceImpl.class);

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrdersMapper ordersMapper;


	@Autowired
	private EHRBaseService ehrBaseService;

	public OrdersDTO persistOrders(OrdersDTO ordersDTOpersist){
		try{
			if(ordersDTOpersist !=null){
				Orders orders = ordersMapper.convertOrdersDTOToEntity(ordersDTOpersist);
				//System.out.println("-----------------------------> "+orders);
				Orders ordersIn =  ordersRepository.save(orders);
				return (ordersIn !=null) ?  ordersMapper.convertEntityToOrdersDTO(ordersIn) : null;
			}
		}
		catch (Exception e){
			LOG.error("Error while inserting Orders {} ", e);
		}
		return null;
	}

	public List<OrdersDTO> retrieveOrdersByPatientId(Long patientId){
		try {
			List<Orders> orders = ordersRepository.findOrdersByPatientId(patientId);
			return (orders != null) ?  ordersMapper.entityListToOrdersDTOList(orders) :null;
		}
		catch (Exception e){
			LOG.error("Error Message",e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<OrdersDTO> retrieveOrdersByPatientIdEncId(Long patientId,Long encId) {
		try {
			List<Orders> orders = ordersRepository.findOrdersByPatientIdEncId(patientId,encId);
			return (orders != null) ?  ordersMapper.entityListToOrdersDTOList(orders) :null;
		}
		catch (Exception e){
			LOG.error("Error Message",e);
		}
		return Collections.emptyList();
	}

	public List<OrdersDTO> retrieveAllOrders(){
		try {
			List<Orders> ordersList = ordersRepository.findAll();
			return( ordersList != null) ?  ordersMapper.entityListToOrdersDTOList(ordersList) : null;
		}
		catch (Exception e){
			LOG.error("Error message",e);
		}
		return Collections.emptyList();

	}

	public 	OrdersDTO modifyOrders(OrdersDTO ordersDTOUpdate){
		//	try{
		//	if(ordersDTOUpdate !=null){
		//					Orders  orders = ordersRepository.findById(ordersDTOUpdate.getOrderId()).get();
		//	 Orders ordersUpdate =  ordersRepository.save(orders);
		//	return (ordersUpdate !=null) ?  ordersMapper.convertEntityToOrdersDTO(ordersUpdate) : null;
		//					
		//	}
		//}
		//	catch (Exception e){
		//			LOG.error("Error while updating Orders {} ", e);
		//		}
		return null;
	}

	public void deleteById(Long orderId){

		try 
		{
			StaffMember loginUser = ehrBaseService.currentUser();
			Orders orders = ordersRepository.findOne(orderId);
			if(orders!=null)
			{
				orders.setLastUpdatedBy(loginUser.getLoginId());
				orders.setLastUpdatedDate(new Date());
				orders.setActiveFlag("N");
				ordersRepository.saveAndFlush(orders);
			}
		}
		catch(Exception e)
		{
			LOG.error("Error while removing Orders {}" ,e);
		}

	}

	@Override
	public OrdersDTO retrieveOrdersById(Long orderId) {
		try{
			if(orderId !=null){
				Orders ordersIn =  ordersRepository.findOne(orderId);
				return (ordersIn !=null) ?  ordersMapper.convertEntityToOrdersDTO(ordersIn) : null;
			}
		}
		catch (Exception e){
			LOG.error("Error while inserting Orders {} ", e);
		}
		return null;
	}



}










