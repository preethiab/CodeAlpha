import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee1> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee1 employee) {
        employees.add(employee);
    }

    public List<Employee1> getEmployees() {
        return employees;
    }

    public double calculateSalary(Employee1 employee, double hoursWorked) {
        return employee.getHourlyRate() * hoursWorked;
    }
}