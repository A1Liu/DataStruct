package priorityQ;

import commands.ObjParamC;;

abstract class PatientCommand extends ObjParamC<PriorityQueue<Patient>> {
	
	private int counter;
	
	PatientCommand(PriorityQueue<Patient> priorityQueue, String... strings) {
		super(priorityQueue, strings);
		counter = 0;
	}
	
	public int getCounter() {
		return ++counter;
	}
}