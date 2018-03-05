package doublyLinkedList;

public class LinkedList<E extends Comparable<E>> {

	private ListNode<E> front;
	
	/**
	 * constructor for list with 1 element
	 * @param e first element of list
	 */
	public LinkedList(E e) {
		front = new ListNode<E>(e);
	}
	
	/**
	 * default constructor for empty list
	 */
	public LinkedList() {
		front = null;
	}
	
	/**
	 * gets the first element of the list
	 * @return the reference to the first node in the list
	 */
	public ListNode<E> getFront() {
		return front;
	}
	
	/**
	 * setter for the first element of the list
	 * @param e the new first element
	 */
	public void setFront(ListNode<E> e) {
		front = e;
	}
	
	/**
	 * 
	 * @param e the number we need to add or remove
	 * @return the position of that number, or null if it isn't in there
	 */
	public ListNode<E> insertTo(E e) {
		ListNode<E> current = front;
		while(current.getNext() != null && current.getNext().compareTo(e)==-1) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	public int addElement(E e) {
		ListNode<E> insert = new ListNode<E>(e);

		if(front == null){
			front = insert;
		} else if (front.getData().compareTo(e) == 1) {
			insert.setNext(front);
			front.setPrev(insert);
			front = insert;
		} else if (front.getData().equals(e)) {
			return 2;
		} else {
			ListNode<E> previous = insertTo(e);
			try {
			if(previous.getNext().getData().equals(e)) {
				return 2;
			} else {
				insert.setNext(previous.getNext());
				previous.setPrev(insert);
				previous.setNext(insert);
				insert.setPrev(previous);
			}
			} catch (NullPointerException a) {
				insert.setNext(previous.getNext());
				previous.setPrev(insert);
				previous.setNext(insert);
				insert.setPrev(previous);
			}
		}
		return 0;
	}
	
	/**
	 * removes the element e if it's in the list
	 * @param e the element we want to remove
	 * @return a 0 if successful, a 3 if unsuccessful
	 */
	public int remElement(E e) {
		try {
			if (e.equals(front.getData())) {
				front = front.getNext();
			} else {
				ListNode<E> previous = insertTo(e);
				if(previous.getNext().getData().equals(e))
					previous.setNext(previous.getNext().getNext());
				else return 3;
			}
		} catch (NullPointerException a) {
			return 3;
		}
			return 0;
	}

	/**
	 * returns the contents of the list in string form
	 */
	public String toString() {
		ListNode<E> current = front;
		String output = "[";
		if(current != null) {
			while(current.getNext() != null) {
				output = output + current.toString() + ", ";
				current = current.getNext();
			}
			output = output + current.toString();
		} else {
			output = output + "Empty List";
		}
		return output + "]";
	}
	
	/**
	 * reverses a list
	 * @param reverseThis the current node the method is calling
	 */
	public void reverseList(ListNode<E> reverseThis){
		if (reverseThis.getNext() == null) {
			front = reverseThis;
			return;
		}
			reverseList(reverseThis.getNext());
			reverseThis.getNext().setNext(reverseThis);
			reverseThis.setNext(null);
	}
}
