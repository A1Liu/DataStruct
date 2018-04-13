package calculator;

import java.util.LinkedList;

/**
 * This class is a Reference-based implementation of the Stack Interface. It includes all stack methods and nothing else, and holds objects of type E
 * @author Alyer
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

	private LinkedList<E> stack;
	private StackNode<E> front;
	
	public LinkedStack() {
		front = null;
		stack = new LinkedList<E>();
	}
	
	@Override
	public E pop() {
		if (!isEmpty()) {
			E data = front.getData();
			front = front.getNext();
			return data;
		}
		return null;
		
	}

	@Override
	public void push(E e) {
		front = new StackNode<E>(e,front);
		
	}

	@Override
	public E peek() {
		return isEmpty()
				? null
				: stack.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}

class StackNode<T> {
	
	private T data;
	private StackNode<T> next;
	
	public StackNode(T t) {
		this(t, null);
	}
	
	public StackNode(T t, StackNode<T> n) {
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
	public StackNode<T> getNext() {
		return next;
	}

	/**
	 * setter for next node
	 * @param next the next to set
	 */
	public void setNext(StackNode<T> next) {
		this.next = next;
	}
	
}
