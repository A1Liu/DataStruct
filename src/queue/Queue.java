package queue;

import java.util.NoSuchElementException;

public interface Queue<T> {

	/**
	 * Add an element to the queue
	 * @param t the element to add to the queue
	 */
	public void enqueue(T t);
	
	/**
	 * Check what the first element of the queue is
	 * @return The first element
	 * @throws NoSuchElementException if there is no first element
	 */
	public T front() throws NoSuchElementException;
	
	/**
	 * Takes the least recently placed item out of the queue
	 * @return The element that was just removed from the queue
	 * @throws NoSuchElementException if there is no element to remove
	 */
	public T dequeue() throws NoSuchElementException;
	
	/**
	 * Checks whether the queue is empty
	 * @return true if the queue is empty
	 */
	public boolean isEmpty();
	
	//public T[] dumpAll();
	
	//public void empty();
}
