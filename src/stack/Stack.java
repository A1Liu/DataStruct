package stack;

public interface Stack<E> {

	/**
	 * pops the top item from the stack
	 * @return the top item
	 */
	public E pop();

	/**
	 * pushes an item to the top of the stack
	 * @param e the item to push
	 */
	public void push(E e);
	
	/**
	 * looks at the top item
	 * @return the top item
	 */
	public E peek();
	
	/**
	 * checks whether the stack is empty
	 * @return true if empty false if not
	 */
	public boolean isEmpty();
	
}
