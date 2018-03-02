package linkedList;

public class ListNode<E> {
 
	private Object data;
    private ListNode<E> next;

    /**
     * constructor for a single, unconnected node
     * @param d object to put in the node
     */
    public ListNode(Object d) {
		this(d, null);
	}

    /**|
     *  constructor for node that references another node
     * @param d object to be put in the node
     * @param n reference to another node
     */
    public ListNode(Object d, ListNode<E> n) {
    	data = d;
    	next = n;
    }
		    
    // access to fields
    /**
     * getter for the data in the node
     * @return the data in the node
     */
    public Object getData() {
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
    public void setData(Object ob) {
        data = ob;
    }
    
    /**
     * setter for the reference to the next node
     * @param n reference to the next node
     */
    public void setNext(ListNode<E> n) {
    	next = n;
    }
    
    /**
     * 
     * @param i number to compare node to
     * @return returns 1 if node is bigger, returns -1 if node is smaller, returns 0 if they're the same.
     */
    public int compareTo(int i) {
    	int number = ((int) data) - i;
    	
    	if (number==0) {
    		return 0;
    	} else {
    		return number/Math.abs(number);
    	}
    }
    
    /**
     * @return the data in the node as a string
     */
    public String toString() {
    	return data.toString();
    }
}
