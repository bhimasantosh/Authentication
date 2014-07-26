package com.sbhima.auth.commons;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	public void mailMessage(String from, String to, String subject,
			String message) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName("localhost");
		email.setAuthentication("Administrator", "hsotnas");
		email.setFrom(from);
		email.addTo(to);
		email.setSubject(subject);
		email.setMsg(message);
		email.send();
	}

	public static void main(String[] args) throws EmailException {
		EmailSender emailSender = new EmailSender();
		emailSender.mailMessage("santosh.bhima@gmail.com",
				"santosh.bhima@gmail.com", "hi", "hello");
	}
}
