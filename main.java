import java.util.ArrayList;
import java.util.List;


abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    public String toString(){
        return "Employee Name: "+getName()+", ID: "+getId() + ", Salary: " + calculateSalary() + ".";
    }
}


/*  fullTimeEmployee */
class fullTimeEmployee extends Employee {
    
    private double monthlySalary;

    public fullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary(){
        return monthlySalary;
    }



}

/* partTimeEmployee */
class partTimeEmployee extends Employee{

    private int hoursWorked;

    private double hourlyRate;

    public partTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}   


// syntax of arrayList
// AccessModifier ArrayList<DataType> arr = new ArrayList<DataType>


/* payRollSystem */
class payRollSystem{

    // using Employee as datatype cuz ArrayList deals in Objects.
        private ArrayList<Employee> employeeList;
    
        public payRollSystem(){
            employeeList = new ArrayList<>();
        }
    
        public void addEmployee(Employee employee){
    
    // adding element in ArrayList
            employeeList.add(employee);
        }
    
        public void RemoveEmployee(int id){
            Employee employeeToRemove = null;
            for (Employee employee : employeeList) {
                if (employee.getId()==id) {
                    employeeToRemove=employee;
                    break;
                }
            }
            if (employeeToRemove != null) {
    // for removing use .remove();
                employeeList.remove(employeeToRemove);
            }
        }
    
        public void displayEmployees(){
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
            System.out.println();
        }
    }
    


public class Main{
    public static void main(String[] args) {
        // Code
        payRollSystem system = new payRollSystem();
        fullTimeEmployee FTE = new fullTimeEmployee("AKbar",  02, 600000);
        partTimeEmployee PTE = new partTimeEmployee("Ahsan", 125451, 05, 5000);

        // add employee elements
        system.addEmployee(FTE);
        system.addEmployee(PTE);

        // display all employees
        System.out.println("initial Employee Details: ");
        system.displayEmployees();
        // remove an employee
        System.out.println("Removing Employee");
        // one way: system.RemoveEmployee(PTE.getId());
        system.RemoveEmployee(02);
        System.out.println("\nAfter Removing Employee Details: ");
        system.displayEmployees();
    }
}
