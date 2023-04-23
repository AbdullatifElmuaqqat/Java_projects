import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTestStudent {

	MorseCodeTree Mtree = new MorseCodeTree();//create MoreseCodeTree object
	ArrayList<String> Mlist = new ArrayList<>();//list
	
	@Test
	public void testGetRoot() {	
		assertEquals("",MorseCodeConverter.mcodetree.root.getData()); //default root "".
	}
	
	@Test
	public void testFetch() {	
		String LetterTest = Mtree.fetch("..-.");
		assertEquals("f",LetterTest);
	}
	
	@Test
	public void testTree() {	
		String str = "";
		Mlist = Mtree.toArrayList();
		for(int i = 0;i<Mtree.toArrayList().size();i++) {
			if(i!=Mtree.toArrayList().size()-1)
				str+=Mtree.toArrayList().get(i) + " ";
			else
				str+=Mtree.toArrayList().get(i);
		}
		assertEquals(Mlist,str);


	}
	@Test
	public void testSetRoot() {	
		TreeNode<String> testRoot = new TreeNode<String>("f");
		MorseCodeConverter.mcodetree.setRoot(testRoot);
		assertEquals("f",MorseCodeConverter.mcodetree.getRoot().getData());
	}
	
	@Test
	public void testinsert() {	
		//MorseCodeConverter.mcodetree.insert("-.--.", "?"); //Hana
		MorseCodeConverter.mcodetree.insert("..-.-", "(");
		MorseCodeConverter.mcodetree.insert("-.---", ")");
		MorseCodeConverter.mcodetree.insert("-.--.", "!");
		String Translate = MorseCodeConverter.convertToEnglish​(".. / ..-.- .- -... -.. ..- .-.. .-.. .- - .. ..-. -.--- / .-.. --- ...- . / .--. .- .-.. . ... - .. -. . -.--.");
		assertEquals("i (abdullatif) love palestine!", Translate);
	}
	
}

