import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure  implements CourseDBStructureInterface{
	
	 double load_factor = 1.5;
	 private int size;
	 ArrayList<String> stri;
	 private int linkedlistsize;
	 private LinkedList<CourseDBElement>[] bucket;
	 
	public CourseDBStructure(int n) {
		linkedlistsize = fourKPlus3(n, load_factor);
		bucket = new LinkedList[linkedlistsize];
		size = 0;
		stri = new ArrayList<String>();
}
	
	public CourseDBStructure(String str, int n) {
		linkedlistsize = n;
		bucket = new LinkedList [linkedlistsize];
		size = 0;
		stri = new ArrayList<String>();
}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.int 
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	
	@Override
	public void add(CourseDBElement element) {
		boolean exist = false;
		int index = getelementhash(element);
				
	
		if(bucket[index]== null) {

			bucket[index] = new LinkedList<CourseDBElement>();
			stri.add(element.toString());
			//bucket[index].add(element);
			
		} 
		else {
			
			for(int i =0; i<bucket[index].size(); i++) {
				if(bucket[index].get(i).compareTo(element) == 0) {
					bucket[index].set(i, element);
					exist = true;
				}
			}
		}
		if(exist == false) {
			bucket[index].add(element);
			size++;
		}
			
	}

	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		int index = getCRNhash(crn);
		
		if(bucket[index] != null) {
			for(int i =0; i<bucket[index].size();i++) {
				if(bucket[index].get(i).getCRN()== (int)crn) {
					return bucket[index].get(i);
				}
			}
		}
			
//		else {
//		throw new IOException();
//	}
		throw new IOException();
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
		String string = " ";
		ArrayList<String> str = new ArrayList<String>(size);
		for(int i = 0; i <bucket.length; i++) {
			if(bucket[i] != null) {
				for(int j =0; j < bucket[i].size(); j++) {
					
					str.add(bucket[i].get(j).toString());
				}
			}
		}
//			String string= "Course: " + x.getID()+ " CRN: " + x.getCRN() + " Credits: "+ 
//				x.getNofCredits()+ " Instructor: " 
//					+x.getInstructorName()+ " InParticular Room: "+ x.getRoomN() + "\n";

		return str;
	}

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return linkedlistsize;
	}
	
	
	public int getelementhash(CourseDBElement element) {//create a hashcode and index for the add method
		Integer CrnHash = element.getCRN();
		int index = CrnHash.hashCode() % linkedlistsize; //set the index.
		
		return index;
	}
	
	public int getCRNhash(int crn) {//create a hashcode and index for the get method
		
		Integer CRNstring = crn;
		int index = CRNstring.hashCode()%linkedlistsize;
		return index;
		
	}
	
	//a method to check the next prime number
	public static int fourKPlus3(int n, double loadfactor)
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;
	  

	   prime = (int)(n/loadfactor);
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;

	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   }
	   return prime;  // end of 4k+3 prime search loop
	}
}