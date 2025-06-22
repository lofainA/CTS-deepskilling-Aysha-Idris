public class TaskManager {
    public static void main(String[] args) {
        LinkedList tasks = new LinkedList();

        tasks.addTask(new Task("Do laundry"));
        tasks.addTask(new Task("Complete assignment"));
        tasks.addTask(new Task("Buy Groceries"));
        tasks.displayTasks();

        Task searched = tasks.searchTaskById(102);
        System.out.println("\nSearched Item: ");
        searched.display();

        tasks.deleteTask(103);
        System.out.println("\nTasks After Deleting: ");
        tasks.displayTasks();

        tasks.changeStatus(102, Status.ONGOING);
        System.out.println("");
        tasks.displayTasks();
    }
}
