import employee.Employee;

public class Boss extends Employee {
    private final String level = "Boss";

    public Boss() {
        super();

    }

    @Override
    public void raiseSalary(int salary) {
        if (!level.equals("Boss")) {
            super.raiseSalary(salary);
        }
    }


}
