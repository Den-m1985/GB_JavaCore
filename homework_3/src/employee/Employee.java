package employee;

public class Employee {

    private String name;
    private String secondName;
    private String patronymic;
    private String jobTitle;
    private String[] levels = {"junior", "middle", "senior"};
    private String level;
    private String phoneNumber;
    private int salary;
    private int age;


    public void createEmployee(String name, String secondName, String patronymic, String jobTitle, String level,
                               String phoneNumber, int salary, int age){
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.jobTitle = jobTitle;
        this.level = level;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void raiseSalary(int salary) {
        this.salary = salary + this.salary;
    }

    public void promoteLevel() {
        if (level.equals(levels[0])) {
            this.level = levels[1];
        } else if (level.equals(levels[1])) {
            this.level = levels[2];
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "name= " + name +
                ", secondName= " + secondName +
                ", patronymic= " + patronymic +
                ", jobTitle= " + jobTitle +
                ", level= " + level +
                ", phoneNumber= " + phoneNumber +
                ", salary= " + salary +
                ", age= " + age;
    }

}
