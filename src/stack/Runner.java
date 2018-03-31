package stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static stack.StackUtil.readFile;
import static stack.PostFix.postCalc;

public class Runner {

	public static void main(String[] args) throws IOException {
		ArrayList<String> expressionList = readFile("PostFix.txt");
		ArrayList<Integer> evaluationList = new ArrayList<Integer>();
		
		for (int x = 0; x <expressionList.size(); x++) {
			evaluationList.add(postCalc(expressionList.get(x)));
			System.out.println(expressionList.get(x) + " = " + evaluationList.get(x));
		}
		
		
	}
	
	
	
	
	
	
	
}

class StackUtil {
	
	/**
	 * This is a utility class so the constructor is private
	 */
	private StackUtil() {
		
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
}
