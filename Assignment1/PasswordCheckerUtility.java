package application;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	/**
	 * Compare equality of two passwords.
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException- thrown if not same (case sensitive)
	 */
	
	public static void comparePasswords​(String password,
           String passwordConfirm)	throws UnmatchedException

	{
		if(!(password.equals(passwordConfirm))){
			throw new UnmatchedException("The passwords do not match");	
}
	
	}
	
	/**
	 * 
	 * Compare the two passwords if they have the same characters
	 * @param password
	 * @param passwordConfirm
	 * @return true if they are the same. False 
	  if they aren't the same. 
	 *
	 */
	
	public static boolean comparePasswordsWithReturn​(String password,
            String passwordConfirm)
	{
		boolean compare = false;
		if(password.equals(passwordConfirm)) {
			return compare = true;
		}
		return compare;
	}
	
	public static boolean isValidLength​(String password)
            throws LengthException  
            {
		if(password.length()<6) {
			throw new LengthException("The password must be at least 6 characters long");
        }
		
		else {
			
		return true;
		}
            }
	
	/**
	 * Checks the password alpha character requirement - 
	 * Password must contain an uppercase alpha character.
	 * @param password
	 * @return true if meet alpha character requirement,
	 which is at least one Upper Character
	 * @throws NoUpperAlphaException - thrown if does not 
	 meet alpha character requirement.
	 *
	 */
	public static boolean hasUpperAlpha​(String password)
            throws NoUpperAlphaException
            {
		
		//for(int i = 0; i<password.length();i++) {
			
//			char n = password.charAt(i);
//			String str = String.valueOf(n);
//			Pattern pattern = Pattern.compile("[A-Z]*");
//			Matcher matcher = pattern.matcher(str);
//			
//			if(!(matcher.find())) {
//				throw new NoUpperAlphaException("Password doesn’t contain an uppercase alpha character");
//				}
//			}
			String [] split = password.split("");
			for(String s:split) {
				if(s.matches("[A-Z]")) {
					return true;
				}
			}
//		if(hasUpperAlpha​(password)) {
//			return true;
//		}
//		else {
//			throw new NoUpperAlphaException();
//          }
			throw new NoUpperAlphaException("Password doesn’t contain an uppercase alpha character");
           }
	
	/**
	 * Checks the password lowercase requirement 
	 * - Password must contain at least one lowercase alpha character.
	 * @param password
	 * @return true if meets lowercase requirement, which is at least
	  one lower case characrter.
	 * @throws NoLowerAlphaException-
	 thrown if does not meet lowercase requirement.
	 *
	 */
	public static boolean hasLowerAlpha​(String password)
            throws NoLowerAlphaException
            {
//		for(int i = 0; i<password.length();i++) {
//			
//		char n = password.charAt(i);
//		String str = String.valueOf(n);
//		Pattern pattern = Pattern.compile("[a-z]*");
//		Matcher matcher = pattern.matcher(str);
//		if((matcher.find())) {
//			throw new NoLowerAlphaException("Password doesn’t contain a lowercase alpha character");
//		}
//	}
		String [] split = password.split("");
		for(String s:split) {
			if(s.matches("[a-z]")) {
				return true;
			}
		}
		throw new NoLowerAlphaException("Password doesn’t contain a lowercase alpha character");
		}
	
	/**
	 * Checks the password Digit requirement 
	 - Password must contain a numeric character
	 * @param password
	 * @return true if meet Digit requirement, which is at 
	  least one number in the password.
	 * @throws NoDigitException - 
	 *  thrown if does not meet Digit requirement.
	 */
	public static boolean hasDigit​(String password)
            throws NoDigitException
            {
		
		String[] split = password.split("");
		for(String sp:split) {
			if(sp.matches("[0-9]")) {
				return true;
			}
		}
		throw new NoDigitException("The password must contain at least one digit");
        }
	
	/**
	 * Checks the password SpecialCharacter requirement - 
	   Password must contain a Special Character
	 * @param password
	 * @return true if meets SpecialCharacter requirement,
	  which is at least one special character.
	 * @throws NoSpecialCharacterException - 
	   thrown if does not meet SpecialCharacter requirement
	 *
	 */
	
	public static boolean hasSpecialChar​(String password)
            throws NoSpecialCharacterException
			{
		String[] split = password.split("");
		for(String sp:split) {
			if(sp.matches("[$ & + , : ; = ? @ # | ' < > . - ^ * ( ) % !]")) {
				return true;
			}
		}
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
	/**
	 * Checks the password Sequence requirement - 
	 Password should not contain more than 2 of the 
	 same character in sequence
	 * @param password
	 * @return false if does NOT meet Sequence requirement.
	 * @throws InvalidSequenceException -
	  thrown if meets Sequence requirement
	 *
	 */
	
	public static boolean NoSameCharInSequence​(String password)
            throws InvalidSequenceException
            {
		for(int i = 0; i<password.length()-2; i++) {
		if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i+2)) {
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
		}
            }
		
	return false;
	
      }
		
	/**
	 * Check the validate of the password
	 * @param password
	 * @return Return true if valid password,
	 *  returns false if an invalid password
	 *   1. At least 6 characters long 
	 *    2. At least 1 numeric character
	 *     3. At least 1 uppercase alphabetic character 
	 *      4. At least 1 lowercase alphabetic character 
	 *       5. At least 1 special character 
	 * 			6. No more than 2 of the same character in a sequence.
	 * @throws LengthException - thrown if the password is less than 6 characters.
	 * @throws NoUpperAlphaException thrown if the password does not contain at least one Upper case.
	 * @throws NoLowerAlphaException thrown if the password does not contain at least one lower case.
	 * @throws NoDigitException thrown if the password does not contain at least one digit. 
	 * @throws NoSpecialCharacterException throw if the password does not has at least one special charact.
	 * @throws InvalidSequenceException throw if the password contain more than 2 of the same character.
	 *
	 */
	public static boolean isValidPassword​(String password)
			throws LengthException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   NoDigitException,
                   NoSpecialCharacterException,
                   InvalidSequenceException
	{
		
		try {
			isValidLength​(password);
			hasUpperAlpha​(password);
			hasLowerAlpha​(password);
			hasDigit​(password);
			hasSpecialChar​(password);
			NoSameCharInSequence​(password);
		}
		catch(LengthException e) {
			throw new LengthException("The password must be at least 6 characters long");
		}
		catch(NoUpperAlphaException e) {
			throw new NoUpperAlphaException("Password doesn’t contain an uppercase alpha character");
		}
		catch(NoLowerAlphaException e) {
			throw new NoLowerAlphaException("Password doesn’t contain a lowercase alpha character");
		} 
		catch(NoDigitException e) {
			throw new NoDigitException("The password must contain at least one digit");
		}
		catch(NoSpecialCharacterException e) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		catch(InvalidSequenceException e) {
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
		}
		
//		try {
//			PasswordCheckerUtility.isValidLength​(password);
//		}
//		catch(LengthException e) {
//			throw new LengthException();
//		}
//		try {
//			PasswordCheckerUtility.hasUpperAlpha​(password);
//		}
//		catch(NoUpperAlphaException e) {
//			throw new NoUpperAlphaException();
//		}
//		try {
//			PasswordCheckerUtility.hasLowerAlpha​(password);
//		}
//		catch(NoLowerAlphaException e) {
//			throw new NoLowerAlphaException();
//		}
//		try {
//			PasswordCheckerUtility.hasDigit​(password);
//		}
//		catch(NoDigitException e) {
//			throw new NoDigitException();
//		}
//		try {
//			PasswordCheckerUtility.hasSpecialChar​(password);
//		}
//		catch(NoSpecialCharacterException e) {
//			throw new NoSpecialCharacterException();
//		}
//		try {
//			PasswordCheckerUtility.NoSameCharInSequence​(password);
//		}
//		catch(InvalidSequenceException e ) {
//			throw new InvalidSequenceException();
//		}
	
		
		return true;
	}
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars​(String password)
	{
		
		if(password.length() >=6 && password.length() <= 9) {
			return true;
		}
		return false;
	}

	    
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws WeakPasswordException if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID.

	 */
	public static boolean isWeakPassword​(String password)
            throws WeakPasswordException
            {
		
			if((hasBetweenSixAndNineChars​(password))){
				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
			}
		return false;
          }
		
//	try {
//		if(isValidPassword​(password) && (hasBetweenSixAndNineChars​(password))) {
//				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
//			}
//	}
//	catch(Exception e) {
//		return true;
//            }
//	
//	return false;
//        }
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an 
	 * ArrayList with the status of any invalid passwords (weak passwords are not considered invalid). 
	 * The ArrayList of invalid passwords will be of the following format: password BLANK message of the exception thrown
	 * @param passwords
	 * @return ArrayList of invalid passwords in the correct format
	 */
	
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords){
		ArrayList<String> invalidPass =  new ArrayList<>();
		for( String password : passwords) {
			
			try {
				isValidPassword​(password);
			}
			
			/*
			Exceptions name: LengthException,
            NoUpperAlphaException,
            NoLowerAlphaException,
            NoDigitException,
            NoSpecialCharacterException,
            InvalidSequenceException
			*/
			
			catch(LengthException a) {
				invalidPass.add(password + " " + a.getMessage());
			}
			catch(NoUpperAlphaException b) {
				invalidPass.add(password + " " + b.getMessage());
			}
			catch(NoLowerAlphaException c) {
				invalidPass.add(password + " " + c.getMessage());
			}
			catch(NoDigitException d) {
				invalidPass.add(password + " " + d.getMessage());
			}
			catch(NoSpecialCharacterException e) {
				invalidPass.add(password + " " + e.getMessage());
			}
			catch(InvalidSequenceException f) {
				invalidPass.add(password + " " + f.getMessage());
			}
		}
		
			return invalidPass;
		}
}