import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static MorseCodeTree mcodetree = new MorseCodeTree();
	
	public MorseCodeConverter() {}
	
	public static String printTree(){
		
		String x = "";
		ArrayList<String> arra = mcodetree.toArrayList();
		for(String s:arra) {
			x += s+" ";
		}
		return x.trim();
		} 
	
//	public static String convertToEnglish​(java.lang.String code){
//		
//		String [] word = code.split("/");
//		String Converts = " ";
//		for(String s:word) {
//			String[] str = s.split(" ");
//			for(String d: str) {
//				Converts+= mcodetree.fetch(code);
//			}
//			Converts+= " ";
//		}
//		
//		return Converts;
//		
//	}
	
	public static String convertToEnglish​(String code){
	    String[] word = code.split(" / ");
	    String Converts = "";
	    for(String s : word) {
	        String[] str = s.split(" ");
	        for(String d : str) {
	            Converts += mcodetree.fetch(d);
	        }
	        Converts += " ";
	    }
	    return Converts.trim();
	}
	
	public static java.lang.String convertToEnglish​(File codeFile) throws FileNotFoundException{
		Scanner s = new Scanner(codeFile);
		String st ="";
		
		while(s.hasNextLine()) {
			st += s.nextLine() + "\n";
		}
		s.close();
		
		return convertToEnglish​(st.trim());
		
	}

}
