import employee.Employee;
import employee.FabricEmployee;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // создаем офис
        int count = 5;
        ArrayList<Employee> employee = new FabricEmployee().createArrayEmployee(count);
        //printEmployee(employee);

        // повышаем зарплату
        riseSalaryEmployee(employee, 45, 5000);
        //printEmployee(employee);

        System.out.println("Средняя зарплата: " + averageSalary(employee));

        System.out.println("Средний возраст: " + averageAge(employee));

        // повышаем уровень.
        promoteEmployee(employee);
        printEmployee(employee);


        // задание 2
        Boss boss = new Boss();
        boss.createEmployee("David", "Smith", "Petrovich",
                "Boss", "junior", "+7123456789", 1000000, 50);
        employee.add(boss);
        riseSalaryEmployee(employee, 18, 1000);
        printEmployee(employee);
    }

    public static void riseSalaryEmployee(ArrayList<Employee> employee, int age, int money) {
        for (Employee empl : employee) {
            if (empl.getAge() > age) {
                empl.raiseSalary(money);
            }
        }
    }

    public static void printEmployee(ArrayList<Employee> employee) {
        for (Employee empl : employee) {
            System.out.println(empl.toString());
        }
        System.out.println();
    }

    public static void promoteEmployee(ArrayList<Employee> employee) {
        for (Employee empl : employee) {
            empl.promoteLevel();
        }
    }

    public static int averageSalary(ArrayList<Employee> employee) {
        int temp = 0;
        for (Employee empl : employee) {
            temp = temp + empl.getSalary();
        }
        return temp / employee.size();
    }

    public static int averageAge(ArrayList<Employee> employee) {
        int temp = 0;
        for (Employee empl : employee) {
            temp = temp + empl.getAge();
        }
        return temp / employee.size();
    }

}
