package commands;

import java.util.Arrays;
import java.util.Hashtable;

public class CommandList {

	private ComTree comTree;//This is the data structure that holds the command hierarchy.
	private Hashtable<Integer,Command> coms;
	private int count;
	
	public CommandList(String[] graph) {
		this.addGraph(graph);
	}
	
	public CommandList() {
		comTree = new ComTree();
		coms = new Hashtable<Integer,Command>();
		coms.put(-1, new EmptyCommand());
		count = 0;
	}
	
	/**
	 * Takes formatted command graph, and creates a graph of commands
	 * 
	 * Format:
	 * ------------
	 * 
	Command1
		SubCommand1
			SubSubCommand1
				SubSubSubCommand1
			SubSubCommand2
		SubCommand2
			SubSubCommand1
	Command2
	Null
		HiddenCommand1
			HiddenSubCommand2
		HiddenCommand2
	 */
	
	
	/**
	 * Begins the recursion to create the command tree based off of a formatted String array
	 * @param commands the array of strings that represents the command tree
	 */
	public void addGraph(String[] commands) {
		for (int x = 0; x< commands.length; x++) {
			int y = commands[x].lastIndexOf('\t') + 1;
			commands[x] = y + commands[x].trim().toLowerCase() + " ";
		}
		
		addGraph(comTree.getRoot(),commands,0,commands.length-1);
		if (!comTree.getRoot().containsChild("help")) {
			while (coms.containsKey(++count)) {}
			comTree.getRoot().addChild("help", count);
			coms.put(count, elist -> System.out.println("--Empty Help Menu--"));
		}
	}
	
	/**
	 * Recursively creates a tree using a string array that represents the tree
	 * @param node The parent node of this recursive call
	 * @param commands the string array to take input from
	 * @param startIndex The initial index of this recursive call
	 * @param endIndex the stopping point of this recursive call
	 */
	private void addGraph(ComTreeNode node, String[] commands, int startIndex, int endIndex) {//Use this to specify object type requirements Class.forName("classStringName");
		int indent = Integer.parseInt(commands[startIndex].substring(0, 1));//what level of the tree are we at?
		
		for (int x = startIndex; x <= endIndex; x++) {//loop through all of the lines in the array. X represents the position the reader is at in the array.
			if(Integer.parseInt(commands[x].substring(0, 1)) == indent) {//If the line we're reading is at the level we're at, then let's add it to the tree
				//Does some trapping to change empty inputs and permutations of the word "null" to the null reference
				String command = (commands[x].substring(1).equals("null") || commands[x].substring(1).trim().equals("")) ? null : commands[x].substring(1).trim();
				if (command != null && command.indexOf(":") != -1) {//If the node name is in the format of nodeName:x where x is an integer, then we use x as the identifier for a command that should go there
					Integer id = null;
					try {
						id = Integer.parseInt((command.substring(command.indexOf(":") + 1)));
						coms.put(id, new EmptyCommand());//Adds a null entry to the hashtable, which acts as a placeholder for the executable command that should go there.
					} catch (NumberFormatException e) {
						
					} finally {
						command = command.substring(0, command.indexOf(":"));
						node.addChild(command,id);
					}
				} else {
					node.addChild(command);//Add it to the tree!
				}
				
				if (x < endIndex) {//If we're not at the end of this call's scope, then this could be a parent node
					if (Integer.parseInt(commands[x+1].substring(0, 1)) > indent) {//If this node is a parent node, call recursion
						ComTreeNode parent = node.getChild(command);//create a reference to the parent node
						int begin = x + 1;//the call should begin right below the parent's line
						
						while ( x < endIndex && Integer.parseInt(commands[x+1].substring(0, 1)) > indent) {
							x++;
						}//And end at the end of the scope of the recursion, or when the next item at this call's level is, whichever comes first.
						addGraph(parent, commands, begin,x);//enter recursion if necessary
					} else if (node.getChild(command).getID() == null){
						node.getChild(command).setID(-1);
					}
				} else if (node.getChild(command).getID() == null)
					node.getChild(command).setID(-1);
			}
		}
	}
	
	/**
	 * adds an executable command to the command tree
	 * @param path 
	 * @param c
	 */
	public void addCommand(String[] path, Command command) {
		while (!coms.containsKey(++count)) {}
		comTree.addPath(path,count);
	}
	
	/**
	 * adds functionality to a point on the command tree. Only adds to points that already exist.
	 * @param label
	 * @param command
	 */
	public void addCommand(Integer label, Command command) {
		if (label < 0)
			throw new IllegalArgumentException("Cannot have a negative ID.");
		coms.replace(label, command);
	}

	/**
	 * takes an input and executes a command based off of it. Should traverse as far as it can down the command tree and then take the rest of the input as parameters
	 * @param in the input string to take
	 */
	public void input(String in) {
		String[] stringList = in.split("\\s+");
		int counter = 0;
		ComTreeNode current = comTree.getRoot();
		while(counter < stringList.length && current.containsChild(stringList[counter])) {
			current = current.getChild(stringList[counter]);
			counter++;
		}
		if (current == comTree.getRoot()) {
			throw new CommandException("That's not a valid command!");
		} else if (current.getID() == null && current.getChildren().size() != 0) {
			String comPath = "";
			for (int x = 0; x < counter; x++) {
				comPath += stringList[x] + " ";
			}
			comPath = comPath.trim();
			if (counter < stringList.length) {
				throw new CommandException("'" + stringList[counter] + "' is not a recognized subcommand of " + comPath);	
			} else {
				throw new CommandException("'" + comPath + "' is not a complete command. Please pass more parameters.");
			}
		} else {
			coms.get(current.getID()).execute(Arrays.copyOfRange(stringList, counter, stringList.length));
		}
	}
	
	public String toString() {
		return comTree.toString().replaceFirst("\\n", "");
	}

}






