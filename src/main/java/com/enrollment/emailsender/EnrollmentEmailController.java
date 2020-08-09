package com.enrollment.emailsender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EnrollmentEmailController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping(value="/send-mail", method = RequestMethod.POST)
	public Notification sendMail(@RequestBody Email email) {
		Notification response = new Notification();
		try {
			smtpMailSender.send(email.getSendTo(), email.getSubject(), email.getBody());
		} catch (MessagingException e) {
			e.printStackTrace();
			response.setMessage(e.getLocalizedMessage());
			return response;
		}
		response.setMessage("email sent succesfull!");
		return response;
	}
	
	@RequestMapping(value="/send-mail-with-files", method = RequestMethod.POST)
	public Notification sendMailWithFiles(@RequestParam("Attachments") MultipartFile[] files, 
			@RequestParam("sendTo") String sendTo,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body) {
		
		Notification response = new Notification();
		try {
			smtpMailSender.send(sendTo, subject, body, files);
		} catch (MessagingException e) {
			e.printStackTrace();
			response.setMessage(e.getLocalizedMessage());
			return response;
		}
		response.setMessage("email sent succesfull!");
		return response;
	}

}
