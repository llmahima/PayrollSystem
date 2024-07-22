import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;

    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[ name" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }

}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWork, int hourlyRate) {
        super(name, id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWork;
    }
}

class PayrollSystem {
    private ArrayList<Employee> EmployeeList;

    public PayrollSystem() {
        EmployeeList = new ArrayList<>();
    }

    public void AddEmployee(Employee employee) {
        EmployeeList.add(employee);
    }

    public void RemoveEmployee(int id) {
        Employee EmployeeToRemove = null;

        for (Employee employee : EmployeeList) {
            if (employee.getId() == id) {
                EmployeeToRemove = employee;
                break;

            }
            if (EmployeeToRemove != null) {
                EmployeeList.remove(EmployeeToRemove);
            }
        }
    }

    public void displayEmployee() {
        for (Employee employee : EmployeeList) {
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        PayrollSystem pay = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee(" = mahima", 1, 70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("= Ashu", 2, 1, 100);
        pay.AddEmployee(emp1);
        pay.AddEmployee(emp2);
        System.out.println("initial remployee:");
        pay.displayEmployee();
        System.out.println("removing employee:");
        pay.RemoveEmployee(2);
        System.out.println("remaining employee detail:");
        pay.displayEmployee();

    }
}