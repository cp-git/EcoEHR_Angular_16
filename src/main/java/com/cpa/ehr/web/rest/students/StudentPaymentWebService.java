package com.cpa.ehr.web.rest.students;

import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.students.constants.StripePaymentConstants;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffMemberService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.admin.dto.StaffPaymentDetailsDTO;
import com.cpa.ehr.service.students.StudentDetailsService;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.service.system.dto.RequestForDemoDTO;
import com.cpa.ehr.web.rest.admin.StaffMemberWebService;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping("/api/rest/payment")
@CrossOrigin(origins = { "http://localhost:4300" })
public class StudentPaymentWebService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentDetailsService.class);

	@Autowired
	private EHRBaseService ehrBaseService;

	@Autowired
	private StaffMemberService staffMemberService;

	@Autowired
	private StaffRolesService staffRolesService;

	@PostMapping("/create-checkout-session")
	public String createCheckoutSessionId() {
		String sessionId = "";
		sessionId = getSessionId();
		return sessionId;
	}

	@PutMapping("/modifyStaffPaymentDetails")
	public ResponseEntity<Void> modifyStaffPaymentDetails(
			@Valid @RequestBody StaffPaymentDetailsDTO staffPaymentDetailsDTO, BindingResult result,
			HttpServletRequest request) {

		HttpHeaders headers = new HttpHeaders();
		StaffMemberDTO updatedPaymentStatus = staffMemberService.updatePaymentStatus(staffPaymentDetailsDTO);
		if (updatedPaymentStatus != null) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		}

		return new ResponseEntity<>(headers, HttpStatus.NOT_MODIFIED);
	}

	//
	public String getSessionId() {
		Gson gson = new Gson();

		try {
			// This is a sample test API key. Sign in to see examples pre-filled with your
			// key.

			StripePaymentConstants stripeObj = new StripePaymentConstants();

			Stripe.apiKey = stripeObj.TEST_SECERT_KEY;

			String YOUR_DOMAIN = stripeObj.LOCAL_URL;
			String SUCCESS_URL = stripeObj.LOCAL_SUCCESS_URL;
			String FAIL_URL = stripeObj.LOCAL_FAILURE_URL;
			String PRICE_ID = stripeObj.TEST_PRICE_ID;

			/*
			 * SessionCreateParams params = SessionCreateParams.builder()
			 * .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
			 * .setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(YOUR_DOMAIN +
			 * "/#/success") .setCancelUrl(YOUR_DOMAIN + "/cancel")
			 * .addLineItem(SessionCreateParams.LineItem .builder().setQuantity( 1L)
			 * .setPriceData(SessionCreateParams.LineItem.PriceData.builder().setCurrency(
			 * "usd") .setUnitAmount(2000L)
			 * .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
			 * .setName("Student Physician Guide (Prod)").build()) .build()) .build())
			 * .build();
			 */

			SessionCreateParams params = SessionCreateParams.builder()
					.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
					.addLineItem(SessionCreateParams.LineItem.builder().setPrice(PRICE_ID).setQuantity(1L).build())
					.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(SUCCESS_URL).setCancelUrl(FAIL_URL)
					.build();

			Session session = Session.create(params);
			HashMap<String, String> responseData = new HashMap<String, String>();
			responseData.put("id", session.getId());

			return gson.toJson(responseData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/setUserLoginTime")
	public ResponseEntity<StaffMemberDTO> setUserLoginTime(@Valid @RequestBody StaffMemberDTO staffDTO,
			BindingResult result) {
		HttpHeaders headers = new HttpHeaders();
		boolean flag = staffMemberService.setUserLoginTime();
		if (flag) {
			return new ResponseEntity<StaffMemberDTO>(staffDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StaffMemberDTO>(staffDTO, HttpStatus.CONFLICT);
	}

	@PutMapping("/setUserLogoutTime")
	public ResponseEntity<Void> setUserLogoutTime(@Valid @RequestBody StaffMemberDTO staffDTO, BindingResult result) {
		// StaffMember staff = ehrBaseService.currentUser();
		// System.out.println("logggggggggggggggggeddddddddddd outtttttttt
		// callllllledd");
		// System.out.println(staffDTO.getStaffId());
		if (staffDTO.getStaffId() != null) {
			System.out.println(staffDTO.getStaffId());
			boolean flag = staffMemberService.setUserLogoutTime(staffDTO.getStaffId());

			if (flag) {
				HttpHeaders headers = new HttpHeaders();
				return new ResponseEntity<Void>(headers, HttpStatus.OK);
			}
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getUserLoginStatus")
	public ResponseEntity<StaffMemberDTO> getUserLoginStatus() {
		StaffMemberDTO staffDTO = staffMemberService.getLoginStatus();

		return new ResponseEntity<StaffMemberDTO>(staffDTO, HttpStatus.OK);
	}

	@PostMapping("/requestForDemo")
	public ResponseEntity<Boolean> demoRequest(@Valid @RequestBody RequestForDemoDTO demoDTO, BindingResult result,
			HttpServletRequest request) {

		boolean flag = ehrBaseService.getRequestForDemoMailSender(demoDTO, request);
		if (flag)
			return new ResponseEntity<>(true, HttpStatus.OK);
		else
			return new ResponseEntity<>(false, HttpStatus.METHOD_FAILURE);
	}

}
