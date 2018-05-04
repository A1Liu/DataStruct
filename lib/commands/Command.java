package commands;

public interface Command {

	/**
	 * Takes inputs for execute method.
	 * @param elist list of parameters that the user has inputted
	 */
	default void execute(String...elist) {
		execute((Object[]) elist);
	}
	
	/**
	 * The method to execute
	 * @param elist list of elements for the method to take as parameters
	 */
	public void execute(Object...elist);
	
}
