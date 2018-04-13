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
	
	@Override
	public void enqueue(T t) {
		queue.addFirst(t);
	}

	@Override
	public T front() throws NoSuchElementException {
		if (!this.isEmpty())
			return queue.getLast();
		throw new NoSuchElementException("Queue is Empty!");
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		if (!this.isEmpty()) {
			return queue.removeLast();
		}
		throw new NoSuchElementException("Queue is Empty!");
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	
	
}
