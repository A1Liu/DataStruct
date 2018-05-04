package commands;

public class EmptyCommand extends PCommand {

	public EmptyCommand() {
		
	}

	@Override
	public void execute(Object... elist) {
		throw new CommandConfigurationException("The command doesn't have an associated executable task.");
	}

}
