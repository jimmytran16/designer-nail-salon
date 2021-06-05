package com.web.designernails.Domain;

/* Token class for storing data that we get from the Confirmation API */
public class Token {

	public Token(){}
	
	private String success;
	private String accessToken;
	
	public String getSuccess() { return this.success; }
	public String getAccessToken() { return this.accessToken; }  
}