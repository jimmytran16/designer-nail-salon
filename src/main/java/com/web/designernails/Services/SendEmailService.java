package com.web.designernails.Services;
import com.web.designernails.Interfaces.ISendEmailService;
import com.web.designernails.Domain.Email;
import com.web.designernails.Domain.Token;
import javax.servlet.http.HttpServletRequest;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/*
 * Implementation class of SendEmailService
 * */ 
public class SendEmailService implements ISendEmailService {
    
    private TokenService _tokenService = new TokenService();
    private ConfirmationService _confirmationService = new ConfirmationService();

    /* Get the api key and the api key endpoint from the environment */
    private final String apiKey = System.getenv("API_KEY");
    private final String apiURL = System.getenv("API_URL");
        /*
     * function to send out the email
     * @params email - the email instance that contains all of the email information 
    */
    @Override
    public void sendOutAppointmentInfoToEmail(Email email) throws Exception {

       try {
            // get the token from the confirmation api server
            // retrieve the token from the Token instance
            Token token = _tokenService.requestForToken(apiKey);
            final String confirmationToken = (token == null) ? "error getting token" : token.getAccessToken();
            
            // final String apiURL = "http://127.0.0.1:5000/sendConfirmation";
            final String contactMessage = "%0A%0APlease%20Contact%20(339)-221-5234%20if%20you%20have%20any%20questions%20or%20would%20like%20to%20cancel%20your%20appointment!%20See%20you%20soon!%20";
            final String messageParam = "Hi%20"+email.name.split(" ")[0]+",%20this%20is%20Designer%20Nail%20Salon%20confirming%20your%20appointment%20for%20" +email.date+ "%20at%20" + email.appointment + contactMessage; 
            final String confirmationUrl = apiURL +"?key="+confirmationToken+"&number="+email.phone+"&message=" + messageParam;
            final String messageBody = "Name: " + email.name + "\nPhone Number: " + email.phone + "\nEmail: " + email.email + "\nTime: " +
            email.appointment + "\nMessage: " + email.message + "\nCONFIRM LINK: " + confirmationUrl;
            
            // Set the confirmation url
            email.setConfirmationUrl(confirmationUrl);
            
            // Call the confirmation service to send out the email to the admin
            _confirmationService.sendEmail(email);
       }catch (Exception e) {
           throw new Exception(e);
       }
     }

    /*
     * check if the email is empty, then return back "empty" string
     * @params email - the recipeints email address 
    */
    @Override
    public String validateTheEmail(String email) {
    	return email.isEmpty() ? "N/A" : email;
    }
     /*
     * take away all non numerical characters within the phoneNumber string and return the refined phone number string
     * @params phoneNumber - the recipeints phone number 
    */
    @Override
    public String validateThePhoneNumber(String phoneNumber) {
    	String phoneNumberRefined = phoneNumber.replaceAll("[^0-9]", "");
    	return phoneNumberRefined;
    }
}

