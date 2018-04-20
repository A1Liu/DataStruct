package binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		BTree<Float> tree = new BTree<Float>();
		
		BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));
		boolean on = true;
		boolean mode = true;
		String input;
		while (on) {
			input = consoleLine.readLine();
			String[] inArray = input.split("\\s+");
			if (input.equals("off")) {
				on = false;
			} else if(inArray.length > 1) {
				if (inArray[0].equals("add") && isNumber(inArray[1])) {
					
					System.out.println(tree.add(Float.parseFloat(inArray[1]))
							? "Successfully added " + inArray[1] 
									: inArray[1] + " is already in the tree.");
					
				} else if (input.split(" ")[0].equals("rm") && isNumber(inArray[1])) {
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
				case 'o':
					tree.postOrder();
					break;
				case 'n':
					tree.inOrder();
					break;
				case 'r':
					tree.preOrder();
					break;
				case 'm':
					tree.empty();
					System.out.println("Tree is now empty.");
					break;
				default:
					System.out.println("That's not a recognized command!");
				}
			} else {
				System.out.println("That's not a recognized command!");
			}
		}
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
