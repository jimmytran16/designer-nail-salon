package com.web.designernails.Domain;

public class Email {
	public String name;
    public String phone;
    public String date;
    public String email;
    public String message;
    public String appointment;
    public String confirmationUrl;

    public Email (String name, String phone, String date, String email, String message, String appointment) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.email = email;
        this.message = message;
        this.appointment = appointment;
    }
    
    public void setConfirmationUrl(String url) {
    	this.confirmationUrl = url;
    }
}
