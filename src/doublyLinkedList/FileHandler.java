package doublyLinkedList;
import java.io.*;

public class FileHandler {
	
	public DoublyLinkedList<Person> list = new DoublyLinkedList<Person>();
	
	public FileHandler() {
		
	}
	
	public Person rowHandler(String input) {
		String[] names = input.split(" ",3);
		if (names.length != 3) {
			return null;
		}
		
		Person james = new Person(names[0], names[1], names[2]);
		return james;
	}
	
	public void readFile(String input) throws IOException {

		FileReader readFile = new FileReader(input); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine();
		
		while(inputString != null) {
			if(!inputString.equals("") && rowHandler(inputString) != null) {
				list.addElement2(rowHandler(inputString),rowHandler(inputString).getLastName().compareTo("m")<0);
			}
				
			
			inputString = inFile.readLine();
		}
		
		inFile.close();
		
	}
	
}
