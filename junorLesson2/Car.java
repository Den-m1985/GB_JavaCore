public class Car {
    public String name;
    private String price;
    private String engType;
    private String engPower;
    public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.price = "1_000_000";
        this.engType = "V20";
        this.engPower = "1000";
        this.maxSpeed = 500;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
