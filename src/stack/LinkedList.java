package stack;

public class LinkedList<E> {

	private ListNode<E> front;
	
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

class ListNode<E> {
	 
	private E data;
    private ListNode<E> next;

    /**|
     *  constructor for node that references another node
     * @param d object to be put in the node
     * @param n reference to next node
     * @param p reference to previous node
     */
    public ListNode(E e, ListNode<E> n) {
    	data = e;
    	next = n;
    }
		    
    /**
     * getter for the data in the node
     * @return the data in the node
     */
    public E getData() {
        return data;
    }

    /**
     * getter for the reference to the next node
     * @return the reference to the next node
     */
    public ListNode<E> getNext() {
    	return next;
    }

    /**
     * setter for the data in the node
     * @param ob data to be put in the node
     */
    public void setData(E e) {
        data = e;
    }
    
    /**
     * setter for the reference to the next node
     * @param n reference to the next node
     */
    public void setNext(ListNode<E> n) {
    	next = n;
    }
    
    /**
     * @return the data in the node as a string
     */
    public String toString() {
    	return data.toString();
    }
}
