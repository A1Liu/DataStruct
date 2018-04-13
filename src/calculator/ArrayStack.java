package calculator;

/**
 * This class is an Array-based implementation of the Stack Interface. It includes all stack methods and nothing else, and holds objects of type E
 * @author Alyer
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	private E[] stack;
	private int top;
	
	/**
	 * default size is 10
	 */
	public ArrayStack() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int length) {
		stack = (E[]) new Object[length];
		top = -1;
	}
	
	/**
	 * pops the top item from the stack
	 * @return the top item of the stack
	 */
	@Override
	public E pop() {
		return isEmpty()
				? null
				: stack[top--];
	}

	/**
	 * pushes an item to the top of the stack
	 * @param e the item to push
	 */
	@Override
	public void push(E e) {
		stack[++top] = e;
	}

	/**
	 * looks at the top item
	 * @return the top item in the stack
	 */
	@Override
	public E peek() {
		return isEmpty()
				? null
				: stack[top];
	}

	/**
	 * checks whether the stack is empty
	 * @return true if empty false if not
	 */
	@Override
	public boolean isEmpty() {
		return top==-1;
	}

}
