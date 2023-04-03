import java.util.LinkedList;
import java.util.Objects;

public class CourseDBElement implements Comparable <CourseDBElement>  {

	private String ID;
	private int CRN;
	private int NofCredits;
	private String RoomNum;
	private String InstructorName;
	
	
	public CourseDBElement() {
		this.ID = null;
		this.CRN = 0;
		this.NofCredits = 0;
		this.RoomNum = null;
		this.InstructorName = null;
	}
	
	public CourseDBElement(String courseID, int cRN, int nofCredits, String roomN, String instructorName) {
		this.ID = courseID;
		this.CRN = cRN;
		this.NofCredits = nofCredits;
		this.RoomNum = roomN;
		this.InstructorName = instructorName;
	}



	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getCRN() {
		return CRN;
	}

	public void setCRN(int cRN) {
		CRN = cRN;
	}

	public int getNofCredits() {
		return NofCredits;
	}

	public void setNofCredits(int nofCredits) {
		NofCredits = nofCredits;
	}

	public String getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}

	public String getInstructorName() {
		return InstructorName;
	}

	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}

	@Override
	public int compareTo(CourseDBElement element) {
	    switch (Integer.compare(this.CRN, element.getCRN())) {
	        case 0:
	            return 0;
	        case 1:
	            return 1;
	        default:
	            return -1;
	    }
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		CourseDBElement elmnt = (CourseDBElement)obj;
//		
//		if(this.CRN == elmnt.getCRN()) {
//			return true;
//		}
//		else
//			return false;
//		


	
	@Override
	public String toString() {
		return "\nCourse:" + this.ID + " CRN:" + this.CRN + " Credits:" + 
	this.NofCredits + " Instructor:" + this.InstructorName+ " Room:" + 
				this.RoomNum;
	}
}