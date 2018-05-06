package priorityQ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import commands.Commands;
import runner.LoopRunner;

public class Runner extends LoopRunner {
	
	private static String FIRST = "John";
	private static String LAST = "Doe";
	
	private PriorityQueue<Patient> pQ;
	private Commands commands;
	private BufferedReader consoleLine;
	
	public static void main(String...args) {
		launch(args);
	}

	@Override
	public void atStart(Object... args) throws Exception {
		//Make the queue and command tree,
		pQ = new PriorityQueue<Patient>();
		commands = new Commands();
		commands.addGraph(readLines("in/priorityQCommands.txt"));

		commands.setCommand(1, new PatientCommand(pQ,"Integer") {@Override
			public void execute(Object... elist) {
				Integer priority = (Integer) elist[0];
				this.getObject().enqueue(new Patient(FIRST,LAST+getCounter(),priority));
				System.out.println("Default patient with PLevel: " + priority + " added.");
			}});
		
		commands.setCommand(2, new PatientCommand(pQ) {@Override
			public void execute(Object... elist) {
				System.out.println(this.getObject().dequeue().toString());
			}});
		
		commands.setCommand(3, new PatientCommand(pQ) {@Override
			public void execute(Object... elist) {
				System.out.println(this.getObject().front().toString());
			}});
		
		commands.setCommand(4, e -> this.quit());
		
		commands.setCommand(5, new PatientCommand(pQ,"String","String","Integer") {@Override
			public void execute(Object... elist) {
			String first = (String) elist[0];
			String last = (String) elist[1];
			Integer priority = (Integer) elist[2];
			getObject().enqueue(new Patient(first, last, priority));
			System.out.println("Patient '" + last + ", " + first + "' added, with PLevel: " + priority + ".");
		}});
		
		consoleLine = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void loop(Object... args) throws Exception {
		commands.input(consoleLine.readLine());
	}

	@Override
	public void atEnd(Object... args) throws Exception {
		System.out.println("Thanks for using the priorityQueue program!");
	}

	public static String[] readLines(String document) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(document));
		ArrayList<String> output = new ArrayList<String>();
		
		String inputString = reader.readLine();
		while(inputString != null) {
			output.add(inputString);
			inputString = reader.readLine();
		}
		reader.close();
		return output.toArray(new String[output.size()]);
	}

}
