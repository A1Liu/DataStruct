package calculator;

import java.util.NoSuchElementException;

/**
 * This class represents an array-based implementation of the Queue interface.
 * @author Alyer
 *
 * @param <T> Data type of the elements being held in the queue
 */
public class ArrayQueue<T> implements Queue<T> {

	private T[] queue;
	private int count;
	private int front;
	private int back;
	private final int CAP;
	
	public ArrayQueue() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int l) {
		CAP = l;
		count = 0;
		queue = (T[]) new Object[l];
		front = 0;
		back = 0;
	}
	
	/**
	 * Add an element to the queue
	 * @param t the element to add to the queue
	 */
	@Override
	public void enqueue(T t) throws NoSuchElementException {
		if (count == CAP)
			throw new NoSuchElementException("Queue is full!");
		count++;
		queue[back] = t;
		back = (back + 1) % CAP;
	}

	/**
	 * Check what the first element of the queue is
	 * @return The first element
	 * @throws NoSuchElementException if there is no first element
	 */
	@Override
	public T front() throws NoSuchElementException {
		if (this.isEmpty())
			throw new NoSuchElementException("Queue is Empty!");
		return this.queue[front];
	}

	/**
	 * Takes the least recently placed item out of the queue
	 * @return The element that was just removed from the queue
	 * @throws NoSuchElementException if there is no element to remove
	 */
	@Override
	public T dequeue() throws NoSuchElementException {
		if (this.isEmpty())
			throw new NoSuchElementException("Queue is Empty!");
		count--;
		int prev = front;
		front = (front + 1) % CAP;
		return this.queue[prev];
	}

	/**
	 * Checks whether the queue is empty
	 * @return true if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	
	
}
