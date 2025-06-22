public class Employee {
    int empId;
    String name;
    String position;
    double salary;

    public Employee(int empId, String name, String position, double salary) {
        this.empId = empId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println(
                "Id: " + empId +
                "\tName: " + name +
                "\tPosition: " + position +
                "\tSalary: " + salary
        );
    }
}
