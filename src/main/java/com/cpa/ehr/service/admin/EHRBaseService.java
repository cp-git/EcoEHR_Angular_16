package com.cpa.ehr.service.admin;

import javax.servlet.http.HttpServletRequest;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.service.admin.dto.StaffFeedBackDTO;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.system.dto.RequestForDemoDTO;

/**
 * Implementation for the EHR Base Service
 * 
 * EHR Base Service holds all the interfaces
 * that are reused across the EHR application 
 *  
 * @author CPA Development Team
 * @version 1.0.0
 */
public interface EHRBaseService {

	public StaffMember currentUser();
	public StaffPaymentDetails getPaymentStatus();
	public String getRandomPassword();
	public boolean getResetPasswordMailSender(StaffMember staff,HttpServletRequest request);
	public boolean getPasswordMailSender(StaffMemberDTO staff,HttpServletRequest request);
	public boolean getStudentPwsMailSender(StaffMemberDTO staff,HttpServletRequest request);
	public boolean getUsernameMailSender(StaffMemberDTO staff,HttpServletRequest request);
	public boolean getAdminEmailSender(StaffMemberDTO staff, HttpServletRequest request);
	
	public boolean getSubscriptionActivationMailSender(StaffMember staff,HttpServletRequest request);
	public boolean getAdminSubscriptionMailSender(StaffMember staff,HttpServletRequest request);
	
	public boolean getFeedBackMainSender(StaffMember staff,HttpServletRequest request,StaffFeedBackDTO staffFeedback);
	
	public boolean getRequestForDemoMailSender(RequestForDemoDTO demo, HttpServletRequest request);
}
