package stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static stack.PostFix.postCalc;
import static stack.InFix.inCalc;

/**
 * This class is the test harness for the classes in the Stack package.
 * It is used to test the calculators in the stack package
 * @author Alyer
 *
 */
public class Runner {
	
	/**
	 * Main method for Stack package, handles both InFix and PostFix inputs
	 * @param args main method default parameter
	 * @throws IOException If something is wrong with the file handling
	 */
	public static void main(String[] args) throws IOException {
		/**/
		System.out.println("InFix Calculator Outputs:");
		inFix("inFix.txt");
		/**/
		System.out.println("PostFix Calculator Outputs:");
		postFix("postFix.txt");
		/**/
	}

	/**
	 * main method for infix calculator
	 * @param args
	 * @throws IOException
	 */
	private static void inFix(String input) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(input));
		String inputString = inFile.readLine();
		int line = 1;
		while(inputString != null) {
			try {
				System.out.println(inputString + " = " + inCalc(inputString));
			} catch (IllegalArgumentException e) {
				System.out.println("Error on line "+ line + ": " + e.getMessage());
			}
			inputString = inFile.readLine();
			line++;
		}
		inFile.close();
	}
	
	/**
	 * Main method for postfix calculator
	 * @param args
	 * @throws IOException
	 */
	private static void postFix(String input) throws IOException {
		BufferedReader inFile = new BufferedReader(new FileReader(input));
		String inputString = inFile.readLine();
		int line = 1;
		while(inputString != null) {
			try {
				System.out.println(inputString + " = " + postCalc(inputString));
			} catch (IllegalArgumentException e) {
				System.out.println("Error on line "+ line + ": " + e.getMessage());
			}
			inputString = inFile.readLine();
			line++;
		}
		inFile.close();
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
