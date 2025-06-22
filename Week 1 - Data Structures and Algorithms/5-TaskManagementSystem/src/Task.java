public class Task {
    static int idCount = 101;
    private int taskID;
    private String taskName;
    private Status status;

    public Task(String taskName) {
        this.taskID = idCount++;
        this.taskName = taskName;
        this.status = Status.NOT_STARTED;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Task.idCount = idCount;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void display() {
        System.out.println("Id: " + taskID + "\tName: " + taskName + "\tStatus: " + status);
    }


}


