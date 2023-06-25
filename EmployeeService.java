import java.util.ArrayList ;
import java.util.List ;

public class EmployeeService {

    private final ArrayList<Employee> employees ;

    public EmployeeService() {

        employees = new ArrayList<>() ;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee) ;
    }

    public List<Employee> getEmployees() {
        return employees ;
    }

    public void removeEmployee(int employeeId) {
        for (Employee employee : employees) {
            
            if(employee.getEmployeeId() == employeeId) {
                employees.remove(employee) ;
                break ;
            }
        }
    }

    public void updateEmployee(Employee newEmployee) {

        for(Employee oldEmployee : employees) {     // for-each loop.

            if(oldEmployee.getEmployeeId() == newEmployee.getEmployeeId()) {

                oldEmployee.setEmployeeName(newEmployee.getEmployeeName()) ;
                oldEmployee.setEmployeeSalary(newEmployee.getEmployeeSalary()) ;

            //  employees.add(oldEmployee) ;
            }
        }
    }
}
