# Priority Queue Program

In this program you will be using a priority queue to hold the waiting list of an emergency room.  You will be creating your priority queue as a min-heap, where the highest priority patients get removed from the queue first.  Although you will be representing the priority queue as a heap, it should be stored in your program by using an ArrayList.  

Each element in the queue should hold a Patient reference.  The Patient class should have as data a first name, last name, and priority number.  The priority number is a number from 1 (highest priority) to 10 (lowest priority), representing the level of urgency that the patient be seen.

When patients are admitted to the emergency room, they are placed in the queue by order of priority.  In the case where priority numbers are equal, the patient that arrives first is placed before the patient that arrives after.  (This only applies when comparing two Patients with equal priority, there is no need to check the entire list each time a Patient is added.  Because of how we are representing our waiting list, it is still possible that Patients of equal priority that arrive later are dequeued earlier).  When Patients are dequeued, their name and priority number should be printed.

Your priority queue should implement the [Queue interface](https://github.com/A1Liu/DataStruct/blob/master/Assignment%20List/Queues.md) that you wrote in Unit 3, and should add no other public methods.  When submitting your assignment, please include your interface with the other files.  I will be providing a script to run the program with on the day that it is due.
