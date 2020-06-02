package com.pfe.Controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.Model.Email;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class SimpleEmailController {
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@PostMapping(value = "/sendEmailOne")
	@PreAuthorize("hasRole('ADMIN')")
	public String sendEmail(@RequestBody Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getMessageSubject());
		message.setText(email.getMessageBody());
		javaMailSender.send(message);
		return "envoyé avec succ!!";
	}
	
	@PostMapping(value = "/sendEmailAttechment")
	@PreAuthorize("hasRole('ADMIN')")
	public String sendEmailAttachement(@RequestBody Email email) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(email.getTo());
		helper.setSubject("You password and Login");
		helper.setText(email.getMessageBody());
		
		/*
		 * //ken t7eb tzid contenu fichier ou image f email tzid hethi
		 * //helper.addAttachment(attachmentFilename, dataSource);
		 */		
		javaMailSender.send(message);
		
		return "succee email!!";
		
	}
}
