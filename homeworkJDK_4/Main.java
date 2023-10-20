import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        // Добавить метод добавление нового сотрудника в справочник
        employeeDirectory.addEmployee("Иван", "89111111111", (byte) 20);
        employeeDirectory.addEmployee("Марри", "89155111111", (byte) 1);
        employeeDirectory.addEmployee("Петр", "89111122111", (byte) 20);
        employeeDirectory.addEmployee("Эвклид", "89111331111", (byte) 127);
        employeeDirectory.addPhoneNumber(4L, "546767575");

        employeeDirectory.printDirectory();

        // Добавить метод, который ищет сотрудника по стажу (может быть список)
        List<Employee> experience = employeeDirectory.getEmplByExperience((byte) 20);
        for (Employee empl : experience) {
            System.out.println("сотрудники по стажу: " + empl.toString());
        }

        Employee employee = employeeDirectory.getEmplByPhone("89111331111");
        System.out.println("Person with 89111331111 - " + employee.getName());

        // Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
        Employee employee2 = employeeDirectory.getEmplByName("Эвклид");
        for (String empl : employee2.getPhoneNumbers()) {
            System.out.println(empl + " Эвклид");
        }

        // Добавить метод, который ищет сотрудника по табельному номеру
        Employee employee3 = employeeDirectory.getEmplById(2L);
        System.out.println("Person with id 2 - " + employee3.getName());
    }

}
