package com.web.designernails;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.web.designernails.Validations;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase{
	
	private Validations validations = new Validations();
	
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
    	String refinedPhoneNumber1 = validations.validateThePhoneNumber("781 111 1111");
    	String refinedPhoneNumber2 = validations.validateThePhoneNumber("781-111-1111");
    	String refinedPhoneNumber3 = validations.validateThePhoneNumber("!@#!#@!781/111/1111");

        assertEquals(10,refinedPhoneNumber1.length());
        assertEquals(10,refinedPhoneNumber2.length());
        assertEquals(10,refinedPhoneNumber3.length());
    }
    
    public void testEmailValidation() {
    	String email1 = validations.validateTheEmail("");
    	String email2 = validations.validateTheEmail("j@gmail.com");
    	
    	assertEquals("N/A",email1);
    	assertEquals("j@gmail.com",email2);
    }
}
