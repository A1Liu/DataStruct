package linkedList;

public class UserInputHandler {
	public LinkedList<Integer> list = new LinkedList<Integer>();

	/*
	 * codes:
	 * -4 exit remove/add mode
	 * -3 enter remove mode
	 * -2 enter add mode
	 * -1 exit the program
	 * 0 no error, don't print anything
	 * 1 Thats not a valid command! Type 'help' for a list of commands.
	 * 2 The number is already in there!
	 * 3 The number isn't in the list!
	 * 4 That's not an integer!
	 */
	
	/**
	 * A method to execute changes to the list based on user input
	 * @param input what the user has inputed
	 * @param mode what mode the console is currently in
	 * @return a code describing the status of the program (what mode, whether there's an error)
	 */
	public int execute(String input, int mode) {
		String[] userInput = input.split(" ");
		if(userInput.length == 0) {
			return 0;
		}
		switch(userInput[0]) {
		case "add":
			if(userInput.length > 1) {
				if(errorTrap(userInput[1])) {
					return list.addElement(Integer.parseInt(userInput[1]));
				} else {
					return 4;
				}
			} else {
				return -2;
			}
		case "rm":
			if(userInput.length > 1) {
				if(errorTrap(userInput[1])) {
					return list.remElement(Integer.parseInt(userInput[1]));
				} else if (userInput[1].equals("all")) {
					list.setFront(null);
					return 0;
				} else {
					return 4;
				}
			} else {
				return -3;
			}
		case "close":
			return -4;
		case "print":
			System.out.println(list.toString());
			return 0;
		case "help":
			System.out.println("add <number> ~ adds a number to the list."
					   	   + "\nadd          ~ goes into adding mode. Typing an integer will automatically add it to the list. "
						   + "\nrm <number>  ~ removes a number from the list." 
						   + "\nrm           ~ goes into remove mode. Typing an integer will automatically remove it from the list."
						   + "\nrm all       ~ delete the entire list." 
						   + "\nclose        ~ exits remove/add mode." 
						   + "\nprint        ~ prints out the list."
						   + "\nexit         ~ exit the program.");
			return 0;
		case "exit":
			return -1;
		case "reverse":
			list.reverseList(list.getFront());
			return 0;
		case "":
			return 0;
		default:
				if(mode == 2 && errorTrap(userInput[0])) {
					return list.addElement(Integer.parseInt(userInput[0]));
				} else if (mode == 3 & errorTrap(userInput[0])) {
					return list.remElement(Integer.parseInt(userInput[0]));
				} else return 1;
		}
	}
	
	/**
	 * a method to error trap
	 * @param input the user's input
	 * @return whether it is an integer. True for an integer, false for not
	 */
	public static boolean errorTrap(String input) {
		try {
			int number = Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
