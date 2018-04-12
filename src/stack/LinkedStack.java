package stack;

import java.util.LinkedList;

/**
 * This class is a Reference-based implementation of the Stack Interface. It includes all stack methods and nothing else, and holds objects of type E
 * @author Alyer
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

	private LinkedList<E> stack;
	
	public LinkedStack() {
		stack = new LinkedList<E>();
	}
	
	@Override
	public E pop() {
		if (!isEmpty()) {
			return stack.remove();
		}
		return null;
		
	}

	@Override
	public void push(E e) {
		stack.addFirst(e);
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
