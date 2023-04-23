import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class theMorseCodeConverterTestStudent {

	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
//	@Test
//	public void testPrintTree1() {	
//		
//		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
//	}
//	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		String Translate = MorseCodeConverter.convertToEnglish​(".. / ... . . / -.-- --- ..- .-. / ..-. .- -.-. . / .. -. / . ...- . .-. -.-- / --. .. .-. .-..");
		assertEquals("i see your face in every girl", Translate);
	}
		@Test
		public void testConvertMorseStringToEnglishString1() {	
			String Translate2 = MorseCodeConverter.convertToEnglish​(".-.. .. -.- . / - .... . / -- --- --- -. / -.-- --- ..- .-. / ..-. .- -.-. . / .-- .- ... / -.-. .-. . .- - . -.."
					);
			assertEquals("like the moon your face was created", Translate2);
//		String Translate1 =  MorseCodeConverter.convertToEnglish​(".-.. .. -.- . / - .... . / -- --- --- -. --..-- / -.-- --- ..- .-. / ..-. .- -.-. . / .-- .- ... / -.-. .-. . .- - . -..");
//		assertEquals("like the moon, your face was created", Translate1);


	}
	
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*
		 * Ilovejava.txt is sumbited with the assigment Java files and complete
		*/
		File file = new File("src/ilovejava.txt"); 
		try {
			assertEquals("i love java", MorseCodeConverter.convertToEnglish​(file));
		} catch (FileNotFoundException e) {
			assertTrue("Unwanted exception was caught", false);
		}
	}
	

}