package priorityQ;

import java.util.NoSuchElementException;

/**
 * <pre>
 * This class represents a priority queue that *should* preserve order.
 * 
 * It uses a priority queue that holds element containers.
 * These containers are labeled with the order that they came into the system.
 * 
 * </pre>
 * @author liu_albert
 *
 * @param <E>
 */
public class OrderedPQ<E extends Comparable<E>> implements Queue<E> {

	private int count;
	private PriorityQueue<PQueueElem<E>> pQ;
	
	
	OrderedPQ() {
		count = 0;
		pQ = new PriorityQueue<PQueueElem<E>>();
	}
	
	@Override
	public void enqueue(E e) {
		pQ.enqueue(new PQueueElem<E>(e,count++));
	}
	
	@Override
	public E dequeue() {
		return pQ.dequeue().getData();
	}

	@Override
	public E front() throws NoSuchElementException {
		return pQ.front().getData();
	}

	@Override
	public boolean isEmpty() {
		return pQ.isEmpty();
	}
	
}

/**
 * Container of elements in the ordered queue
 * @author liu_albert
 *
 * @param <E>
 */
class PQueueElem<E extends Comparable<E>> implements Comparable<PQueueElem<E>> {

	private final int order;
	
	private final E data;
	
	PQueueElem(E data, int order) {
		this.data = data;
		this.order = order;
	}
	
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	@Override
	public int compareTo(PQueueElem<E> o) {
		if (data.compareTo(o.getData()) == 0) {
			return order - o.getOrder();
		} else {
			return data.compareTo(o.getData());
		}
	}
	
	
	
}
