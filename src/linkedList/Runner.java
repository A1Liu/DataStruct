package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	
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
				System.out.println("You're now in 'add' mode. Typing numbers into the command line will now add them to the list.");
				break;
			case -3:
				mode = 3;
				System.out.println("You're now in 'remove' mode. Typing numbers into the command line will now remove them from the list.");
				break;
			case -4:
				mode = 0;
				System.out.println("You're now in standard mode. To add or remove elements from the list, use the 'add' and 'rm' commands.");
				break;
			default:
				break;
			}
		}
	}
	
	/*
	 * Run 1:
a 15
a 10
a 25
d 12
That number isn't in the list!
a one
That's not an integer!
a 5
a 20
a 15
That number is already in the list!
d 30
That number isn't in the list!
a 17
a 16
a 10
That number is already in the list!
d 15
d x
That's not an integer!
d 10
p
[5, 16, 17, 20, 25]
a 4
a 0
d 25
d 20
d -4
That number isn't in the list!
a 18
a 5
That number is already in the list!
a 19
d 0
d 4
p
[5, 16, 17, 18, 19]
d all
p
[Empty List]
d 10
That number isn't in the list!
a 5
a 10
a 7
p
[5, 7, 10]
exit
Thanks for trying out the program!
	 */
	
	
	/*
	 * Run 2:
a 5
d 5
p
[Empty List]
exit
Thanks for trying out the program!
	 */

}
