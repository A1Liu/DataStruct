package stack;

/**
 * This class is a Reference-based implementation of the Stack Interface. It includes all stack methods and nothing else, and holds objects of type E
 * @author Alyer
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {
	
	private Node<E> front;
	
	public LinkedStack() {
		front = null;
	}
	
	/**
	 * pops the top item from the stack
	 * @return the top item of the stack
	 */
	@Override
	public E pop() {
		if (!isEmpty()) {
			E data = front.getData();
			front = front.getNext();
			return data;
		}
		return null;
		
	}

	/**
	 * pushes an item to the top of the stack
	 * @param e the item to push
	 */
	@Override
	public void push(E e) {
		front = new Node<E>(e,front);
	}

	/**
	 * looks at the top item
	 * @return the top item in the stack
	 */
	@Override
	public E peek() {
		return isEmpty()
				? null
				: front.getData();
	}
	
	/**
	 * checks whether the stack is empty
	 * @return true if empty false if not
	 */
	@Override
	public boolean isEmpty() {
		return front == null;
	}

}

class Node<T> {
	
	private T data;
	private Node<T> next;
	
	public Node(T t) {
		this(t, null);
	}
	
	public Node(T t, Node<T> n) {
		data = t;
		next = n;
	}
	
	/**
	 * getter for data
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * setter for data
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * getter for next node
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * setter for next node
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
}
