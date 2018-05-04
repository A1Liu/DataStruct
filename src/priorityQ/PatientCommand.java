package priorityQ;

import commands.OCommand;

abstract class PatientCommand extends OCommand<PriorityQueue<Patient>> {
	
	private int counter;
	
	PatientCommand(PriorityQueue<Patient> priorityQueue, String... strings) {
		super(priorityQueue, strings);
		counter = 0;
	}
	
	public int getCounter() {
		return ++counter;
	}
}