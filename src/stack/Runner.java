package stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static stack.StackUtil.readFile;
import static stack.PostFix.postCalc;
import static stack.InFix.inCalc;

public class Runner {

	public static void main(String[] args) throws IOException {
		ArrayList<String> expressionList = readFile("InFix.txt");
		int y;
		for (int x = 0;x < expressionList.size(); x++) {
			try {
				System.out.println(expressionList.get(x) + " = " + inCalc(expressionList.get(x)));
			} catch (IllegalArgumentException e) {
				System.out.println("Error on line "+ (x + 1) + ": " + e.getMessage());
			}
		}
	}
	
	public static void main(String args) throws IOException {
		ArrayList<String> expressionList = readFile("PostFix.txt");
		int y;
		for (int x = 0;x < expressionList.size(); x++) {
			try {
				System.out.println(expressionList.get(x) + " = " + postCalc(expressionList.get(x)));
			} catch (IllegalArgumentException e) {
				System.out.println("Error on line "+ (x + 1) + ": " + e.getMessage());
			}
		}
		
		
		
	}	
}
