package priorityQ;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueue<E> implements Queue<E> {

	ArrayList<E> elements;//element in index i has children in indices 2*i and 2*i + 1
	
	public PriorityQueue() {
		elements = new ArrayList<E>();
	}
	
	@Override
	public void enqueue(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E front() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
