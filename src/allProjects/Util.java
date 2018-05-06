package allProjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

	/**
	 * This is a utility class so the constructor is private
	 */
	private Util() {
		
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
	
	/**
	 * Reads the file that is given and creates a list from it
	 * @param input name of file to be read
	 * @throws IOException Throws an exception if there's a problem reading the file
	 */
	public static ArrayList<String> readFile(String input) throws IOException {

		FileReader readFile = new FileReader(input); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		ArrayList<String> output = new ArrayList<String>();
		
		String inputString = inFile.readLine();
		while(inputString != null) {
			
			output.add(inputString);
			
			inputString = inFile.readLine();
		}
		inFile.close();
		return output;
	}
	
	/**
	 * Reads the lines of a document and returns the entire document as a String Array
	 * @param document name of document, or path
	 * @return text in document as a string array, each element is one line.
	 * @throws IOException if something goes wrong with inputs
	 */
	public static String[] readLines(String document) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(document));
		ArrayList<String> output = new ArrayList<String>();
		
		String inputString = reader.readLine();
		while(inputString != null) {
			output.add(inputString);
			inputString = reader.readLine();
		}
		reader.close();
		return output.toArray(new String[output.size()]);
	}
}
