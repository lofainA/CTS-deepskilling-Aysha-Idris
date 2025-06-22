public class EmployeeManager {
    public void addEmployee(Employee emp) {
        if(Registry.isFull()) {
            System.out.println("Registry full!");
            return;
        }
        Registry.employees[Registry.index + 1] = emp;
        Registry.index++;
        System.out.println("Added employee id " + Registry.employees[Registry.index].empId);
    }

    public void deleteEmployee(int id) {
        if(Registry.isEmpty()) {
            System.out.println("Registry empty..");
            return;
        }
        int empIndex = 0;
        for(int i = 0; i < Registry.index; i++) {
            if(Registry.employees[i].empId == id) {
                empIndex = i;
                break;
            }
        }
        for(int i = empIndex; i < Registry.index; i++) {
            Registry.employees[empIndex] = Registry.employees[empIndex+1];
            empIndex++;
        }
        Registry.index--;
        System.out.println("Deleted employee id " + id);
    }

    public Employee searchEmployee(int id) {
        for(Employee emp: Registry.employees) {
            if(emp == null) {
                return null;
            }
            if(emp.empId == id) {
                return emp;
            }
        }
        return null;
    }

    public void displayEmployee(int id) {
        for(Employee emp: Registry.employees) {
            if(emp == null) {
                System.out.println("Employee not found!");
                return;
            }
            if(emp.empId == id) {
                emp.display();
                return;
            }
        }
    }

    public void displayAllEmployees() {
        for(int i = 0; i <= Registry.index; i++) {
            Registry.employees[i].display();
        }
    }
}
