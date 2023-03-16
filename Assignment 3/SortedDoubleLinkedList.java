import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	//protected T data;
	private Comparator<T> comp;

	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param compareableObject
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		comp = compareableObject;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * @param data
	 */
	public void add(T data) {
		Node<T> current = head;
		Node<T> node = new Node<>(data);

		if(isEmpty()) {
			head = node;
			tail = node;
			//size++;
		}else if(comp.compare(data,tail.data) >0){// to add at the end of the list.
			tail.next= node;
			node.prev =tail;
			tail = node;
			tail.next = null;
		}else if (comp.compare(head.data, data)>=0) {// to add to the beginning of the list.
			head.prev = node;
			node.next = head;
			head = node;
			head.prev = null;
		}else {
		//Traverse between the nodes to update current (pointer)
		while(current != null && comp.compare(data,current.data)>0)
		{
			current = current.next;
		}
		
		current.prev.next = node;
		node.prev = current.prev;
		current.prev = node;
		node.next = current;
	}
	size++;
	}
	
////			node.next = head;
////			head.prev = node;
////			head = node;
////		    size++;
//			super.addToFront​(data);
//		}
//		
//		else if(current == null) {
////			node.prev = tail;
////			tail.next= node;
////			tail= node;
////			size++;
//			super.addToEnd​(data);
//		}
//		else {	
//			node.next = current;
//			node.prev = current.prev;
//			node.prev.next = node;
//			current.prev = node;	
//			size++;
//		}
//	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * throws UnsupportedOperationException
	 */
	@Override
	public void addToEnd​(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * throws UnsupportedOperationException
	 */
	@Override
	public void addToFront​(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @return iterator positioned at the head of the list
	 */
	public java.util.ListIterator<T> iterator(){
		return super.iterator();
	}
	/**
	 * 
	 * @param data - the data element to be removed
	 * @param comparator -  the comparator to determine equality of data elements.
	 * @return a node containing the data or null
	 * 
	 */
	public BasicDoubleLinkedList.Node remove​(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}
}
