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
		
		CommandList commands = new CommandList();
		commands.addGraph(readLines("in/priorityQCommands.txt"));
		commands.addCommand(1, new Com(pQ,"Integer") {@Override
			public void execute(Object... elist) {
				Integer priority = (Integer) elist[0];
				this.getObject().enqueue(new Patient(FIRST,LAST+getCounter(),priority));
			}});
		
		commands.addCommand(2, new Com(pQ) {@Override
			public void execute(Object... elist) {
				System.out.println(this.getObject().dequeue().toString());
			}});
		
		commands.addCommand(3, new Com(pQ) {@Override
			public void execute(Object... elist) {
				System.out.println(this.getObject().front().toString());
			}});
		
		commands.addCommand(4, e -> Runner.quit());
		
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

abstract class Com extends OCommand<PriorityQueue<Patient>> {
	
	private int counter;
	
	Com(PriorityQueue<Patient> priorityQueue, String... strings) {
		super(priorityQueue, strings);
		counter = 0;
	}
	
	public int getCounter() {
		return ++counter;
	}
}
