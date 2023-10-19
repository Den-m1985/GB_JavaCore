import java.util.ArrayList;
import java.util.List;
/*
    Добавить метод, который ищет сотрудника по стажу (может быть список)
    Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    Добавить метод, который ищет сотрудника по табельному номеру
    Добавить метод добавление нового сотрудника в справочник
     */
public class EmployeeDirectory {
    private final List<Employee> employeeArray;
    long id;

    public EmployeeDirectory() {
        this.employeeArray = new ArrayList<>();
    }

    public void addEmployee(String name, String phoneNumber, byte experience) {

        employeeArray.add(new Employee(++id, name, phoneNumber, experience));
    }

    public void printDirectory(){
        for (Employee employee:employeeArray) {
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

//    public Employee getEmplByPhone(String phoneNumber) {
//        for (Employee employee : employeeArray) {
//            if (employee.getPhoneNumbers() == experience) {
//                returnEmployeeArray.add(employee);
//            }
//        }
//        return null;
//    }


}
