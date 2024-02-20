package com.web.designernails.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.designernails.Domain.Email;
import com.web.designernails.Interfaces.ISendEmailService;
import com.web.designernails.Util.Conversions;
import com.web.designernails.Services.SendEmailService;

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
    private ISendEmailService _sendEmailService = new SendEmailService();
    HttpSession sess;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Call the doPost method and pass in the request and response */
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Get the request session */
    	sess = request.getSession();

    	/* Extract the inputs from the request object passed from client */        
        fname = request.getParameter("fname");
        phone = request.getParameter("lname");
        date = request.getParameter("date");
        email = request.getParameter("email");
        msg = request.getParameter("note"); 
        appt = Conversions.convertMilitaryToStandardTime(String.valueOf(request.getParameter("appt")));
        
        /* validate the email and phone */
        email = _sendEmailService.validateTheEmail(email);
        phone = _sendEmailService.validateThePhoneNumber(phone);

        /* create an email instane to pass into the send email service service */
        Email emailInstance = new Email(fname,phone,date,email,msg,appt);
        try {
            _sendEmailService.sendOutAppointmentInfoToEmail(emailInstance);
            // NOTE: Currently there is an issue with Twilio, so will notify user to call salon
            // sess.setAttribute("message", "  Appointment sent succuessfully! You will get a comfirmation text/call very soon."); //success message sent to the webpage
            // sess.setAttribute("message_color", "#c7b216");
            sess.setAttribute("message", "  Sorry, our website is currently under maintenance, Please contact (781)-475-8079 to schedule for an appointment!");
            sess.setAttribute("message_color", "red");
            response.sendRedirect("booking.jsp");
        } catch (Exception e) {
            sess.setAttribute("message_color", "red");
            sess.setAttribute("message", "  Sorry, our website is currently under maintenance, Please contact (781)-475-8079 to schedule for an appointment!");
            System.out.println("Error " + e);
            response.sendRedirect("booking.jsp");
        }

    }
    
}