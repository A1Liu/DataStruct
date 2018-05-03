package priorityQ;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	ArrayList<E> elements;//element in index i has children in indices 2*i and 2*i + 1
	//lower indexes have entered first if values are equal
	
	public PriorityQueue() {
		elements = new ArrayList<E>();
	}
	
	@Override
	public void enqueue(E e) {
		
		if (isEmpty()) {
			elements.add(e);
			return;
		}
		int index = 0;
		while (index < elements.size() && e.compareTo(elements.get(index)) < 0) {
			
		}
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
