package application;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String pass1, pass2;

	@Before
	public void setUp() throws Exception {
		String[] pas = {"112277CC%","8Sol*", "Abdul2LLL&", "b3sCd", "bertah21", "fgfAef", "Adwu2dh"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(pas));
		
	 
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("edf2")); //try this password who has less than 6 chars
			assertTrue("Did throw lengthException", true);
		}
		catch(LengthException e)
		{
			assertFalse("Threw a lengthExcepetion",false);
		}
		 
		catch(Throwable c)
		{
			assertTrue("Didnt threw some other exception besides lengthException",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("abdce2123"));
			 
			assertFalse("Did not throw NoUpperAlphaException for this password",true);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Threw a NoUpperAlphaExcepetion for this password",true);
		}
		catch(Throwable c)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException for this password"
					,false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword​("ACDEF4794"));
 
			assertFalse("Did not throw NoLowerAlphaException for this caase",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Threw a NoLowerAlphaExcepetion for this case",true);
		}
		catch(Throwable g)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException for this case",false);
		}
	}
	/**
	 * Test if the password is weak
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPsd = PasswordCheckerUtility.isWeakPassword​("Abcd123@!");
			assertTrue("Threw WeakPassword Exception",true);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Throw a NoLowerAlphaExcepetion",true);
		}
		catch(Throwable s)
		{ 
			assertTrue("Did not throw some incorrect exception",true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword​("5533AAAaa@@2"));
		 	assertTrue("Did not throw an InvalidSequenceException for this password",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threw an InvalidSequenceExcepetion for this password",true);
		}
		catch(Throwable e)
		{
			assertFalse("Did throw some other exception besides an InvalidSequenceException",true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{	
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword​("avxswA@f"));
		 	assertTrue("Did not throw an NoDigitException for this password",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Threw an NoDigitException for this password",true);
		}
		catch(Throwable e)
		{
			assertFalse("Did throw some other exception besides an NoDigitException",true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword​("AafeYd234@1234dA"));
		 	assertTrue("Did not throw any Exception for this password",true);
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			assertTrue("Threw some other exception besides the current excpetion",false);
		}
	}
	
	/**
	 * Test the getInvalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	
	@Test
	public void testGetInvalidPasswords() {
		ArrayList<String> passwordss = PasswordCheckerUtility.getInvalidPasswords​(passwords);
		//Adwu2dh;
		
		Scanner scan = new Scanner(passwordss.get(0)); 
		assertEquals(scan.next(), "112277CC%");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(passwordss.get(1));  
		assertEquals(scan.next(), "8Sol*");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("long"));
		
		 
		scan = new Scanner(passwordss.get(2));  
		assertEquals(scan.next(), "Abdul2LLL&");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence"));
		
		scan = new Scanner(passwordss.get(3));  
		assertEquals(scan.next(), "b3sCd");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(passwordss.get(4));  
		assertEquals(scan.next(), "bertah21");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") );
		
		scan = new Scanner(passwordss.get(5));  
		assertEquals(scan.next(), "fgfAef");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(passwordss.get(6));  
		assertEquals(scan.next(), "Adwu2dh" );
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") ); 
		
	}
	
}
