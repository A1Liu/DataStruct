package priorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import commands.CommandList;

import static priorityQ.Runner.readLines;

public class Run extends allProjects.Runner {
	
	private static String FIRST = "Bob";
	private static String LAST = "Bubkiss";
	
	private PriorityQueue<Patient> pQ;
	private CommandList commands;
	private BufferedReader consoleLine;
	
	public static void main(String...args) {
		launch(args);
	}

	@Override
	public void start(String... args) throws InterruptedException, IOException {
		
		pQ = new PriorityQueue<Patient>();
			
		commands = new CommandList();
		commands.addGraph(readLines("in/priorityQCommands.txt"));
		commands.addCommand(1, new Com(pQ,"Integer") {@Override
			public void execute(Object... elist) {
				Integer priority = (Integer) elist[0];
				this.getObject().enqueue(new Patient(FIRST,LAST+getCounter(),priority));
				System.out.println("Default patient with PLevel: " + priority + " added.");
			}});
		
		commands.addCommand(2, new Com(pQ) {@Override
			public void execute(Object... elist) {
				System.out.println(this.getObject().dequeue().toString());
			}});
		
		commands.addCommand(3, new Com(pQ) {@Override
			public void execute(Object... elist) {
				System.out.println(this.getObject().front().toString());
			}});
		
		commands.addCommand(4, e -> this.quit());
		
		commands.addCommand(5, new Com(pQ,"String","String","Integer") {@Override
			public void execute(Object... elist) {
			String first = (String) elist[0];
			String last = (String) elist[1];
			Integer priority = (Integer) elist[2];
			getObject().enqueue(new Patient(first, last, priority));
			System.out.println("Patient " + last + ", " + first + " added, with PLevel: " + priority + ".");
		}});
		
		consoleLine = new BufferedReader(new InputStreamReader(System.in));
		
		// TODO Auto-generated method stub
		this.runLoop();
	}
	
	@Override
	public void runnable(Object... obs) {
		try {
			String in = consoleLine.readLine();
			commands.input(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
