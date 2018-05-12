package doublyLinkedList;

import java.io.IOException;

public class Runner {
	
	public static void main(String[] args) {
		FileHandler files = new FileHandler();

	try {
			files.readFile("in/PersonList.txt");
		} catch (IOException e) {
			System.out.println("file wasn't valid!");
		}
		System.out.println(files.getList().toString());
	}
}