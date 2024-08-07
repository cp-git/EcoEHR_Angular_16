package com.cpa.ehr.service.admin.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.StaffPaymentDetailsRepository;
import com.cpa.ehr.backend.dao.admin.entities.Mail;
import com.cpa.ehr.backend.dao.admin.entities.PasswordResetToken;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.config.ApplicationProperties;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffMemberService;
import com.cpa.ehr.service.admin.dto.StaffFeedBackDTO;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.home.PasswordResetService;
import com.cpa.ehr.service.system.dto.RequestForDemoDTO;

import java.util.Optional;
import java.util.Random;

/**
 * Implementation for the EHR Base Service
 * 
 * EHR Base Service holds all the interfaces that are reused across the EHR
 * application
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Service
public class EHRBaseServiceImpl implements EHRBaseService {

	@Autowired
	private StaffMemberService staffService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private PasswordResetService passwordResetService;

	@Autowired
	private StaffMemberRepository staffMemberRepo;

	@Autowired
	private StaffPaymentDetailsRepository staffPaymentRepo;

	@Autowired
	private ApplicationProperties appProperties;
	

	 public void ConfigConfiguration(ApplicationProperties appProperties) {
	        this.appProperties = appProperties;
	    }
	
    
    
    
	public StaffMember currentUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final Optional<StaffMember> currentUser = staffMemberRepo.findByLoginId(authentication.getName());
		return currentUser.orElse(null);
	}

	@Override
	public StaffPaymentDetails getPaymentStatus() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final StaffMember currentUser = staffMemberRepo.getByLoginId(authentication.getName());
		final Optional<StaffPaymentDetails> status = staffPaymentRepo.getStaffPaymentStatus(currentUser.getStaffId());
		return status.orElse(null);
	}

	public boolean getPasswordMailSender(StaffMemberDTO staff, HttpServletRequest request) {
		if (staff.getLoginKey() != null) {
			Mail mail = new Mail();
			mail.setFrom(appProperties.getConfig().getMail().getFrom());

			String[] to = new String[20];
			to[0] = staff.getEmail();
			mail.setTo(to);

			mail.setSubject("Account Registration Successful");
			Map<String, Object> model = new HashMap<>();
			model.put("pwd", staff.getLoginKey());
			model.put("user", staff);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			String url = "https://54.162.55.186:8443/ehr/#/";
			model.put("url", url);
			mail.setModel(model);
			emailService.sendPasswordEmail(mail);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean getStudentPwsMailSender(StaffMemberDTO staff, HttpServletRequest request) {
		if (staff.getLoginKey() != null) {
			Mail mail = new Mail();
			mail.setFrom(appProperties.getConfig().getMail().getFrom());

			String[] to = new String[20];
			to[0] = staff.getEmail();
			mail.setTo(to);

			mail.setSubject("EHR Account Activated Successfully");
			Map<String, Object> model = new HashMap<>();
			model.put("pwd", staff.getLoginKey());
			model.put("user", staff);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			String url = "https://54.162.55.186:8443/ehr/#/login";
			model.put("url", url);
			mail.setModel(model);
			emailService.sendActivationEmail(mail);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean getFeedBackMainSender(StaffMember staff, HttpServletRequest request,
			StaffFeedBackDTO staffFeedback) {
		if (staff.getLoginKey() != null) {
			Mail mail = new Mail();
			mail.setFrom(appProperties.getConfig().getMail().getFrom());

			mail.setTo(appProperties.getConfig().getMail().getTo());

			mail.setSubject("Student Feedback");
			Map<String, Object> model = new HashMap<>();
			// model.put("pwd", staff.getLoginKey());
			model.put("feedBack", staffFeedback);
			model.put("user", staff);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			String url = "https://54.162.55.186:8443/ehr/#/login";
			model.put("url", url);
			mail.setModel(model);
			emailService.sendFeedBackEmail(mail);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean getUsernameMailSender(StaffMemberDTO staff, HttpServletRequest request) {
		if (staff.getLoginKey() != null) {
			Mail mail = new Mail();
			mail.setFrom(appProperties.getConfig().getMail().getFrom());

			String[] to = new String[20];
			to[0] = staff.getEmail();
			mail.setTo(to);

			mail.setSubject("Account Registration Successful");
			Map<String, Object> model = new HashMap<>();
			model.put("UserName", staff.getLoginId());
			model.put("user", staff);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			String url = "https://54.162.55.186:8443/ehr/#/login"; 
			model.put("url", url);
			mail.setModel(model);
			emailService.sendUsernameEmail(mail);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean getAdminEmailSender(StaffMemberDTO staff, HttpServletRequest request) {

		if (staff.getLoginKey() != null) {
			Mail mail = new Mail();
			mail.setFrom(appProperties.getConfig().getMail().getFrom());
//			mail.setTo(new String[] { appProperties.getConfig().getMail().getTo()[0],appProperties.getConfig().getMail().getTo()[2],appProperties.getConfig().getMail().getTo()[3]});
			mail.setTo(new String[] { appProperties.getConfig().getMail().getTo()[0]});

			mail.setSubject("Account Pending For Activation");
			Map<String, Object> model = new HashMap<>();
			model.put("UserName", staff.getFirstName() + " " + staff.getLastName());
			model.put("user", staff);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			String url = "https://54.162.55.186:8443/ehr/#/login";
			model.put("url", url);
			mail.setModel(model);
			emailService.sendActivationPendingEmail(mail);
			return true;
		} else {
			return false;
		}
	}

	public boolean getResetPasswordMailSender(StaffMember staff, HttpServletRequest request) {
		StaffMember userName = staffService.findByEmail(staff.getEmail());

		PasswordResetToken token = passwordResetService.createToken(userName);
		if (token != null) {
			Mail mail = new Mail();
//			System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
//			System.out.println(appProperties.getConfig().getMail().getFrom());
			mail.setFrom(appProperties.getConfig().getMail().getFrom());

			String[] to = new String[20];
			to[0] = staff.getEmail();
			mail.setTo(to);

			mail.setSubject("Password reset request");
			Map<String, Object> model = new HashMap<>();
			model.put("token", token);
			model.put("user", userName);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
//			String url = "http://" + request.getServerName() + appProperties.getConfig().getUrl();
			String url = "https://54.162.55.186:8443/ehr/#/"; 

			model.put("resetUrl", url + "reset?token=" + token.getToken());
			mail.setModel(model);
//			System.out.println(mail);
			emailService.sendEmail(mail);
			return true;
		} else {
			return false;
		}
	}

	public String getRandomPassword() {
		int length = 10;
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";
		String values = Capital_chars + Small_chars + numbers + symbols;
		Random rndm_method = new Random();
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}

		return password.toString();
	}

	@Override
	public boolean getAdminSubscriptionMailSender(StaffMember staff, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getSubscriptionActivationMailSender(StaffMember staff, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRequestForDemoMailSender(RequestForDemoDTO demo, HttpServletRequest request) {
		if (demo.getEmail() != null) {
			Mail mail = new Mail();
			mail.setFrom(appProperties.getConfig().getMail().getFrom());
			mail.setTo(new String[] { appProperties.getConfig().getMail().getTo()[0],appProperties.getConfig().getMail().getTo()[3]});

			mail.setSubject("Demo Request");
			Map<String, Object> model = new HashMap<>();
			model.put("UserName", demo.getFname() + " " + demo.getLname());
			model.put("user", demo);
//			String url = request.getScheme() + "://" + request.getServerName() + appProperties.getConfig().getUrl();
			String url = "https://54.162.55.186:8443/ehr/#/";
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			model.put("url", url);
			mail.setModel(model);
			emailService.sendRequestDemoEmail(mail);
			return true;
		} else {
			return false;
		}
	}

}
