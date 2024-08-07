package com.cpa.ehr.web.rest.patients;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.patients.OrdersService;
import com.cpa.ehr.service.patients.dto.OrdersDTO;
import com.cpa.ehr.util.FormatConverterUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/rest/order")
@CrossOrigin(origins = { "http://localhost:4300" })
public class OrdersWebService {

	private static final Logger LOG = LoggerFactory.getLogger( OrdersWebService.class);


	@Autowired
	private  OrdersService ordersService;

	@Autowired
	private EHRBaseService ehrBaseService;


	@PostMapping("/createOrders")
	public ResponseEntity<OrdersDTO> insertOrders(@Valid @RequestBody OrdersDTO ordersDTO,
			BindingResult result){
		HttpHeaders headers = new HttpHeaders();
		if(result.hasErrors()){
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		OrdersDTO dataordersDTO=null;
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			FormatConverterUtils.setInitialDefaultValues(ordersDTO, loginUser);
			dataordersDTO = ordersService.persistOrders(ordersDTO);
		} catch (Exception e) {
			LOG.error("Error while inserting Orders {}",e);
		}
		return new ResponseEntity<>(dataordersDTO, headers, HttpStatus.CREATED);
	}

	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrdersDTO>> getAllOrders() {
		List<OrdersDTO> ordersDTOResp=null;
		try {
			ordersDTOResp = ordersService.retrieveAllOrders();
		} catch (Exception e) {
			LOG.error("Error while retrieving all  Orders {}",e);
		}
		return new ResponseEntity<>(ordersDTOResp, HttpStatus.OK);
	}

	@GetMapping("/getOrdersByPatientId")
	public ResponseEntity<List<OrdersDTO>> getOrdersById(@RequestParam("patientId") Long patientId) {
		List<OrdersDTO> ordersDTOList = null;
		try {
			ordersDTOList =  ordersService.retrieveOrdersByPatientId(patientId);
		} catch (Exception e) {
			LOG.error("Error while retrieving By Orders ID {}",e);
		}
		return new ResponseEntity<>(ordersDTOList , HttpStatus.OK);
	}
	
	@GetMapping("/getOrdersByPatientIdEncId")
	public ResponseEntity<List<OrdersDTO>> getOrdersById(@RequestParam("patientId") Long patientId,@RequestParam("encounterId") Long encounterId) {
		List<OrdersDTO> ordersDTOList = null;
		try {
			ordersDTOList =  ordersService.retrieveOrdersByPatientIdEncId(patientId,encounterId);
		} catch (Exception e) {
			LOG.error("Error while retrieving By Orders ID {}",e);
		}
		return new ResponseEntity<>(ordersDTOList , HttpStatus.OK);
	}


	@PutMapping("/modifyOrders")
	public ResponseEntity<OrdersDTO> modifyOrders(@Valid @RequestBody OrdersDTO ordersDTO,
			BindingResult result){
		if(result.hasErrors()){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}

		HttpHeaders headers = new HttpHeaders();
		OrdersDTO dataordersDTO=null;
		try {
			dataordersDTO = ordersService.modifyOrders(ordersDTO);
		} catch (Exception e) {
			LOG.error("Error while inserting  Data {}",e);
		}
		return new ResponseEntity<>(dataordersDTO, headers, HttpStatus.CREATED);
	}


	@DeleteMapping("/removeOrdersById")
	public ResponseEntity<Void> removeOrdersById(@Valid @RequestParam("orderId") Long orderId){
		
		OrdersDTO ordersDTO = ordersService.retrieveOrdersById(orderId);
		if(ordersDTO !=null){
			ordersService.deleteById( orderId);
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}

		else{
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
		}

	}

}









