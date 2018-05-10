package priorityQ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Runner class.
 * @author liu_albert
 *
 */
public class Runner {
	
	private final static String FIRST = "John";
	private final static String LAST = "Doe";
	private final static String ADD = "add";
	private final static String DEQUEUE = "dequeue";
	private final static String FRONT = "front";
	private final static String QUIT = "quit";
	
	private final static String DRIVER_NAME = "in/PriorityQueueInput.txt";
	
	private static OrderedPQ<Patient> pQ;
	
	public static void main(String...strings ) throws IOException {
		boolean run = true;
		pQ = new OrderedPQ<Patient>();
		BufferedReader inputLine;
		try {
			inputLine = new BufferedReader(new FileReader(DRIVER_NAME));
		} catch (FileNotFoundException e) {
			inputLine = new BufferedReader(new InputStreamReader(System.in));
		}

		String in = inputLine.readLine().trim();
		while(run) {
			
			String[] input = in.trim().split("\\s+");
			switch(input[0].toLowerCase()) {
			case ADD:
				try{add(Arrays.copyOfRange(input, 1, input.length));}catch(IndexOutOfBoundsException e) {System.out.printf("'%s' needs at least 1 argument!%n",ADD);}
				break;
			case DEQUEUE:
				dequeue(input);
				break;
			case FRONT:
				System.out.println(pQ.isEmpty() ? "   No more patients in queue!" : "   Next patient in line is: " + pQ.front().toString());
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
		priority = priority == -1 ? 10 : priority;
		pQ.enqueue(new Patient(first,last,priority));
		System.out.printf("New Patient '%s, %s' added with PLevel: %d.%n", last, first, priority);
	}
	
	/**
	 * Dequeue from priority queue. 
	 * @param strings
	 */
	public static void dequeue(String...strings) {
		if (strings.length > 1 && isNumber(strings[1]))
			for (int x = 0; x < Integer.parseInt(strings[1]); x++) {
				System.out.println(pQ.isEmpty() ? "   No more patients in queue!" : "   Now seeing: " + pQ.dequeue().toString());
			}
		else {
			System.out.println(pQ.isEmpty() ? "   No more patients in queue!" : "   Now seeing: " + pQ.dequeue().toString());
		}
				
			
		
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
