package priorityQ;

public class Patient {
	private String first;
	private String last;
	private int priority;
	
	public Patient(String first, String last, int priority) {
		this.first = first;
		this.last = last;
		this.priority = priority;
	}

	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
