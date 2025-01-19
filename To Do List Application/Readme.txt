Todo List Representation:

We're using an ArrayList<String> to store the tasks. Each task is represented as a String.
Menu System:

The showMenu method prints out the options available to the user. The user can view tasks, add new tasks, remove tasks, or exit the application.
View Tasks:

The viewTasks method displays all tasks in the to-do list. If there are no tasks, it prints a message saying the list is empty.
Add a Task:

The addTask method prompts the user to enter a task description and adds it to the list.
Remove a Task:

The removeTask method asks the user for the task number to remove (1-based index). If the task number is valid, it removes the task from the list; otherwise, it shows an error message.
Loop:

The program uses a while(true) loop to continuously show the menu until the user chooses to exit.
