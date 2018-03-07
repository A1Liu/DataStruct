package doublyLinkedList;

import java.io.IOException;

public class Runner {
	
	public static void main(String[] args) {
		FileHandler albert = new FileHandler();
		
		System.out.println();
		
		try {
			albert.readFile("input.txt");
		} catch (IOException e) {
			System.out.println("file wasn't valid!");
		}
		
		albert.list.toString();
	}
}