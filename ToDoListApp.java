import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    // List to store the to-do tasks
    private static ArrayList<String> todoList = new ArrayList<>();

    // Method to display the menu options
    public static void showMenu() {
        System.out.println("\n------ To-Do List ------");
        System.out.println("1. View To-Do List");
        System.out.println("2. Add a Task");
        System.out.println("3. Remove a Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to view all the tasks in the list
    public static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("\nYour To-Do List is empty.");
        } else {
            System.out.println("\n--- To-Do List ---");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    // Method to add a new task
    public static void addTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added successfully!");
    }

    // Method to remove a task by its index
    public static void removeTask(Scanner scanner) {
        System.out.print("Enter the task number to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume the newline left by nextInt()

        if (taskNumber >= 1 && taskNumber <= todoList.size()) {
            todoList.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    viewTasks();
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return; // exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
