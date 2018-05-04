package commands;

/**
 * This class represents a command that outputs a guide to a command tree.
 * @author aliu
 *
 */
public class HelpC implements Command {

	private ComTree commands;
	
	public HelpC(ComTree commands) {
		this.commands = commands;
	}
	
	
	
	@Override
	public void execute(Object... elist) {
		
		String[] path = (String[]) elist;
		boolean done = false;
		boolean listSubs = false;
		ComTreeNode current = commands.getRoot();
		for (String element : path) {
			if (!done) {
				if (current.containsChild(element))
					current = current.getChild(element);
				else if (element.endsWith("...") && current.containsChild(element.replace("...", ""))) {
					current = current.getChild(element.replace("...", ""));
					listSubs = true;
					done = true;
				} else if (element.equals("...")) {
					listSubs = true;
					done = true;
				}
			}
			else	{
				done = true;
			}
		}
		
		if (current == commands.getRoot()) {
			System.out.println("Command List: ");
			for (ComTreeNode node : current.getChildren()) {
				String name = node.getName();
				String help = node.getHelp() == null ? "'" + node.getName() + "' command." : node.getHelp();
				System.out.printf("  %8s %s%n",name+":",help);
			}
		} else if (!listSubs) {
			String name = current.getName();
			String help = current.getHelp() == null ? "'" + current.getName() + "' command." : current.getHelp();
			System.out.printf("%s %s%n",name+":",help);
			System.out.println("Type '...' at the end of the last command to get a list of available subcommands, along with help for each.");
		} else {
			System.out.printf("Subcommands of'%s': %n",current.getName());
			for (ComTreeNode node : current.getChildren()) {
				String name = node.getName();
				String help = node.getHelp() == null ? "'" + node.getName() + "' command." : node.getHelp();
				System.out.printf("  %8s %s%n",name+":",help);
			}
		}

		
		
		
	}

}
