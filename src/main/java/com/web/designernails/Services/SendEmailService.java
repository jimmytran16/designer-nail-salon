package com.web.designernails.Services;
import com.web.designernails.Interfaces.ISendEmailService;
import com.web.designernails.TokenService;
import com.web.designernails.Domain.Email;
import com.web.designernails.Domain.Token;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    
    private HttpSession sess;
    private TokenService _tokenService = new TokenService();

    /* Get the enviroment variables of the sender's email and password from host server, get recipeint's email */
    private final String username = System.getenv("SENDER_USER");
    private final String password = System.getenv("SENDER_PASS");
    private final String recipient = System.getenv("RECIPIENT_USER");

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
            /* Get the session instance and set properties */
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            /** 
             * This method is used to authenticate the sender's email address 
             * @param props This is the first parameter that passes in the java mail server configurations 
             * @param new javax.mail.Authenticator()  This is the second parameter that passes in the instance of the java authenticator for the username and password
             * @return the PasswordAuthentication session instance to the session if it is successful
             */

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // create a message using the MimMessage instance
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); /* Set the recipient username into the message form */
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setHeader("Content-Type", "text/html");
            Multipart multipart = new MimeMultipart();
            
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
            
            // set text and add body part
            textPart.setText(messageBody);
            multipart.addBodyPart(textPart);

            // set the subject, content fields, and then save it before sending
            message.setSubject("Appointment Date: " + email.date);
            message.setContent(multipart, "text/html");
            message.saveChanges();

            // Send out the email 
            Transport.send(message);

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

