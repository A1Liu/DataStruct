package linkedList;

public class ListNode<E> {
 
	private Object data;
    private ListNode<E> next;

    public ListNode(Object d) {
		this(d, null);
	}

    public ListNode(Object d, ListNode<E> n) {
    	data = d;
    	next = n;
    }
		    
    // access to fields
    public Object getData() {
        return data;
    }

    public ListNode<E> getNext() {
    	return next;
    }

    // modify fields
    public void setData(Object ob) {
        data = ob;
    }
    
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
    
    public String toString() {
    	return data.toString();
    }
}
