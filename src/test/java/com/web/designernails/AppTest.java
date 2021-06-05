package com.web.designernails;

import com.web.designernails.Services.SendEmailService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase{
	
	private SendEmailService _sendEmailService = new SendEmailService();
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPhoneValidationWithCorrectResultingStringLength(){
    	String refinedPhoneNumber1 = _sendEmailService.validateThePhoneNumber("781 111 1111");
    	String refinedPhoneNumber2 = _sendEmailService.validateThePhoneNumber("781-111-1111");
    	String refinedPhoneNumber3 = _sendEmailService.validateThePhoneNumber("!@#!#@!781/111/1111");

        assertEquals(10,refinedPhoneNumber1.length());
        assertEquals(10,refinedPhoneNumber2.length());
        assertEquals(10,refinedPhoneNumber3.length());
    }
    
    public void testEmailValidation() {
    	String email1 = _sendEmailService.validateTheEmail("");
    	String email2 = _sendEmailService.validateTheEmail("j@gmail.com");
    	
    	assertEquals("N/A",email1);
    	assertEquals("j@gmail.com",email2);
    }
}
