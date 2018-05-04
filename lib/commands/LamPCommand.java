package commands;

public class LamPCommand extends PCommand {

	Command command;
	
	public LamPCommand(Command command,String...elist) {
		super(elist);
		this.command = command;
	}
	
	@Override
	public void execute(Object... elist) {
		this.command.execute(elist);
	}

}
