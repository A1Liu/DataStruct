package linkedList;
/*
Requirements:
Starting with an empty list of Integer references, allow the user to input additions and deletions to the list, keeping it in order.
The inputs should be checked through Exception Handling to ensure that they are Integers.
If a number to be added is already there, print “Already on List”, and do not add it.
If a number to be deleted is not on the list, print “Not on List”.
At any time, be able to print the list. If the list is empty, print “List is empty.”
You should also have a command to delete the entire list, and another command to quit the program.
Make sure to include JavaDoc commenting for all methods. Also, main( ) should be in its own .java file.
*/
public class Runner {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 1;
		LinkedList<Integer> albert = new LinkedList<Integer>();
		ListNode<Integer> james2 = new ListNode<Integer>(2);
		ListNode<Integer> james3 = new ListNode<Integer>(3);
		ListNode<Integer> james4 = new ListNode<Integer>(4);
		ListNode<Integer> james5 = new ListNode<Integer>(5);
		ListNode<Integer> james6 = new ListNode<Integer>(6);
		ListNode<Integer> james7 = new ListNode<Integer>(7);
		
		//albert.getFront().setNext(james2);
		james2.setNext(james3);
		james3.setNext(james4);
		james4.setNext(james5);
		james5.setNext(james6);
		james6.setNext(james7);
		
		//System.out.println(albert.findElement(7).toString());
		
		//albert.addElement(3);
		//albert.addElement(3);
		//System.out.println(james4.getNext().getData());
		
		System.out.println(albert.toString());
		
		
	
	}

}
