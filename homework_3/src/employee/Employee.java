package employee;

public class Employee {

    private String name;
    private String secondName;
    private String patronymic;
    private String jobTitle;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String secondName, String patronymic, String jobTitle, String phoneNumber, int salary, int age) {
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void raiseWages(){

    }


    @Override
    public String toString() {
        return "Employee: " +
                "name= " + name +
                ", secondName= " + secondName+
                ", patronymic= " + patronymic +
                ", jobTitle= " + jobTitle +
                ", phoneNumber= " + phoneNumber +
                ", salary= " + salary +
                ", age= " + age;
    }

}
