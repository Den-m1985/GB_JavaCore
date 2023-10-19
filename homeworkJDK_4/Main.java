import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.addEmployee("Иван", "89111111111", (byte) 20);
        employeeDirectory.addEmployee("Марри", "89155111111", (byte) 1);
        employeeDirectory.addEmployee("Петр", "89111122111", (byte) 20);
        employeeDirectory.addEmployee("Эвклид", "89111331111", (byte) 127);
        //employeeDirectory.printDirectory();
        List<Employee> experience = employeeDirectory.getEmplByExperience((byte) 20);
        for (Employee empl:experience) {
            System.out.println("сотрудники по стажу: " + empl.toString());
        }




    }

}
