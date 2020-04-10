package com.revature.service;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.revature.model.Email;

@Service
public class EmailService {
	
	Email e = new Email();
	public void sendEmail(String email) {
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", e.getPORT());
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(e.getFROM(),e.getFROMNAME()));
		msg.setRecipient(e.RecipientType.TO, new InternetAddress(recieverEmail));
		msg.setSubject(e.getSUBJECT());
		msg.setContent(e.getBODY(), "text/html");
		Transport transport = session.getTransport();
		
		System.out.println("Sending...");
		transport.connect(e.getHOST(), e.getSMTP_USERNAME(), e.getSMTP_PASSWORD());
		transport.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Email sent!");
	}

}
