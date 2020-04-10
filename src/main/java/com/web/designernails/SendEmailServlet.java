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

public class SendEmailServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname,phone,date,email,treatment,msg;
	HttpSession sess;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//call doPost method if form method is 'get'
		doPost(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		fname = request.getParameter("fname");
		phone = request.getParameter("lname");
		date = request.getParameter("date");
		email = request.getParameter("email");
		treatment = request.getParameter("treatment");
		msg = request.getParameter("note");
		//get session
		sess = request.getSession();
		Properties props = new Properties(); 		
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", "smtp.gmail.com");		        
		props.put("mail.smtp.port", "587");   
		final String username= System.getenv("SENDER_USER"); //get system enviroment variables
		final String password = System.getenv("SENDER_PASS");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username,password);
			}			
				});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			//send from
			final String recipient = System.getenv("RECIPIENT_USER");
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipient));
			MimeBodyPart textPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			String final_Text ="Name: "+fname+"\nPhone Number: "+phone+"\nEmail: "+email+"\nTreatment:"
				+treatment+"\nMessage: "+msg;
			textPart.setText(final_Text);
			message.setSubject("Customer Message: ");
			multipart.addBodyPart(textPart);
			message.setContent(multipart);
			message.setSubject("Appointment Date: "+date);
		
			//Send email 
			Transport.send(message);
			System.out.println("Success! - port 587");
			sess.setAttribute("message","  Message sent succuessfully!"); //success message sent to the webpage
			sess.setAttribute("message_color","#c7b216");
			response.sendRedirect("booking.jsp");
			}catch(Exception e) {
				sess.setAttribute("message_color","red");
				sess.setAttribute("message","  Sorry, our website is currently under maintenance, Please contact (339)-221-5234 to schedule for an appointment!");
				System.out.println("Error "+e);
				response.sendRedirect("booking.jsp");
			}
			
	}

	
}