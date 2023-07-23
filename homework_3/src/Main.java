import employee.Employee;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int count = 5;
        ArrayList<Employee> employee = new FabricEmployee().createArrayEmployee(count);
        for (Employee empl:employee) {
            System.out.println(empl.toString());
        }


    }
}
