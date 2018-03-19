package stack;

import linkedList.LinkedList;
import linkedList.ListNode;

public class LinkedStack<E extends Comparable<E>> implements Stack<E> {

	private LinkedList<E> stack;
	
	public LinkedStack() {
		stack = new LinkedList<E>();
	}
	
	@Override
	public E pop() {
		if (stack.getFront()!=null) {
			E e = stack.getFront().getData();
			stack.setFront(stack.getFront().getNext());
			return e;
		}
		return null;
		
	}

	@Override
	public void push(E e) {
		ListNode<E> l = new ListNode<E>(e,stack.getFront());
		stack.setFront(l);
	}

	@Override
	public E peek() {
		return stack.getFront().getData();
	}

	@Override
	public boolean isEmpty() {
		return peek()==null;
	}

}
