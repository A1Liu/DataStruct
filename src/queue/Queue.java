package queue;

import java.util.NoSuchElementException;

public interface Queue<T> {

	public void enqueue();
	
	public T front() throws NoSuchElementException;
	
	public T dequeue() throws NoSuchElementException;
	
	public boolean isEmpty();
}
