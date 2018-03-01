# QuickSort Assignment
Due: Monday, February 12, 2018 at 8:00 am

In this assignment, you will be implementing a QuickSort and demonstrating its running time on various sets of data.  In doing this, you should choose your pivot using the median of three strategy.

In the QuickSort method, you should increment the comparison and swap counters in the correct locations of the algorithm so that all comparisons/swaps are counted.

In order to run this program, create a separate runner class (a second runner class, not the same one as your quadratic sorting algorithm).

Test your filling and sorting methods by creating a small array (10 elements will work), and ensuring that it fills and sorts correctly by outputting the array.

You will be making arrays of lengths 500, 5000, and 50000 through the use of three different objects in main() (you do not need to print out the contents once you have verified that the methods work).  For each array, you should fill and sort it three times (once with ascending starting values, once with descending starting values, and once with random starting values).

The numbers of comparisons and swaps should be outputted for each array (in a well-formatted output).

No comments or Exception Handling is required in this program.  Make sure to include the output of the program as a comment at the bottom of the runner class (you do not need to include any tests that printed out the entire array).