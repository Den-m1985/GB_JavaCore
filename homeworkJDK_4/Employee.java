import java.util.ArrayList;
import java.util.List;

public class Employee {
    private long id;
    private final String name;
    private final byte experience;
    private final List <String> arrayPhoneNumber;

    public Employee(long id, String name, String phoneNumber, byte experience) {
        this.id = id;
        this.name = name;
        arrayPhoneNumber = new ArrayList<>();
        arrayPhoneNumber.add(phoneNumber);
        this.experience = experience;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return arrayPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        arrayPhoneNumber.add(phoneNumber);
    }

    public byte getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumbers='" + arrayPhoneNumber + '\'' +
                ", experience=" + experience +
                '}';
    }

}
