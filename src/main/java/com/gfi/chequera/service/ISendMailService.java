/**
 * 
 */
package com.gfi.chequera.service;

import javax.mail.MessagingException;

import com.gfi.chequera.model.MailModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 08/04/2018
 */
public interface ISendMailService {
	public boolean sendMailMessage(MailModel mail, String path, String nameFile)throws MessagingException;
	public boolean sendMailMessage(MailModel mail)throws MessagingException;
}
