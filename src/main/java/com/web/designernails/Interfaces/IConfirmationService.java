package com.web.designernails.Interfaces;
import com.web.designernails.Domain.Email;
import com.web.designernails.Domain.Token;
 
public interface IConfirmationService {
	void sendEmail(Email email);
}
