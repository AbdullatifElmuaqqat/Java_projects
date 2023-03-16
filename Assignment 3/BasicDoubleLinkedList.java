import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.xml.crypto.Data;

import org.w3c.dom.Node;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node<T> head; 
	protected Node<T> tail;
	protected int size =0;
	
	//BasicDoubleLinkedList constructor.
		public BasicDoubleLinkedList() {
			 this.head = null;
			 this.tail = null;
			 this.size = 0;
		}
	
	//Generic inner class	
	protected class Node<T> {
		protected T data;
		protected Node<T> prev;
		protected Node <T>next;
		
		protected Node(T dataNode){
			this.data = dataNode;
		}
		
//		protected T getData()
//		{
//			return this.data;
//		}
	
	}
	

	//check if there is no linked list
	public boolean isEmpty() {
		
		if(head == null && tail == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the number of nodes in the list.
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 	Adds an element to the front of the list and updated the size of the list
	 * @param data
	 */
	public void addToFront​(T data) {
		
		Node<T> first = new Node<T>(data);
		
		if (isEmpty()) {
			this.head =first;
			this.tail =first;
		}
		else {
			
		//Node first = new Node(data);
		first.next = head;
		head.prev = first;
	}
		head = first;
		//head.prev = null;
		size++;
	}
	
	/**
	 * 	Adds an element to the end of the list and updated the size of the list
	 * @param data
	 */
	public void addToEnd​(T data) {
		Node<T> end= new Node(data);
		
		if (isEmpty()) {
			this.head =end;
			this.tail =end;
		}
		 
		else {
		tail.next= end;
		end.prev = tail;
		
	}
		tail = end;
		//tail.next = null;
		size++;
	}
	
	/**
	 * Returns but does not remove the first element from the list.
	 * @return the first element from the list.
	 */
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		else {
			return (T) head.data;
		}
	}
	
	/**
	 * 	Returns but does not remove the last element from the list.
	 * @return the last element from the list.
	 */
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		else {
		return (T) tail.data;
	}
}
	
	/**
	 * Removes the first instance
	 *  of the targetData from the list.
	 *  
	 */
	
	public Node<T> remove(T targetData, Comparator<T> comparator) {	
	    Node<T> current = head;
	    while(current != null) {
	        if(comparator.compare(targetData, current.data) == 0) {
	            if(current == head) {
	                head = head.next;
	            } else if(current == tail) {
	                tail = tail.prev;
	            } else {
	                current.prev.next = current.next;
	                current.next.prev = current.prev;
	            }
	            size--;
	            return current;
	        }
	        current = current.next;
	    }
	    return current;
	}
	
	/** Detects whether this iterator has completed its traversal
	 and gone beyond the last entry in the collection of data.
	 @return True if the iterator has another entry to return. 
	*/
	
	public class DoubleLinkedListIterator  implements ListIterator<T> {
		
		protected Node<T> nextnode;
		protected Node<T> prevnode;
		//protected int index = 0;
		
		public DoubleLinkedListIterator() {
			//this.index = 0;
			this.nextnode = head;
			this.prevnode = null;
		}
		
		@Override
		public boolean hasNext() {
			return nextnode != null;
		}

		@Override
		public T next() throws NoSuchElementException {
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				prevnode = nextnode;
				nextnode = nextnode.next;
				return prevnode.data;
			}
		}

		@Override
		public boolean hasPrevious() {
			return prevnode != null;
		}

		@Override
		public T previous() throws NoSuchElementException {
			
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			else {
				nextnode = prevnode;
				prevnode = prevnode.prev;
				return nextnode.data;	
					}
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();	
		}
		
	}
	
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}

	/**
	 * This method used to display the items in the double linked list
	 *
	 * @return an arraylist of all the items in the Double Linked list
	 * 
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<T>();
		//DoubleLinkedListIterator x = new DoubleLinkedListIterator(); 
		Node<T> tempr = head;
		
		while(tempr != null) {
				list.add(tempr.data);
				tempr = tempr.next;
			}
		return list;
		}


	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. 
	 * Do not implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		if(isEmpty()) {
			return null;
		} 
		else {
		Node<T> firstn = head;
		Node<T> firstn_temp = head.next;
		head.next = null;
		firstn_temp.prev = null;
		head = firstn_temp;
		
		return firstn.data; 
	}
}

	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null. 
	 * Do not implement implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		if(isEmpty()) {
			return null;
		} 
		else {
		Node<T> lastn = tail;
		Node<T> lastn_temp = tail.prev;
		lastn_temp.next = tail;
		tail.prev = null;
		lastn_temp.next = null;
		tail = lastn_temp;
		
		return lastn.data;
	}
}
}