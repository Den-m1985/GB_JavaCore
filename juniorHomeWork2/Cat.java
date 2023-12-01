public class Cat extends Animal {
    public String type;

    public Cat(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
