package com.mahesh.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
@SuppressWarnings("deprecation")
public class MailUtil {
	
	public static void sendSimpleMail() throws Exception {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);
		// email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(MailConstants.MAIL_ID, MailConstants.PASSWORD));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setFrom(MailConstants.MAIL_ID);
		email.setSubject("Hi");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("mahesh11317@gmail.com");
		email.setTLS(true);
		email.send();
		System.out.println("Mail sent!");
	}


	public static void sendHtmlMail(String subject, String content) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setSmtpPort(587);
			// email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(MailConstants.MAIL_ID, MailConstants.PASSWORD));
			email.setDebug(false);
			email.setHostName("smtp.gmail.com");
			email.setFrom(MailConstants.MAIL_ID);
			email.setSubject(subject);
			email.setHtmlMsg(content);
			email.addTo("mahesh11317@gmail.com");// ,
												// "janani@revature.com");
			email.setTLS(true);

			email.send();

			System.out.println("Mail sent!");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
