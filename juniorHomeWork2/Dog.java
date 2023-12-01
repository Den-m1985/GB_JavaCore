public class Dog extends Animal {
    private String type;

    public Dog(String type) {
        this.type = type;
    }

    public String makeSound() {
        return "Gav";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
