package linkedList;

public class LinkedList<E> {

	private ListNode<E> front;
	
	public LinkedList(E e) {
		front = new ListNode<E>(e);
	}
	
	public LinkedList() {
		front = null;
	}
	
	public ListNode<E> getFront() {
		return front;
	}
	
	public void addElement(E e) {
		ListNode<E> previous = front;
		ListNode<E> insert = new ListNode<E>(e);

		if(findElement(e) != null) {
			System.out.println("Its already there mi dood");
		} else if(previous == null){
			front = insert;
		} else {
			if(previous.compareTo((int) e) == 1) {
				insert.setNext(previous);
				front=insert;
			} else {
				previous = insertTo(e);
				insert.setNext(previous.getNext());
				previous.setNext(insert);
			}
		}
	}
	
	public void remElement(E e) {
		ListNode<E> previous = insertTo(e);
		if(previous != null) {
		previous.setNext(previous.getNext().getNext()); 
		} else {
			//error message
		}
	}
	
	/**
	 * 
	 * @param e the number we need to add or remove
	 * @return the position of that number, or null if it isn't in there
	 */
	public ListNode<E> insertTo(E e) {
		ListNode<E> current = front;
		while(current.getNext() != null && current.getNext().compareTo((int) e)==-1) {
			current = current.getNext();
		}
		return current;
	}
	
	public ListNode<E> findPrevious(E e) {
		ListNode<E> current = front;
		while(current.getNext() != null && current.getNext().compareTo((int) e)!=0) {
			current = current.getNext();
		}
		return current;
	}
	
	public ListNode<E> findElement(E e) {
		ListNode<E> current = front;
		if(current != null) {
			if(current.compareTo((int) e) == 0) {
				return current;
			} else return findPrevious(e).getNext();
		} else return null;
	}
	
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
