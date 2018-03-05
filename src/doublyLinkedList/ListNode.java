package doublyLinkedList;

public class ListNode<E extends Comparable<E>> implements Comparable<E> {
 
	private E data;
    private ListNode<E> next;
    private ListNode<E> prev;

    /**
     * constructor for a single, unconnected node
     * @param d object to put in the node
     */
    public ListNode(E e) {
		this(e, null, null);
	}

    /**|
     *  constructor for node that references another node
     * @param d object to be put in the node
     * @param n reference to another node
     */
    public ListNode(E e, ListNode<E> p, ListNode<E> n) {
    	data = e;
    	next = n;
    	prev = p;
    }
		    
    // access to fields
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

    // modify fields
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
     * getter for the reference to the previous node
     * @return the reference to the previous node
     */
    public ListNode<E> getPrev() {
    	return prev;
    }
    
    /**
     * setter for the reference to the previous node
     * @param p reference to the previous node
     */
    public void setPrev(ListNode<E> p) {
    	prev = p;
    }
    
    
    /**
     * 
     * @param i number to compare node to
     * @return returns 1 if node is bigger, returns -1 if node is smaller, returns 0 if they're the same.
     */
    @Override
    public int compareTo(E e) {
    	return data.compareTo(e);
    }
    
    /**
     * @return the data in the node as a string
     */
    public String toString() {
    	return data.toString();
    }
}
