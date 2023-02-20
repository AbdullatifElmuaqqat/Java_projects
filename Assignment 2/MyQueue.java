 
import java.util.ArrayList;

/** Interface for a Queue data structure
 * 
 *  @param <T> data type
 */
public class MyQueue<T> implements QueueInterface<T> {
	
	private T[] MyQueue;
	private int size;
	int front =0;
	private int lastindex = -1;
	private final static int DEFAULT_CAPACITY = 110;

	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 
	 */
	public MyQueue(int size){
		this.size = size;
		MyQueue = (T[]) new Object[size];
	}
	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		
		return lastindex == -1;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		return lastindex  == MyQueue.length-1;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
		T element = MyQueue[front];
		MyQueue[front] = null;
		front = (front + 1) % MyQueue.length;
		lastindex --;
		return element;
	}
}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return lastindex +1;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException{
		if(isFull()) {
			throw new QueueOverflowException();
		}
		else {
			MyQueue[++lastindex ] = e;
			return true;
		}
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<=lastindex;i++) {
			str.append(MyQueue[i]);
		}
		
		return str.toString();
		}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<=lastindex;i++) {
			str.append(MyQueue[i]).append(delimiter);
		}
		
		str.deleteCharAt(str.length()-1);
		
		return str.toString();
		}
		
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	 * @throws StackOverflowException 
	  * @throws QueueOverflowException if queue is full
	 
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException, QueueOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
		for(int i = 0; i< list.size();i++) {
			T element=(list.get(i));
			enqueue(element);
			}
	}
 

}
	
}
