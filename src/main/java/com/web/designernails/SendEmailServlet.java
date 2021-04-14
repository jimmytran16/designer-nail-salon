package com.web.designernails;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.web.designernails.Token;
import com.web.designernails.TokenService;

/** 
 * Servlet class to carry out the email from sender to recipient
 * 
 * @author  Jimmy Tran 
 * @since   2019-12-23 
 */

public class SendEmailServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String fname;
    private String phone;
    private String date;
    private String email;
    private String msg;
    private String appt;
    HttpSession sess;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Call the doPost method and pass in the request and response */
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Extract the inputs from the request object passed from client */
        fname = request.getParameter("fname");
        phone = request.getParameter("lname");
        date = request.getParameter("date");
        email = request.getParameter("email");
        msg = request.getParameter("note");
        appt = convertMilitaryToStandardTime(String.valueOf(request.getParameter("appt")));
        
        /* validate the email */
        email = validateTheEmail(email);
        
        
        /* Get the session instance and set properties */
        sess = request.getSession();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        /* Get the enviroment variables of the sender's email and password from host server, get recipeint's email */
        final String username = System.getenv("SENDER_USER");
        final String password = System.getenv("SENDER_PASS");
        final String recipient = System.getenv("RECIPIENT_USER");
        
               
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

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); /* Set the recipient username into the message form */
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setHeader("Content-Type", "text/html");
            Multipart multipart = new MimeMultipart();
            
            Token token = TokenService.requestForToken();
            System.out.println(token);
            final String authKey = System.getenv("API_KEY");
            final String confirmationToken = (token == null) ? "error getting token" : token.getAccessToken();
            final String apiURL= System.getenv("API_URL");
//            final String apiURL = "http://127.0.0.1:5000/sendConfirmation";
           
            final String contactMessage = "%0A%0APlease%20Contact%20(339)-221-5234%20if%20you%20have%20any%20questions%20or%20would%20like%20to%20cancel%20your%20appointment!%20See%20you%20soon!%20";
            final String messageParam = "Hi%20"+fname.split(" ")[0]+",%20this%20is%20Designer%20Nail%20Salon%20confirming%20your%20appointment%20for%20" +date+ "%20at%20" + appt + contactMessage; 
            final String confirmationUrl = apiURL +"?key="+confirmationToken+"&number="+phone+"&message=" + messageParam;
            final String messageBody = "Name: " + fname + "\nPhone Number: " + phone + "\nEmail: " + email + "\nTime: " +
                appt + "\nMessage: " + msg + "\nCONFIRM LINK: " + confirmationUrl;
            
            textPart.setText(messageBody);
            multipart.addBodyPart(textPart);

            message.setSubject("Appointment Date: " + date);
            message.setContent(multipart, "text/html");
            message.saveChanges();

            //Send email 
            Transport.send(message);
            System.out.println("Success! - port 587");
            sess.setAttribute("message", "  Appointment sent succuessfully! You will get a comfirmation text/call very soon."); //success message sent to the webpage
            sess.setAttribute("message_color", "#c7b216");
            response.sendRedirect("booking.jsp");
        } catch (Exception e) {
            sess.setAttribute("message_color", "red");
            sess.setAttribute("message", "  Sorry, our website is currently under maintenance, Please contact (339)-221-5234 to schedule for an appointment!");
            System.out.println("Error " + e);
            response.sendRedirect("booking.jsp");
        }

    }
    
    // check if the email is empty, then return back "empty" string
    private String validateTheEmail(String email) {
    	return email.isEmpty() ? "N/A" : email;
    }
    
    // function to convert Military time to Standard time
    private String convertMilitaryToStandardTime(String time) {
    	
    	try {
    		// get the hour of the time
            String splitTime[] = time.split(":");
            int HOUR = Integer.valueOf(splitTime[0]);

            // check if the time is in military, if greater than 12, then it is a mil time
            // give it the right standard time
            if (HOUR > 12) {
                String refineHour;
                switch (HOUR) {
                    case 13:
                        refineHour = "1";
                        break;
                    case 14:
                        refineHour = "2";
                        break;
                    case 15:
                        refineHour = "3";
                        break;
                    case 16:
                        refineHour = "4";
                        break;
                    case 17:
                        refineHour = "5";
                        break;
                    case 18:
                        refineHour = "6";
                        break;
                    case 19:
                        refineHour = "7";
                        break;
                    default:
                        refineHour = String.valueOf(HOUR);
                        break;
                }
                return new String(refineHour + ":" + splitTime[1] + "PM"); // return the standard time
            }
            return time  + ((HOUR==12) ? "PM" : "AM"); // return the time if the time is not military
    	}catch(Exception e) {
    		return "" + e;
    	}
    	
    }


}