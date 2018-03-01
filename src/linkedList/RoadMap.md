# Linked List Program Plan

### User Input
Command | Description
-- | --
Add <number> | adds a number to the list
adMode | goes into adding mode. Escape character is esc, or use a command to escape
rm <number> | remmoves a number from the list
reMode | goes into remove mode. Escape character is esc, or use a command to escape
rm all | delete the entire listprint | prints out the list
exit | escape the program

### User Input Handler
General input
1. Split string by spaces
2. Check what the first word is
3. Check what the second word is and/or whether the args are correct
4. Return void/perform action

Add/Remove mode
1. Check whether input is integer
2. Perform action on list

### Linked List Handler
Method | Returns |  Description
-|-|-
checkNum(int number)|ListNode<E>|Checks to see if number is in the list.
deleteAll()|void|Deletes all the elements
delete(int number)|void|Deletes element from the list that matches number
add(int number)|void|Adds number to the list
toString()|String|Returns the list of all elements
