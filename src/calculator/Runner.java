package calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

import queue.ArrayQueue;
import queue.LinkedQueue;

import static stack.InFix.*;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		LinkedQueue<String> input = linkedQueue("Calculator Expressions.txt");
		ArrayQueue<String> output = new ArrayQueue<String>(5);
		int counter = 0;
		String expression;
		while (!input.isEmpty()) {
			expression = "Problem " + counter + ":\n" + format(input.dequeue());
			try {
				output.enqueue(expression);
			} catch (NoSuchElementException e) {
				while(!output.isEmpty())
					System.out.println(output.dequeue());
			}
		}
		while(!output.isEmpty())
			System.out.println(output.dequeue());
	}
	
	/**
	 * method to take in expressions from a document and put them into a queue
	 * @param input input file name
	 * @throws IOException if something is wrong with the document
	 */
	private static LinkedQueue<String> linkedQueue(String input) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(input));
		String inputString = inFile.readLine();
		LinkedQueue<String> queue = new LinkedQueue<String>();
		while(inputString != null) {
			queue.enqueue(inputString);
			inputString = inFile.readLine();
		}
		inFile.close();
		return queue;
	}
	
	/**
	 * Returns a formatted entry in the final output, given an input expression
	 * @param inFix input infix expression
	 * @return formatted entry
	 */
	private static String format(String inFix) { 
		return 	"Infix Input:   " + inFix + "\n" +
				"PostFix Form:  " + toPostFix(inFix) + "\n" +
				"Simplest Form: " + inCalc(inFix);
	}
}
