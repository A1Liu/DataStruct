package allProjects;

import linkedList.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));
		boolean turnedOn = true;
		int mode = 0;
		UserInputHandler handler = new UserInputHandler();
		String userInput = "";
		
		while(turnedOn) {
			try {
				userInput = consoleLine.readLine();
			} catch (IOException e) {
				System.out.println("There was a problem with that command. Try again, or type 'help' for a list of commands.");
			}
			
			switch(handler.execute(userInput,mode)) {
			case 1:
				System.out.println("Thats not a valid command! Type 'help' for a list of commands.");
				break;
			case 2:
				System.out.println("That number is already in the list!");
				break;
			case 3:
				System.out.println("That number isn't in the list!");
				break;
			case 4:
				System.out.println("That's not an integer!");
				break;
			case -1:
				turnedOn = false;
				System.out.println("Thanks for trying out the program!");
				break;
			case -2:
				mode = 2;
				System.out.println("You're now in 'add' mode. Typing numbers into the command line will add them to the list.");
				break;
			case -3:
				mode = 3;
				System.out.println("You're now in 'remove' mode. Typing numbers into the command line will remove them from the list.");
				break;
			case -4:
				mode = 0;
				System.out.println("You're now in standard mode.");
				break;
			default:
				break;
			}
		}
	}

}
