public class EmployeeDriver {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();

        em.addEmployee(new Employee(105, "Noah Davis", "Business Analyst", 39000));
        em.addEmployee(new Employee(106, "Isabella Moore", "HR Specialist", 30000));

        Employee emp = em.searchEmployee(102);
        emp.display();

        em.displayEmployee(104);

        em.deleteEmployee(101);
        em.deleteEmployee(103);

        em.displayAllEmployees();
    }
}
