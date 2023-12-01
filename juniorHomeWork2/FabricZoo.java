import java.util.ArrayList;
import java.util.List;

public class FabricZoo {
    public List<Animal> zoo;

    public FabricZoo(int count) {
        zoo = new ArrayList<>();
        int halfCount = (int) (double) count / 2;
        for (int i = 0; i < halfCount; i++) {
            Dog dog = new Dog("dog");
            dog.setAge(10 + i);
            dog.setName("Sharik " + (i + 1));
            zoo.add(dog);
        }
        for (int i = 0; i < halfCount; i++) {
            Cat cat = new Cat("cat");
            cat.setAge(1 + i);
            cat.setName("Barsik " + (i + 1));
            zoo.add(cat);
        }
    }

    public List<Animal> getZoo() {
        return zoo;
    }

}
