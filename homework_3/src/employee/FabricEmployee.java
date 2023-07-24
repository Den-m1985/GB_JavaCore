package employee;

import employee.Employee;

import java.util.ArrayList;
import java.util.Random;

public class FabricEmployee {


    public ArrayList<Employee> createArrayEmployee(int count) {
        ArrayList<Employee> employees = new ArrayList<>();
        Random random = new Random();
        /*
        private String name;
        private String secondName;
        private String patronymic;
        private String jobTitle;
        private String phoneNumber;
        private int salary;
        private int age;
        */
        String[] nameArray = {"John", "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella"};
        String[] secondNameArray = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};
        String[] patronymicArray = { "Johnson", "Williamson", "Brownson", "Joneson", "Garcias", "Millers", "Davison",
                "Rodriguezson", "Martinezon" };
        String[] professions = { "Doctor", "Engineer", "Teacher", "Artist", "Writer", "Programmer", "Lawyer", "Chef",
                "Architect", "Scientist" };
        String[] levels = {"junior", "middle", "senior"};

        for (int i = 0; i < count; i++) {
            int randomIndexName = random.nextInt(nameArray.length);
            String name = nameArray[randomIndexName];

            int randomIndexSurname = random.nextInt(secondNameArray.length);
            String secondName = secondNameArray[randomIndexSurname];

            int randomIndexPatronymic = random.nextInt(patronymicArray.length);
            String patronymic = patronymicArray[randomIndexPatronymic];

            int randomIndexProfessions = random.nextInt(professions.length);
            String jobTitle = professions[randomIndexProfessions];

            int randomIndexlevel = random.nextInt(levels.length);
            String level = levels[randomIndexlevel];

            int rand1 = random.nextInt(1000000, 9999999);
            String phoneNumber = "+79" + rand1;

            int salary = random.nextInt(1000, 5000);
            int age = random.nextInt(20, 90);

            Employee employee = new Employee();
            employee.createEmployee(name, secondName, patronymic, jobTitle, level, phoneNumber, salary, age);
            employees.add(employee);
        }
        return employees;
    }

}
