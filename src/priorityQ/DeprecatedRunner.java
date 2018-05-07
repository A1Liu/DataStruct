package priorityQ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DeprecatedRunner {
	
	private final static String FIRST = "John";
	private final static String LAST = "Doe";
	private final static String ADD = "add";
	private final static String DEQUEUE = "dequeue";
	private final static String FRONT = "front";
	private final static String QUIT = "quit";
	private final static String DRIVER_NAME = "in/priorityQueue.txt";
	private static PriorityQueue<Patient> pQ;
	private static boolean run = true;
	
	public static void main(String...strings ) throws IOException {
		pQ = new PriorityQueue<Patient>();
		BufferedReader inputLine;
		try {
			inputLine = new BufferedReader(new FileReader(DRIVER_NAME));
		} catch (FileNotFoundException e) {
			inputLine = new BufferedReader(new InputStreamReader(System.in));
		}

		String in = inputLine.readLine();
		while(run) {
			
			String[] input = in.trim().split("\\s+");
			switch(input[0]) {
			case ADD:
				try{add(Arrays.copyOfRange(input, 1, input.length));}catch(IndexOutOfBoundsException e) {System.out.println(ADD + " needs at least 1 argument!");}
				System.out.println(pQ.toString());
				break;
			case DEQUEUE:
				System.out.println(pQ.isEmpty() ? "No more patients in queue!" : "Now seeing: " + pQ.dequeue().toString());
				break;
			case FRONT:
				System.out.println(pQ.isEmpty() ? "No more patients in queue!" : "Next patient in line is: " + pQ.front().toString());
				break;
			case QUIT:
				run = false;
				break;
			default:
				System.out.println("That's not a valid comamnd!");
			}
			
			in = inputLine.readLine();
			if (run == true)
				run = in != null;
		}
	}
	
	/**
	 * Enqueues a patient to the priority queue.
	 * @param strings the inputs to take.
	 */
	private static void add(String ...strings) {
		int priority = -1;
		String first = FIRST;
		String last = LAST;
		boolean firstDone = false;
		boolean lastDone = false;
		for (int x = 0; x < strings.length; x++) {
			if (isNumber(strings[x]) && priority == -1) {
				priority = Integer.parseInt(strings[x]);
			} else if (!lastDone) {
				last = strings[x];
				lastDone = true;
			} else if (!firstDone) {
				first = strings[x];
				firstDone = true;
			}
		}
		priority = priority == -1 ? 0 : priority;
		pQ.enqueue(new Patient(first,last,priority));
		System.out.printf("New Patient '%s, %s' added with PLevel: %d.%n", last, first, priority);
	}
	
	/**
	 * checks if a string is an integer
	 * @param in string to test
	 * @return true if the string can be parsed to an integer
	 */
	public static boolean isNumber(String in) {
		try{
			Integer.parseInt(in);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
