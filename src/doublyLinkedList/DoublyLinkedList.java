package doublyLinkedList;

public class DoublyLinkedList<E extends Comparable<E>> {

	private ListNode<E> front;
	
	/**
	 * constructor for list with 1 element
	 * @param e first element of list
	 */
	public DoublyLinkedList(E e) {
		front = new ListNode<E>(e);
	}
	
	/**
	 * default constructor for empty list
	 */
	public DoublyLinkedList() {
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
	 * 
	 * @param e the number we need to add or remove
	 * @return the position of that number, or null if it isn't in there
	 */
	public ListNode<E> insertFromBack(E e) {
		ListNode<E> current = front.getPrev();
		while(current.getPrev().compareTo(e)==1) {
			current = current.getPrev();
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
			insert.setPrev(front.getPrev());
			front.setPrev(insert);
			front = insert;
		} else if (front.getData().equals(e)) {
			return 2;
		} else {
			ListNode<E> previous = insertTo(e);
			//try {
			if(previous.getNext().getData().equals(e)) {
				return 2;
			} else {
				insert.setNext(previous.getNext());
				previous.getNext().setPrev(insert);
				previous.setNext(insert);
				insert.setPrev(previous);
			}
		/*	} catch (NullPointerException a) {
				insert.setNext(previous.getNext());
				previous.getNext().setPrev(insert);
				previous.setNext(insert);
				insert.setPrev(previous);
			}*/
		}
		return 0;
	}

	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	public int addElement2(E e, boolean fromFront) {
		ListNode<E> insert = new ListNode<E>(e);

		if(front == null){
			front = insert;
		} else if (front.getData().compareTo(e) == 1) {
			insert.setNext(front);
			insert.setPrev(front.getPrev());
			front.setPrev(insert);
			front = insert;
		} else if (front.getData().equals(e)) {
			return 2;
		} else {
			ListNode<E> previous;
			if(fromFront) {
				previous = insertTo(e);
				if(previous.getNext().getData().equals(e)) {
					return 2;
				} else {
					insert.setNext(previous.getNext());
					previous.getNext().setPrev(insert);
					previous.setNext(insert);
					insert.setPrev(previous);
				}
			} else {
				previous = insertFromBack(e);
				if(previous.getPrev().getData().equals(e)) {
					return 2;
				} else {
					insert.setPrev(previous.getPrev());
					previous.getPrev().setNext(insert);
					previous.setPrev(insert);
					insert.setNext(previous);
				}
			}

			/*try {
			} catch (NullPointerException a) {
				insert.setNext(previous.getNext());
				previous.getNext().setPrev(insert);
				previous.setNext(insert);
				insert.setPrev(previous);
			}*/
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
}


