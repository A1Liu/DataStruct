package doublyLinkedList;

import java.io.IOException;

public class Runner {
	
	public static void main(String[] args) {
		FileHandler albert = new FileHandler();

	try {
			albert.readFile("PersonList.txt");
		} catch (IOException e) {
			System.out.println("file wasn't valid!");
		}
		System.out.println(albert.list.toString());
	}
}