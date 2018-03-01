# Linked List Program Plan

### User Input

Commands: |
-- | --
Add <number>| adds a number to the list
adMode| goes into adding mode. Escape character is esc, or use a command to escape
rm <number>|remmoves a number from the list
reMode| goes into remove mode. Escape character is esc, or use a command to escape
  
Starting with an empty list of Integer references, allow the user to input additions and deletions to the list, keeping it in order.

The inputs should be checked through Exception Handling to ensure that they are Integers.

If a number to be added is already there, print “Already on List”, and do not add it.

If a number to be deleted is not on the list, print “Not on List”.

At any time, be able to print the list. If the list is empty, print “List is empty.”

You should also have a command to delete the entire list, and another command to quit the program.

Make sure to include JavaDoc commenting for all methods. Also, main( ) should be in its own .java file.

