package queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * This class is the test harness for the queue package.
 * @author Alyer
 *
 */
public class Runner {
	
	public static void main(String[] args) throws IOException {
		/**/
		linkedQueue("Queue.txt");
		System.out.println();
		/**/
		arrayQueue("Queue.txt",10);
		/**/
	}
	
	/**
	 * main method to test linkedQueue class
	 * @param input input file name
	 * @throws IOException if something is wrong with the document
	 */
	private static void linkedQueue(String input) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(input));
		String inputString = inFile.readLine();
		LinkedQueue<String> queue = new LinkedQueue<String>();
		while(inputString != null) {
			queue.enqueue(inputString);
			inputString = inFile.readLine();
		}
		System.out.println("ArrayQueue Output:");
		while (!queue.isEmpty())
			System.out.println(queue.dequeue());
		inFile.close();
	}
	
	/**
	 * main method to test arrayQueue class
	 * @param input input file name
	 * @param length length of arrayQueue
	 * @throws IOException if somethign is wrong with the document
	 */
	private static void arrayQueue(String input, int length) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(input));
		String inputString = inFile.readLine();
		ArrayQueue<String> queue = new ArrayQueue<String>(length);
		boolean escape = true;
		while(inputString != null && escape) {
			try {
				queue.enqueue(inputString);
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				escape = false;
			}
			inputString = inFile.readLine();
		}
		System.out.println("ArrayQueue Output:");
		while (!queue.isEmpty())
			System.out.println(queue.dequeue());
		inFile.close();
	}
	
}
