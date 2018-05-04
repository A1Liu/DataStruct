package priorityQ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import commands.*;

public class Runner {
	
	public final static String FIRST = "Bill";
	public final static String LAST = "Bubkiss";
	private static boolean run = true;
	
	public static void main(String...strings ) throws IOException {
		PriorityQueue<Patient> pQ = new PriorityQueue<Patient>();
		
		Commands commands = new Commands();
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
		
		commands.setCommand(4, e -> Runner.quit());
		
		commands.setCommand(5, new PatientCommand(pQ,"String","String","Integer") {@Override
			public void execute(Object... elist) {
			String first = (String) elist[0];
			String last = (String) elist[1];
			Integer priority = (Integer) elist[2];
			getObject().enqueue(new Patient(first, last, priority));
			System.out.println("Patient " + last + ", " + first + " added, with PLevel: " + priority + ".");
		}});
		
		BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));
		String in;
		
		while (run) {
			in = consoleLine.readLine();
			try {
				commands.input(in);
			} catch (CommandException c) {
				System.out.println(c.getMessage());
			}
		}
	}
	
	public static void quit() {
		run = false;
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
