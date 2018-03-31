package stack;

/**
 * This class is an Array-based implementation of the Stack Interface. It includes all stack methods and nothing else, and holds objects of type E
 * @author Alyer
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	private E[] stack;
	private int top;
	
	
	public ArrayStack() {
		this(10);
	}
	
	public ArrayStack(int length) {
		stack = (E[]) new Object[length];
		top = -1;
	}
	
	
	@Override
	public E pop() {
		return isEmpty()
				? null
				: stack[top--];
	}

	@Override
	public void push(E e) {
		stack[++top] = e;
	}

	@Override
	public E peek() {
		return isEmpty()
				? null
				: stack[top];
	}


	@Override
	public boolean isEmpty() {
		return top==-1;
	}

}
