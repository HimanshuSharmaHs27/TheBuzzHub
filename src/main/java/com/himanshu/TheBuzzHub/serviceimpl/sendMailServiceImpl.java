package com.himanshu.TheBuzzHub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.himanshu.TheBuzzHub.dto.MailData;
import com.himanshu.TheBuzzHub.service.GmailService;

@Service
public class sendMailServiceImpl implements GmailService {

	@Autowired
	JavaMailSender mail;

	@Override
	public String sendMail(MailData maildata) {
		int a = 10;
		try {
			for (int b = 10; b <= a; b++) {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(maildata.getTo());
				message.setSubject(maildata.getSubject());
				message.setText(maildata.getBody());
				mail.send(message);
			}

		} catch (Exception e) {
			return e.getMessage();
		}
		return "Mail Send Sucessfully";
	}

}
