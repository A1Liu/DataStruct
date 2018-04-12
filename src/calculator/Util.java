package calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import queue.LinkedQueue;

public class Util {
	private Util() {
		
	}
	
	/**
	 * Reads the file that is given and creates a list from it
	 * @param input name of file to be read
	 * @throws IOException Throws an exception if there's a problem reading the file
	 */
	public static LinkedQueue<String> readFile(String input) throws IOException {

		FileReader readFile = new FileReader(input); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		LinkedQueue<String> output = new LinkedQueue<String>();
		
		String inputString = inFile.readLine();
		while(inputString != null) {
			
			output.enqueue(inputString);
			
			inputString = inFile.readLine();
		}
		inFile.close();
		return output;
	}
}
