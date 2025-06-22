public class LinkedList {
    Node head;
    Node tail;

    public void addTask(Task task) {
        Node newTask = new Node(task);
        if(head == null) {
            head = tail = newTask;
        }
        tail.next = newTask;
        tail = newTask;
        System.out.println("\nTask ID " + tail.task.getTaskID() + " added!");
    }

    public Task searchTaskById(int id) {
        Node temp = head;
        while(temp != null) {
            if(temp.task.getTaskID() == id) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayTasks() {
        Node temp = head;
        while(temp != null) {
            temp.task.display();
            temp = temp.next;
        }
    }

    public void deleteTask(int id) {
        Node temp = head;
        Node prev = null;
        while(temp != null) {
            if(temp.task.getTaskID() == id) {
                prev.next = temp.next;
                System.out.println("\nDeleted task ID " + id);
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void changeStatus(int id, Status status) {
        Task task = searchTaskById(id);
        task.setStatus(status);
        System.out.println("\nTask ID " + tail.task.getTaskID() + " status changed to " + status.toString());
    }
}
