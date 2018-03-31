# Stacks Assignment

### Part 1: Stack Interface
Create a Stack interface based on the specifications discussed in class and in the videos.  
* It should include only the four methods presented in the notes and video (besides size( )).  
* The Interface should be generalized with a type parameter (<E>).  
* All JavaDoc commenting is required.

### Part 2: Postfix Calculator with Reference-Based Stack
For this part of the project, write a program that, using reference-based stacks, evaluates expressions in postfix notation.  
* The postfix expression will be a String consisting only of integers and mathematical operators (+, -, *, /), with each separated by a space.  Keep in mind, operators should not be pushed onto the stack.
* The program should be able to handle mathematical exceptions (such as division by zero) or realize when an expression was input incorrectly.
* Your program should implement the Stack interface you created in Part 1.  
* The class implementing the interface should add no other public methods beyond those detailed in the interface, and should contain no code specific to any task outside of a generalized stack. 
* All JavaDoc commenting is required.  
* You should also create a driver (text file) and a main( ) method to ensure that your program works.

### Part 3: Converting from Infix to Postfix with Array-Based Stack
For this part of the project, write a program that, using index-based stacks, converts infix expressions to postfix expressions.  

* The infix expression will be a String consisting only of numbers and mathematical operators (+, -, *, /, and ( )).  
* The postfix expression should be returned as a String, with spaces separating each number and/or operator, then sent to the postfix calculator you created for Part 2 of the project to be evaluated.
* Because no actual caluculations are being performed, there is no need to do any numeric calculations or conversions.  
* Also, because you are using an index-based stack, you will need to initialize the length of the stack when it is constructed.  Your program should implement the Stack interface you created in Part 1.  
* The class implementing the interface should add no other public methods beyond those detailed in the interface, and should contain no code specific to any task outside of a generalized stack. 
* All JavaDoc commenting is required.  
* You should also create a driver (text file) and a main( ) method to ensure that your program works.


