import java.util.Objects;

public class Town implements Comparable<Town>{

	private String name;
	
	//private int compare;
	
	public Town(String name) {
		this.name = name;
	}
	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}


	/**
	0 if names are equal, a positive or
	negative number if the names are not equal
	*/
	
	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.getName());
	}	
	
	@Override
		public boolean equals(Object tow) {
		Town T = (Town) tow;
			if(this.name.equals(T.getName())) {
				return true;
			} else {
				return false;
			}
		}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}

