import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	protected TreeNode<String> root;
	
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
/*		if(root==null) {
			return;
		}else {
	*/		
		this.root = newNode;
	//}
	}
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	 
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
		
	}
	
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> newroot = root;
		if(code.length() == 1) {
			if(code.equals(".")) {
				newroot.leftChild = new TreeNode<String> (letter);
			} else if(code.equals("-")){
				newroot.rightChild = new TreeNode<String> (letter);
			}
		}
		else {
			if(code.charAt(0) == '.') {
				newroot = root.leftChild;
				//addNode(root.leftChild, code.substring(1), letter);
			}
			else if(code.charAt(0) == '-'){
				newroot = root.rightChild;
				//addNode(root.rightChild, code.substring(1), letter);
			}			
			addNode(newroot, code.substring(1), letter);
		}
	}
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
	//	if(root != null)
			return fetchNode(root, code);
		//else 
			//return null;
	}


	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		TreeNode<String> copynode = root;

		String str = "";
		//if(root != null) {
		if(code.length() == 1) {
			if(code.equals(".")) {
			str= copynode.leftChild.getData();
			return str;
			} else if(code.equals("-")){
			str= copynode.rightChild.getData();	
			return str;
			}
		}
			else {
				if(code.charAt(0) == '.') {
					copynode = copynode.leftChild;
					//str+= fetchNode(copynode.leftChild, code.substring(1));
				}
				else if(code.charAt(0) == '-') {
					copynode = copynode.rightChild;
					//str+= fetchNode(copynode.rightChild, code.substring(1));
				}
			}
		//}
		//else {
		//return null;
		//}
		return fetchNode(copynode, code.substring(1));
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		insert(".","e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n"); 
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}


	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> str = new ArrayList<String>();
		LNRoutputTraversal(getRoot(),str);
		return str;
	}


	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null) {
			return;
		}
		if(root.leftChild != null) {
			LNRoutputTraversal(root.leftChild, list);	
		}
	        list.add(root.getData());
	    if(root.rightChild != null) {
				LNRoutputTraversal(root.rightChild, list);	
			}
	}

	
		}