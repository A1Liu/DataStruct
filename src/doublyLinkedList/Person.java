package doublyLinkedList;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private String employer;
	
	/**
	 * empty constructor
	 */
	public Person() {
		this(null, null, null);
	}
	
	/**
	 * default constructor
	 * @param f first name
	 * @param l last name
	 * @param e employer
	 */
	public Person(String f, String l, String e) {
		firstName = f;
		lastName = l;
		employer = e;
	}
	
	/**
	 * constructor without employer
	 * @param f
	 * @param l
	 */
	public Person(String f, String l) {
		firstName = f;
		lastName = l;
		employer = "Unemployed or Unknown";
	}

	/**
	 * getter for first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setter for first name
	 * @param firstName new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getter for last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setter for last name
	 * @param lastName new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getter for employer
	 * @return employer
	 */
	public String getEmployer() {
		return employer;
	}

	/**
	 * setter for employer
	 * @param employer new employer
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person other = ((Person) o);
			if (other.getEmployer().equals(employer) && other.getFirstName().equals(firstName) && other.getLastName().equals(lastName))
				return true;
		}
		return false;
	}
	
	/**
	 * compareTo method for Person objects
	 * @param e the person to compare to
	 * @return an integer that describes the displacement of this person's last name relative to another person's
	 */
	public int compareTo(Person e) {
		int compare = this.getLastName().compareTo(e.getLastName());
		if (compare == 0) {
			return this.getFirstName().compareTo(e.getFirstName());
		} else return compare;
	}
	
	/**
	 * toString method for Person objects
	 * @return a string describing the person
	 */
	public String toString() {
		return "Name:       " + firstName + " " + lastName + 
			 "\n  Employer: " + employer;
	}
	
}
