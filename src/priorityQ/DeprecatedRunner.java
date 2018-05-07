package priorityQ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import commands.*;

public class DeprecatedRunner {
	
	private final static String FIRST = "John";
	private final static String LAST = "Doe";
	private final static String ADD = "add";
	private final static String DEQUEUE = "dequeue";
	private final static String FRONT = "front";
	private final static String QUIT = "quit";
	private final static String DRIVER_NAME = "";
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


		while(run) {
			String[] in = inputLine.readLine().trim().split("\\s+");
			switch(in[0]) {
			case ADD:
				try{add(Arrays.copyOfRange(in, 1, in.length));}catch(IndexOutOfBoundsException e) {System.out.println(ADD + " needs at least 1 argument!");}
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
		}
	}
	
	/**
	 * Enqueues a patient to the priority queue.
	 * @param strings the inputs to take.
	 */
	private static void add(String ...strings) {
		int priority = 0;
		String first = FIRST;
		String last = LAST;
		boolean firstDone = false;
		for (int x = 0; x < strings.length; x++) {
			if (isNumber(strings[x])) {
				priority = Integer.parseInt(strings[0]);
			} else if (!firstDone) {
				first = strings[x];
				firstDone = true;
			} else {
				last = strings[x];
				x = strings.length;	
			}
		}
		pQ.enqueue(new Patient(first,last,priority));
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
