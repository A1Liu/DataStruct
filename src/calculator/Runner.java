package calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

import queue.ArrayQueue;
import queue.LinkedQueue;

import static calculator.InFix.*;

/**
 * This class is the runner class for the suite of classes that collectively make up the calculator application.
 * 
 * The app takes a document of loosely formatted infix expressions and outputs the expression's postfix form and evaluation.
 * 
 * The class also includes a utility method called "isNumber()"
 * 
 * @author Alyer
 *
 */
public class Runner {
	
	public static void main(String[] args) throws IOException {
		LinkedQueue<String> input = linkedQueue("Calculator Expressions.txt");
		ArrayQueue<String> output = new ArrayQueue<String>(5);
		int counter = 1;
		String expression;
		while (!input.isEmpty()) {
			expression = "Problem " + counter + ":\n" + format(input.dequeue()) + "\n";
			try {
				output.enqueue(expression);
			} catch (NoSuchElementException e) {
				while(!output.isEmpty())
					System.out.println(output.dequeue());
				output.enqueue(expression);
			}
			counter++;
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
		String expression = "	Infix Input:   " + inFix + "\n" +
							"	PostFix Form:  " + toPostFix(inFix) + "\n";
		try {
			expression += 	"	Simplest Form: " + inCalc(inFix);
		} catch (IllegalArgumentException e) {
			expression +=   "	Error: " + e.getMessage();
		}
		return expression;
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
	
/*
This is the Output of the program:

Problem 1:
	Infix Input:   9*(8-5)
	PostFix Form:  9 8 5 - * 
	Simplest Form: 27

Problem 2:
	Infix Input:   (9-8)*5
	PostFix Form:  9 8 - 5 * 
	Simplest Form: 5

Problem 3:
	Infix Input:   3/(4*(5-(2+1)))
	PostFix Form:  3 4 5 2 1 + - * / 
	Simplest Form: 0

Problem 4:
	Infix Input:   (9/3)/3
	PostFix Form:  9 3 / 3 / 
	Simplest Form: 1

Problem 5:
	Infix Input:   9/(3/3)
	PostFix Form:  9 3 3 / / 
	Simplest Form: 9

Problem 6:
	Infix Input:   ((2-(3+4))-1+4*3)/7
	PostFix Form:  2 3 4 + - 1 - 4 3 * + 7 / 
	Simplest Form: 0

Problem 7:
	Infix Input:   5-(4+3/(2*1))
	PostFix Form:  5 4 3 2 1 * / + - 
	Simplest Form: 0

Problem 8:
	Infix Input:   5/(4*(3-(2+1)))
	PostFix Form:  5 4 3 2 1 + - * / 
	Error: Can't divide by zero!

Problem 9:
	Infix Input:   (8+8*(4-2))*(3+5-6)
	PostFix Form:  8 8 4 2 - * + 3 5 + 6 - * 
	Simplest Form: 48
*/
}
