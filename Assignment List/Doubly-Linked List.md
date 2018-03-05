# Doubly Linked List Program
Due: Friday, March 9, 2018 at 9:30 am

Using your original Linked List program, make the modifications needed for a version of a doubly linked list. This will require modifiying the ListNode class and the LinkedList class.
* In this program, you will only have to add to the list, not delete from it, so you do not need to modify any deletion code.
* Now your linked list will hold an alphabetized list of Person objects. You will need to create a Person class that has as instance data a first name, last name, and employer.
* Your new runner class should read in a text file of people and add the Person objects to the array in alphabetical order by last name.
* The alphabetized list should then be printed.

### Things to be aware of:

* The text file will be in the following format: FirstName LastName Employer
* No changes can be made to the ListNode or LinkedList classes to make them specific to Person objects (the only changes made will be to add the double links)
* Since you are now working with a doubly linked list, it would be more efficient (and required for this program) to add the first half of the alphabet by starting at the front of the list, and the last half of the alphabet by starting at the back of the list
