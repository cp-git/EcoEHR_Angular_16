package com.cpa.ehr.web.rest.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffMemberService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffFeedBackDTO;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.admin.dto.StaffPaymentDetailsDTO;
import com.cpa.ehr.util.FormatConverterUtils;


/**
 * REST Interface to access Staff Member 
 * information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class StaffMemberWebService {

	private static final Logger LOG = LoggerFactory.getLogger(StaffMemberWebService.class);

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private StaffMemberService staffMemberService;

	
	@Autowired
	private StaffRolesService staffRolesService;
	
	@PostMapping("/createStaffMember")
	public ResponseEntity<StaffMemberDTO> insertStaffMember(@Valid @RequestBody StaffMemberDTO staffMemberDTO,BindingResult result,HttpServletRequest request) {
		System.out.println("Entered in insertStaffMember ");
		
		ResponseEntity<StaffMemberDTO> entity = this.validateStaffMember(staffMemberDTO,result);
		
		if(entity.getStatusCode().value() == 200) {
			System.out.println("Entered IN if(entity.getStatusCode().value() == 200)");
			boolean flag,flag1 = false;
			String password=ehrBaseService.getRandomPassword();
			entity.getBody().setLoginKey(password);
			
			StaffMemberDTO staff = staffMemberService.persistStaffMember(entity.getBody());
			if(staff!=null && !staff.getDesignation().equals("TRY_ME")) {
				//System.out.println("in IFFFFFFFFFFFFFFFFFFF");
			 flag=ehrBaseService.getPasswordMailSender(entity.getBody(),request);
			}else {
				System.out.println("Entered In Else Loop ");
				
				
				flag=ehrBaseService.getUsernameMailSender(entity.getBody(), request);
				flag1=ehrBaseService.getAdminEmailSender(entity.getBody(), request);
			}
			
			if(flag)
				return new ResponseEntity<>(staff, HttpStatus.CREATED);	
			return new ResponseEntity<>(staff, HttpStatus.NOT_FOUND);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}
	
	@GetMapping("/getListOfActiveStaffMembers")
	public ResponseEntity<List <StaffMemberDTO>> getListOfActiveStaffMembers() {
		List<StaffMemberDTO> staffMemberListResp = staffMemberService.retrieveAllStaffMembers();
		return new ResponseEntity<> (staffMemberListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getAllPrimaryProvider")
	public ResponseEntity<List <StaffMemberDTO>> getAllPrimaryProvider() {
		List<StaffMemberDTO> providerList = staffMemberService.retrieveAllPrimaryProvider();
		return new ResponseEntity<> (providerList, HttpStatus.OK); 
	}
	
	@GetMapping("/getStaffMemberById")
	public ResponseEntity<StaffMemberDTO> getActiveStaffMemberById(@RequestParam("staffId") Long staffId){
		StaffMemberDTO staffMemberResp = staffMemberService.retrieveStaffMemberById(staffId);
		return new ResponseEntity<> (staffMemberResp, HttpStatus.OK); 
	}

	@PutMapping("/modifyStaffMemberById")
	public ResponseEntity<StaffMemberDTO> modifyStaffMemberById(@Valid @RequestBody StaffMemberDTO staffMemberDTO, BindingResult result,HttpServletRequest request) {
		//System.out.println("-------------------------"+staffMemberDTO.getActiveFlag());
		//System.out.println(staffMemberDTO);
		ResponseEntity<StaffMemberDTO> entity = this.validateStaffMember(staffMemberDTO,result);
		if(entity.getStatusCode().value() == 200) {
			
			StaffMemberDTO updatedPatient = staffMemberService.updateStaffMemberById(entity.getBody());
			
			System.out.println("updatedPatient.getActiveFlag()");
			if(updatedPatient!=null && updatedPatient.getActiveFlag() && updatedPatient.getDesignation().equalsIgnoreCase("TRY_ME")) {
				boolean flag = ehrBaseService.getStudentPwsMailSender(entity.getBody(),request);
			}
			return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, entity.getStatusCode());
		}
	}
	
	@PutMapping("/sendUserFeedback")
	public ResponseEntity<Void> sendUserFeedback(@RequestBody StaffFeedBackDTO staffFeedbackdto,HttpServletRequest request){
		HttpHeaders headers= new HttpHeaders();
		
		if(staffFeedbackdto != null) {
			StaffMember staff = ehrBaseService.currentUser();
			boolean flag = ehrBaseService.getFeedBackMainSender(staff, request, staffFeedbackdto);
			
			if(flag) {
				return new ResponseEntity<>(headers, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>(headers, HttpStatus.FAILED_DEPENDENCY);
	}
	
	
		

	
	public ResponseEntity<StaffMemberDTO> validateStaffMember(@Valid StaffMemberDTO staffMemberDTO, BindingResult result){
		List<StaffMemberDTO> staffDTOList = staffMemberService.retrieveAllStaffMembers();
		HttpHeaders headers= new HttpHeaders();
		for(StaffMemberDTO staff : staffDTOList) {
			if(!(staff.getStaffId().equals(staffMemberDTO.getStaffId())) && 
					((staff.getLoginId().trim().equalsIgnoreCase(staffMemberDTO.getLoginId().trim())) ||
					(staff.getEmail().trim().equalsIgnoreCase(staffMemberDTO.getEmail().trim()))) ) {
				return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
			}
		}
		if (result.hasErrors()) {
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
		}
		
		if(!staffMemberDTO.getDesignation().equalsIgnoreCase("TRY_ME")) {
			StaffMember loginUser = ehrBaseService.currentUser();
			FormatConverterUtils.setInitialDefaultValues(staffMemberDTO, loginUser);
		}else {
			FormatConverterUtils.setInitialStudDefaultValues(staffMemberDTO);
		}
		
		return new ResponseEntity<>(staffMemberDTO, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/removeStaffMemberById")
	public ResponseEntity<Void> removeStaffMemberById(@RequestParam("staffId") Long staffId)  {
		if(staffMemberService.checkStaffMemberInUse(staffId)) {
			Long staffMemberId= staffMemberService.removeStaffMemberById(staffId);
			staffRolesService.removeStaffRolesById(staffMemberId);
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}
		else {
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
		}
	}
	
}
