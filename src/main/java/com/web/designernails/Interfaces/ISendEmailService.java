package com.web.designernails.Interfaces;

import javax.servlet.http.HttpServletRequest;
import com.web.designernails.Domain.Email;

/* 
 * This interface will define the methods used to send out the appointment forms to the email
 * */
public interface ISendEmailService {
	
	void sendOutAppointmentInfoToEmail(Email email) throws Exception;

	String validateThePhoneNumber(String phoneNumber);

	String validateTheEmail(String email);

}
