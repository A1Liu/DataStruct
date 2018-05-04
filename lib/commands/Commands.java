package commands;

import java.util.Arrays;

public class Commands {
	
	private CommandList comList;
	
	public Commands() {
		comList = new CommandList();
	}
	
	/**
	 * takes an input and executes a command based off of it. Should traverse as far as it can down the command tree and then take the rest of the input as parameters
	 * @param in the input string to take
	 */
	public void input(String in) {
		String[] stringList = in.split("\\s+");
		int counter = 0;
		ComTreeNode current = comList.getTree().getRoot();
		while(counter < stringList.length && current.containsChild(stringList[counter])) {
			current = current.getChild(stringList[counter]);
			counter++;
		}
		if (current == comList.getTree().getRoot()) {
			System.out.println("That's not a valid command!");
		} else if (current.getID() == null && current.getChildren().size() != 0) {
			String comPath = "";
			for (int x = 0; x < counter; x++) {
				comPath += stringList[x] + " ";
			}
			comPath = comPath.trim();
			if (counter < stringList.length) {
				System.out.println("'" + stringList[counter] + "' is not a recognized subcommand of " + comPath);	
			} else {
				System.out.println("'" + comPath + "' is not a complete command. Please pass more parameters.");
			}
		} else {
			comList.get(current.getID()).execute(Arrays.copyOfRange(stringList, counter, stringList.length));
		}
	}
	
	/**
	 * Creates a command tree from a formatted String array
	 * @param commands the array of strings that represents the command tree
	 */
	public void addGraph(String[] commands) {
		comList.addGraph(commands);
	}
	
	/**
	 * adds functionality to a point on the command tree. Only adds to points that already exist.
	 * @param label
	 * @param command
	 */
	public void setCommand(Integer label, Command command) {
		comList.addCommand(label, command);
	}
	
	/**
	 * adds an executable command to the command tree
	 * @param path 
	 * @param c
	 */
	public void addCommand(String[] path, Command command) {
		comList.addCommand(path, command);
	}
	
	public String toString() {
		return comList.toString();
	}
}
