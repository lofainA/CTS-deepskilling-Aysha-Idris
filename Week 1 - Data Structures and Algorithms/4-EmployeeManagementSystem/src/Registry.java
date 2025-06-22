public class Registry {
    public static Employee[] employees = new Employee[100];
    static int index = -1;

    static {
        employees[0] = new Employee(101, "Mike Philip", "Team Lead", 40000);
        employees[1] = new Employee(102, "Sarah Jones", "Software Engineer", 35000);
        employees[2] = new Employee(103, "David Kim", "QA Analyst", 32000);
        employees[3] = new Employee(104, "Emma Watson", "Project Manager", 45000);
        index = 3;
    };

    public static boolean isFull() {
        if(index == employees.length) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty() {
        if(index == -1) {
            return true;
        }
        return false;
    }
}
