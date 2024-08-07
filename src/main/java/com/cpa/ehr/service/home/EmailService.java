package com.cpa.ehr.service.home;

import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.entities.Mail;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.config.ApplicationProperties;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class EmailService {

	private final Logger log = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Autowired
	private StaffMemberRepository staffRepo;
	
	@Autowired
	private ApplicationProperties appProperties;
	
	 public void ConfigConfiguration(ApplicationProperties appProperties) {
	        this.appProperties = appProperties;
	    }
	

	public void sendEmail(Mail mail) {
		
		try {
//			System.out.println("*********************************");
//			System.out.println(mail.getTo().toString()+"   "+
//					mail.getFrom()+ "   "
//					+mail.getSubject()+ "   "+
//					mail.getModel());
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
//			System.out.println("helper");
//			System.out.println(helper);
		
			Context context = new Context();
			context.setVariables(mail.getModel());
//			System.out.println("context");
//			System.out.println(context);
			String html = templateEngine.process("email/email-template", context);
//			System.out.println(mail.getTo());
			helper.setTo(mail.getTo()[0]);
//            System.out.println(mail.getTo());
			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());
//			System.out.println("*********************************8");
//			System.out.println(mail.getTo()+"   "+
//					mail.getFrom()+ "   "
//					+mail.getFrom());
			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendPasswordEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email/password-email-template", context);

			helper.setTo(mail.getTo()[0]);

			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());

			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendActivationEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email/account-activation-email-template", context);

			helper.setTo(mail.getTo()[0]);

			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());

			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendUsernameEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email/username-email-template", context);
			helper.setTo(mail.getTo()[0]);

			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());

			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendActivationPendingEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email/admin-approval-email-template", context);

			helper.setTo(mail.getTo());

			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());

			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void sendRequestDemoEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email/request-for-demo", context);

			helper.setTo(mail.getTo());

			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());

			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendFeedBackEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email/feedback-email-template", context);

			helper.setTo(mail.getTo());

			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());

			emailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		t.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	@Async
	public void sendExceptionEmail(String content, String username) {
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = emailSender.createMimeMessage();

		try {
			Optional<StaffMember> member = staffRepo.findByLoginId(username);
			String subject;
			if (member.isPresent()) {
				subject = "Exception in EchoEHR By" + " " + member.get().getLoginId() + " " + "in" + " "
						+ member.get().getOrganization().getOrganizationName();
			} else {
				subject = "Exception in EchoEHR Track Username Not Specified";
			}
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
			message.setTo(new String[] {appProperties.getConfig().getMail().getTo()[0],appProperties.getConfig().getMail().getTo()[1]});
			message.setFrom(appProperties.getConfig().getMail().getFrom());
			message.setSubject(subject);
			message.setText(content.toString());
			emailSender.send(mimeMessage);
			log.debug("Sent email to User '{}'", "ehrlite@gmail.com");
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.warn("Email could not be sent to user '{}'", " ehrlite@gmail.com", e);
			} else {
				log.warn("Email could not be sent to user '{}': {}", "ehrlite@gmail.com", e.getMessage());
			}
		}
	}

}
