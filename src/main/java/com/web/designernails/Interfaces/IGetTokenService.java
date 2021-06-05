package com.web.designernails.Interfaces;
import com.web.designernails.Domain.Token;
 
public interface IGetTokenService {
	
	Token requestForToken(String apiKey);
	
}
