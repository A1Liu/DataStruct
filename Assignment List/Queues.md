## Part 1 - Queue Interface

Create a Queue interface based on the specifications discussed in class and in the videos.  It should include only the four methods presented in the notes and video (besides size( )).  The Interface should be generalized with a type prameter (\<E\>).  All JavaDoc commenting is required.  
  
## Part 2 - Reference-based Queue

For this part of the project, write a program that, using reference-based queues, reads in infix expressions as Strings, and stores each expression in a node in the queue.  The infix expressions will be Strings consisting only of numbers and mathematical operators (+, -, *, /, and ( )).  Once all expressions are read in and stored in the queue, they should be sent one at a time to the postifx conversion program you created the stacks assignment.

Your program should implement the Queue interface you created in Part 1.  The class implementing the interface should add no other public methods beyond those detailed in the interface, and should contain no code specific to any task outside of a generalized queue. 

All JavaDoc commenting is required.  You should also create a driver (text file) and a main( ) method to ensure that your program works.  

## Part 3 - Index-based Queue

For this part of the project, write a program that, using index-based queues, holds the output for the complete project.  Each problem should be one element in the output queue, with the output including the original infix expression, the postfix expression, and the solution in a readable format.  No output should be printed until the output queue has been filled or all calculations have been completed.

Because you are using an index-based queue, you will need to initialize the length of the queue when it is constructed.  For the purpose of this assignment, the length of the queue should be 5.  If the queue is filled, each time a new value is to be added to it, one will need to first be removed and printed before adding another.

Your program should implement the Queue interface you created in Part 1.  The class implementing the interface should add no other public methods beyond those detailed in the interface, and should contain no code specific to any task outside of a generalized queue.

All JavaDoc commenting is required.  You should also create a driver (text file) and a main( ) method to ensure that your program works.  


