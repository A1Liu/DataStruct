package stack;
import java.io.IOException;
import java.util.ArrayList;

import static stack.StackUtil.readFile;
import static stack.PostFix.postCalc;
import static stack.InFix.inCalc;

public class Runner {

	/**
	 * main method for infix calculator
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<String> expressionList = readFile("InFix.txt");
		for (int x = 0;x < expressionList.size(); x++) {
			try {
				System.out.println(expressionList.get(x) + " = " + inCalc(expressionList.get(x)));
			} catch (IllegalArgumentException e) {
				System.out.println("Error on line "+ (x + 1) + ": " + e.getMessage());
			}
		}
	}
	
	/**
	 * Main method for postfix calculator
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args) throws IOException {
		ArrayList<String> expressionList = readFile("PostFix.txt");
		for (int x = 0;x < expressionList.size(); x++) {
			try {
				System.out.println(expressionList.get(x) + " = " + postCalc(expressionList.get(x)));
			} catch (IllegalArgumentException e) {
				System.out.println("Error on line "+ (x + 1) + ": " + e.getMessage());
			}
		}
	}
	
}
