package doublyLinkedList;
import java.io.*;

public class FileHandler {
	
	public DoublyLinkedList<Person> list;
	
	public FileHandler() {list = new DoublyLinkedList<Person>();}
	
	/**
	 * Parses a formatted input string into a Person object
	 * @param input String with first name, last name, and employer name
	 * @return a Person object that fits the description of the input string
	 */
	public Person rowHandler(String input) {
		String[] names = input.split(" ",3);
		Person james;
		if (names.length == 3)
			james = new Person(names[0], names[1], names[2]);
		else if (names.length == 2)
			james = new Person(names[0],names[1]);
		else return null;
		
		return james;
	}
	
	/**
	 * Reads the file that is given and creates a list from it
	 * @param input name of file to be read
	 * @throws IOException Throws an exception if there's a problem reading the file
	 */
	public void readFile(String input) throws IOException {

		FileReader readFile = new FileReader(input); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine();
		int line = 1;
		while(inputString != null) {
			if(!inputString.equals("") && rowHandler(inputString) != null) {
				list.addElement(rowHandler(inputString),rowHandler(inputString).getLastName().compareTo("m")<0);
			} else if (!inputString.equals("") && rowHandler(inputString) == null) {
				System.out.println("Skipped line " + line + ": incorrect number of arguments.");
			}
			
			inputString = inFile.readLine();
			line++;
		}
		inFile.close();
	}
	
}
