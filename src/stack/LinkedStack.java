package stack;

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
		return isEmpty()
				? null
				: stack.getFront().getData();
	}

	@Override
	public boolean isEmpty() {
		return stack.getFront()==null;
	}

}
