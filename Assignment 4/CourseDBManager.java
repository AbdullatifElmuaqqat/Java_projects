import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure element;
	CourseDBElement element1;
	private int size;
	
	public CourseDBManager() {
		size = 20;
		element=new CourseDBStructure(size);
		 }
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		element1 = new CourseDBElement(id,crn,credits,roomNum,instructor);
		if(element != null) {
			element.add(element1);
		}
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return element.get(crn);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner read = new Scanner(input);
		
		if(input == null) {
			throw new FileNotFoundException();
		}
	
			while(read.hasNextLine()) {
				String [] courses = read.nextLine().split(" ");
			add(courses[0], Integer.parseInt(courses[1]),Integer.parseInt(courses[2]),courses[3],courses[4]);
			}	
		read.close();		
		}
	

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	
	@Override
	public ArrayList<String> showAll() {
		//ArrayList<String> elments_Show = new ArrayList<>();
		
//		if(element != null) {
//			for(String x: element.showAll()) {
//				elments_Show.add(x);
//			}
//		}
//			
//	return elments_Show;
//	}
		
		return element.showAll();
	}
}
