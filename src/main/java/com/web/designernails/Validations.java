package com.web.designernails;

public class Validations {
	public Validations() {}
	
	 // check if the email is empty, then return back "empty" string
    public String validateTheEmail(String email) {
    	return email.isEmpty() ? "N/A" : email;
    }
    
    // take away all non numerical characters within the phoneNumber string and return the refined phone number string
    public String validateThePhoneNumber(String phoneNumber) {
    	String phoneNumberRefined = phoneNumber.replaceAll("[^0-9]", "");
    	return phoneNumberRefined;
    }
}
