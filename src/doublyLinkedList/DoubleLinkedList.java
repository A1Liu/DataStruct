package doublyLinkedList;

public class DoubleLinkedList<E extends Comparable<E>> {

	private ListNode<E> front;
	private ListNode<E> back;
	
	/**
	 * default constructor for empty list
	 */
	public DoubleLinkedList() {
		front = null;
		back = null;
	}

	/**
	 * 
	 * @param e the number we need to add or remove
	 * @return the position of that number, or null if it isn't in there
	 */
	private ListNode<E> fromFront(E e) {
		ListNode<E> current = front;
		while(current.getNext() != null && current.getNext().compareTo(e) < 0) {
			current = current.getNext();
		}
		return current;
	}
	
	/**
	 * 
	 * @param e the number we need to add or remove
	 * @return the position of that number, or null if it isn't in there
	 */
	private ListNode<E> fromBack(E e) {
		ListNode<E> current = back;
		while(current.getPrev() != null && current.getPrev().compareTo(e) > 0) {
			current = current.getPrev();
		}
		return current;
	}
	
	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	public void addFromBack(E e) {
		ListNode<E> insert = new ListNode<E>(e);
		if(front == null){
			front = insert;
			back = front;
		} else if (back.getData().compareTo(e) < 0) {
			insert.setPrev(back);
			back.setNext(insert);
			back = insert;
		} else if (!back.getData().equals(e)) {
			ListNode<E> previous = fromBack(e);
			if (previous.getPrev() == null) {
				insert.setNext(previous);
				previous.setPrev(insert);
				front = insert;
			} else if (!previous.getPrev().getData().equals(e)) {
				previous.getPrev().setNext(insert);
				insert.setPrev(previous.getPrev());
				insert.setNext(previous);
				previous.setPrev(insert);
			}
		}
	}

	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	public void add(E e) {
		ListNode<E> insert = new ListNode<E>(e);
		if(front == null){
			front = insert;
			back = front;
		} else if (front.getData().compareTo(e) > 0) {
			insert.setNext(front);
			front.setPrev(insert);
			front = insert;
		} else if (!front.getData().equals(e)) {
			ListNode<E> previous = fromFront(e);
			if (previous.getNext() == null) {
				insert.setPrev(previous);
				previous.setNext(insert);
				back = insert;
			} else if (!previous.getNext().getData().equals(e)) {
				previous.getNext().setPrev(insert);
				insert.setNext(previous.getNext());
				insert.setPrev(previous);
				previous.setNext(insert);
			}
		}
	}
	
	/**
	 * gets the first node of the list
	 * @return the reference to the first node in the list
	 */
	public ListNode<E> getFront() {
		return front;
	}
	
	/**
	 * setter for the first node of the list
	 * @param e the new first node
	 */
	public void setFront(ListNode<E> e) {
		front = e;
	}
	
	/**
	 * gets the last node of the list
	 * @return reference to last node of the list
	 */
	public ListNode<E> getBack() {
		return back;
	}

	/**
	 * setter for the last node in the list
	 * @param back last node in the list
	 */
	public void setBack(ListNode<E> back) {
		this.back = back;
	}

	/**
	 * returns the contents of the list in string form
	 * @return a string with the contents of the list
	 */
	public String toString() {
		ListNode<E> current = front;
		String output = "";
		if(current != null) {
			output = output + current.toString() + "\n";
			current = current.getNext();
			while(current.getNext() != null) {
				output = output + current.toString() + "\n";
				current = current.getNext();
			}
			output = output + current.toString();
		} else {
			output = output + "Empty List";
		}
		return output;
	}
}
