package doublyLinkedList;

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
add
You're now in 'add' mode. Typing numbers into the command line will now add them to the list.
15
10
25
rm 12
That number isn't in the list!
add one
That's not an integer!
5
20
15
That number is already in the list!
rm 30
That number isn't in the list!
17
16
10
That number is already in the list!
rm
You're now in 'remove' mode. Typing numbers into the command line will now remove them from the list.
15
rm x
That's not an integer!
10
print
[5, 16, 17, 20, 25]
add
You're now in 'add' mode. Typing numbers into the command line will now add them to the list.
4
0
rm 25
rm 20
rm -4
That number isn't in the list!
18
5
That number is already in the list!
19
rm 0
rm 4
print
[5, 16, 17, 18, 19]
rm all
print
[Empty List]
rm 10
That number isn't in the list!
5
10
7
print
[5, 7, 10]
exit
Thanks for trying out the program!
	 */
	
	
	/*
	 * Run 2:
add 5
rm 5
print
[Empty List]
exit
Thanks for trying out the program!
	 */

}
