package binarySearchTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		BTree<Float> tree = new BTree<Float>();
		
		boolean on = true;
		boolean mode = true;
		String input;
		
		/*/BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));/**/
		
		FileReader readFile = new FileReader("in/BST.txt"); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		
		
		while (on) {
			/*/input = consoleLine.readLine();/**/
			/**/input = inFile.readLine();/**/
			String[] inArray = input.split("\\s+");
			if (input.equals("QUIT")) {
				on = false;
			} else if(inArray.length > 1) {
				if (inArray[0].equals("A") && isNumber(inArray[1])) {
					
					System.out.println(tree.add(Float.parseFloat(inArray[1]))
							? "Successfully added " + inArray[1] 
									: inArray[1] + " is already in the tree.");
					
				} else if (input.split(" ")[0].equals("D") && isNumber(inArray[1])) {
					System.out.println(tree.remove(Float.parseFloat(inArray[1]))
							? "Successfully removed " + inArray[1] 
									: inArray[1] + " is not in the tree.");
				} else {
					System.out.println("That's not a valid command!");
				}
			} else if (isNumber(inArray[0])) {
				if (mode) {
					System.out.println(tree.add(Float.parseFloat(inArray[0]))
							? "Successfully added " + inArray[0] 
									: inArray[0] + " is already in the tree.");
				} else {
					System.out.println(tree.remove(Float.parseFloat(inArray[0]))
							? "Successfully removed " + inArray[0] 
									: inArray[0] + " is not in the tree.");
				}
			}else if (inArray[0].equals("add")) {
				mode = true;
			} else if (inArray[0].equals("rm")) {
				mode = false;
			} else if (input.length() > 1){
				switch (input.charAt(1)) {
				case 'O':
					tree.postOrder();
					break;
				case 'N':
					tree.inOrder();
					break;
				case 'R':
					tree.preOrder();
					break;
				default:
					System.out.println("That's not a recognized command!");
				}
			} else {
				System.out.println("That's not a recognized command!");
			}
			
		}
		/**/inFile.close();/**/
	}
	
	/**
	 * checks if a string is an integer
	 * @param in string to test
	 * @return true if the string can be parsed to an integer
	 */
	public static boolean isNumber(String in) {
		try{
			Float.parseFloat(in);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
