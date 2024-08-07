package com.cpa.ehr.web.rest.home;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.PasswordResetToken;
import com.cpa.ehr.backend.dao.admin.entities.Reset;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffMemberService;
import com.cpa.ehr.service.home.PasswordResetService;

import javax.servlet.http.HttpServletRequest;
/**
 * REST Interface to access Patient's Clinic 
 * Locations information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/home/auth")
@CrossOrigin(origins = {"http://localhost:4300"})
public class ForgotPasswordWebService {

	@Autowired 
	private PasswordResetService passwordResetService;
	
	@Autowired 
	private StaffMemberService staffService;

	@Autowired
	private EHRBaseService ehrBaseService;


	/**
	 * Sends Password recovery email for the requested staff
	 * 
	 * @param staff
	 * 		Identifier of StaffMember
	 * 
	 * @param request
	 * 		Identifier of HttpServletRequest
	 * 
	 * @return Nothing
	 */
	@PostMapping("/recover")
	public ResponseEntity<Void> forgotPassword(@RequestBody StaffMember staff, HttpServletRequest request) {
		
		if(ehrBaseService.getResetPasswordMailSender(staff,request)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Checks whether the incoming reset token is valid
	 * 
	 * @param token
	 * 		Identifier of Reset Token
	 * 
	 * @param request
	 * 		Identifier of HttpServletRequest
	 * 
	 * @return Nothing
	 */
	@PostMapping("/checktoken")
	public ResponseEntity<String>  checkToken(@RequestBody String token, HttpServletRequest request) {
		try {

			PasswordResetToken resetToken = passwordResetService.findToken(token);

			if (resetToken == null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else if(resetToken.isExpired()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}

			return new ResponseEntity<>(token, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Updates the password for the staff
	 * 
	 * @param reset
	 * 		Identifier of Reset
	 * 
	 * @param request
	 * 		Identifier of HttpServletRequest
	 * 
	 * @return Nothing
	 */
	@PostMapping("/reset")
	public ResponseEntity<PasswordResetToken>  resetPassword(@RequestBody Reset reset, HttpServletRequest request) {
		try {
			if(reset.getPassword()==null)
			{
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

			}

			PasswordResetToken resetToken = passwordResetService.findToken(reset.getToken());
			if(resetToken.getStaffMember()!=null)
			{
				StaffMember staffMember = resetToken.getStaffMember();
				staffService.updatePassword(reset.getPassword(), staffMember.getStaffId());
				passwordResetService.deleteToken(resetToken);
				return new ResponseEntity<>(resetToken, HttpStatus.CREATED);
			}
			else 
			{
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
