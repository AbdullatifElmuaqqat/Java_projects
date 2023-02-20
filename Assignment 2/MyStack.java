import java.util.ArrayList;

/** Interface for a generic Stack data structure
 * 
 * @param <T> data type
 */

public class MyStack <T> implements StackInterface<T> {
	
	private T[] stack;
	private int size;
	private int topindex = -1;
	private final static int DEFAULT_CAPACITY = 110;
	
	
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	public MyStack(int size) {
		this.size = size;
		stack = (T[]) new Object[size];
	}
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	
	public boolean isEmpty() {
//		if(topindex <= -1) {
//			return true;
//		}
//		else {
//		return false;
//	}
		return topindex == -1;
}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	
	public boolean isFull() {
		 
		return topindex == stack.length-1;
	}
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	
	public T pop() throws StackUnderflowException{
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		} 
		else {
//		topindex = stack.length-1;	// decrease the top by 1 so next time when we try to pop the next element.
		T element =  stack[topindex]; //storing the pop element. 
		stack[topindex] = null;//deleting the elemnt by assigning null to it.
		topindex--;
		return element; //return the pop element.
		
		}
		
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	
	public T top() throws StackUnderflowException{
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T element = stack[topindex];
			return element;	
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	
	public int size() {
		
		return topindex+1;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	
	public boolean push(T e) throws StackOverflowException{
	
		if(isFull()){
			throw new StackOverflowException();
		} else {
			stack[topindex+1] = e;
			topindex++;
			return true;
		}
		
//		if(stack[topindex].equals(e))
//			return true;
//		else
//			return false;
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	
	public String toString() {
		String str = "";
//		for(int i = size()-1; i >= 0 ;i--) {
//			str+= stack[i] + " ";
//		}
		for(int i = 0; i<= topindex; i++) {
			str+= stack[i];
		}
		

		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	
	public String toString(String delimiter) {
		
		//String str = "";
		StringBuilder string1  = new StringBuilder();
		
		for(int i = 0; i<=topindex; i++) {
			string1.append(stack[i]).append(delimiter);
		}
		
		//string1.deleteCharAt(string1.length()-1);
		
		for(int i = string1.length()-1; i<string1.length()+1; i++) {
			string1.deleteCharAt(i);
		}
		
		String str = string1.toString();

		return str;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	 * @throws StackOverflowException 
	  */
	
	public void fill(ArrayList<T> list) throws StackOverflowException {
		
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
		for(int i = 0; i< list.size();i++) {
			T element=(list.get(i));
			push(element);
		}
	}
 
	}
}