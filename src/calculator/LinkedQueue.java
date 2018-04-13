package calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class represents a reference-based implementation of the Queue interface
 * @author Alyer
 *
 * @param <T> The data type of the elements being held in the queue
 */
public class LinkedQueue<T> implements Queue<T> {

	private LinkedList<T> queue;
	
	public LinkedQueue() {
		queue = new LinkedList<T>();
	}
	
	/**
	 * Add an element to the queue
	 * @param t the element to add to the queue
	 */
	@Override
	public void enqueue(T t) {
		queue.addFirst(t);
	}

	/**
	 * Check what the first element of the queue is
	 * @return The first element
	 * @throws NoSuchElementException if there is no first element
	 */
	@Override
	public T front() throws NoSuchElementException {
		if (!this.isEmpty())
			return queue.getLast();
		throw new NoSuchElementException("Queue is Empty!");
	}

	/**
	 * Takes the least recently placed item out of the queue
	 * @return The element that was just removed from the queue
	 * @throws NoSuchElementException if there is no element to remove
	 */
	@Override
	public T dequeue() throws NoSuchElementException {
		if (!this.isEmpty()) {
			return queue.removeLast();
		}
		throw new NoSuchElementException("Queue is Empty!");
	}

	/**
	 * Checks whether the queue is empty
	 * @return true if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	
	
}
