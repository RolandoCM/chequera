/**
 * 
 */
package com.gfi.chequera.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.gfi.chequera.model.MailModel;
import com.gfi.chequera.service.ISendMailService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 08/04/2018
 */
@Service("SendMailService")
public class SendMailService implements ISendMailService{

	@Autowired
	private JavaMailSender emailSender;
	
	@Override
	public boolean sendMailMessage(MailModel mail, String path, String nameFile) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getContent());
		helper.setTo(mail.getTo());
		helper.setFrom(mail.getFrom());
		
		helper.addAttachment(nameFile, new ClassPathResource(path));
		emailSender.send(message);
		return false;
	} 
	@Override
	public boolean sendMailMessage(MailModel mail) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getContent());
		helper.setTo(mail.getTo());
		helper.setFrom(mail.getFrom());
		
		//helper.addAttachment(nameFile, new ClassPathResource(path));
		emailSender.send(message);
		return false;
	} 
}
