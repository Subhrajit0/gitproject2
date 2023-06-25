import java.util.Scanner;

public class EmployeeView {

    private final EmployeeService employeeService;
    private final Scanner scanner;

    public EmployeeView() {

        employeeService = new EmployeeService();
        scanner = new Scanner(System.in);
    }

    public void home() {
        int choice;

        do {
            menuOption() ;
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;        
                case 0:
                    System.out.println("Thanks For Using app.");
                    continue;

                default:
                    System.out.println("Invalid Option !!!");
                    continue;
            }

        } while (choice != 0) ;
    }

    private void addEmployee() {

        Employee employee = getEmployeeDetails() ;
        employeeService.addEmployee(employee) ;
        System.out.println("Employee added.");
    }

    private void showEmployee() {

        var employees = employeeService.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee) ;
        }
    }

    private void deleteEmployee() {

        System.out.println("Enter Employee Id :") ;
        int employeeId = Integer.parseInt(scanner.nextLine()) ;

        employeeService.removeEmployee(employeeId) ;
        System.out.println("Employee deleted.") ;
    }

    private void updateEmployee() {

        employeeService.updateEmployee(getEmployeeDetails()) ;
        System.out.println("Employee Updated.") ;
    }

    private void menuOption() {

        System.out.println("Welcome to the employee Page");
        System.out.println("Press 1>> Add Employee");
        System.out.println("Press 2>> View Employee");
        System.out.println("Press 3>> Delete Employee");
        System.out.println("Press 4>> Update Employee");
        System.out.println("Press 0>> For Exit");
    }

    private Employee getEmployeeDetails() {

        System.out.println("Enter Employee Name :");
        String employeeName = scanner.nextLine() ;

        System.out.println("Enter Employee Id :");
        int employeeId = Integer.parseInt(scanner.nextLine()) ;

        System.out.println("Enter Employee Salary :");
        double employeeSalary = Double.parseDouble(scanner.nextLine()) ;

        return new Employee(employeeId, employeeName, employeeSalary) ;
    }

}
