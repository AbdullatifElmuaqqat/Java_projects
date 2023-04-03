import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */

public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dManager = new CourseDBManager();
	
	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dManager  = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dManager  = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dManager .add("CMSC216",31123,4,"SC220","Micheal Jakson");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() { 
		dManager .add("CMSC216",31123,4,"SC220","Micheal Jakson");
		dManager .add("CMSC207",31233,4,"SC300","Shab Jdeed");
		dManager .add("CMSC204",32331,4,"SC323","Wegz");
		ArrayList<String> list = dManager .showAll();
		assertEquals(list.get(0),"\nCourse:CMSC216 CRN:31123 Credits:4 Instructor:Micheal Jakson Room:SC220");
	 	assertEquals(list.get(1),"\nCourse:CMSC204 CRN:32331 Credits:4 Instructor:Wegz Room:SC323");
		assertEquals(list.get(2),"\nCourse:CMSC207 CRN:31233 Credits:4 Instructor:Shab Jdeed Room:SC300");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test.testtead.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC216 31123 4 SC220 Micheal Jakson");
			inFile.print("CMSC204 32331 4 SC323 Wegz");
			
			inFile.close();
			dManager.readFile(inputFile);
			assertEquals("CMSC216",dManager.get(31123).getID());
			assertEquals("CMSC204",dManager.get(32331).getID());
			assertEquals("SC323",dManager.get(32331).getRoomNum());
			assertEquals("Wegz",dManager.get(32331).getInstructorName());
			assertEquals("SC220",dManager.get(31123).getRoomNum());

		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}