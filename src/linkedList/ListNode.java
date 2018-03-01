package linkedList;

public class ListNode {

	private Object data;
    private ListNode next;

    public ListNode(Object d) {
		this(d, null);
	}

    public ListNode(Object d, ListNode n) {
    	data = d;
    	next = n;
    }
		    
    // access to fields
    public Object getData() {
        return data;
    }

    public ListNode getNext() {
    	return next;
    }

    // modify fields
    public void setData(Object ob) {
        data = ob;
    }
    
    public void setNext(ListNode n) {
    	next = n;
    }
}
