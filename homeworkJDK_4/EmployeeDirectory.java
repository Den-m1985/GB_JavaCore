import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private final List<Employee> employeeArray;
    long id;

    public EmployeeDirectory() {
        this.employeeArray = new ArrayList<>();
    }

    public void addEmployee(String name, String phoneNumber, byte experience) {
        employeeArray.add(new Employee(++id, name, phoneNumber, experience));
    }

    public void printDirectory() {
        for (Employee employee : employeeArray) {
            System.out.println(employee.toString());
        }
    }

    public List<Employee> getEmplByExperience(byte experience) {
        List<Employee> returnEmployeeArray = new ArrayList<>();
        for (Employee employee : employeeArray) {
            if (employee.getExperience() == experience) {
                returnEmployeeArray.add(employee);
            }
        }
        return returnEmployeeArray;
    }

    public void addPhoneNumber(long id, String phoneNumber) {
        Employee employee = getEmplById(id);
        employee.setPhoneNumber(phoneNumber);
    }

    public Employee getEmplByPhone(String phoneNumber) {
        for (Employee employee : employeeArray) {
            List<String> numbers = employee.getPhoneNumbers();
            for (String str : numbers) {
                if (str.equals(phoneNumber)) {
                    return employee;
                }
            }
        }
        return null;
    }

    public Employee getEmplByName(String name) {
        for (Employee employee : employeeArray) {
            String emplName = employee.getName();
            if (emplName.equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmplById(long id) {
        for (Employee employee : employeeArray) {
            long emplId = employee.getId();
            if (emplId == id) {
                return employee;
            }
        }
        return null;
    }

}
