package lesson4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(Male.MALE);
        Cat cat2 = new Cat(Male.FEMALE);
        Cat cat3 = new Cat(Male.MALE);
//        Cat cat4 = new Cat("Banana");
        Cat cat5 = new Cat(Male.MALE);

        Cat[] cats = {cat1, cat2, cat3,/* cat4,*/ cat5};
        List<Cat> catList = Arrays.asList(cats);

        for (Cat cat : catList) {
            switch (cat.getMale()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }



        ListIterator<Cat> iterator = catList.listIterator();
        while (iterator.hasNext()) {
            Cat cat = iterator.next();
//            Cat cat = iterator.previous();


            switch (cat.getMale()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }

        System.out.println("***");
        for (Cat cat : catList) {
            System.out.println(cat.getMale().getRussianMaleTitle());
        }
        System.out.println("***");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run!");
            }
        };

        Runnable runnable2 = () -> System.out.println("NEW RUNNNNN!");

        runnable.run();
        runnable2.run();

        BiFunction<Integer, Integer, String> biFunction = new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return String.format("%s + %s = %s", a, b, a + b);
            }
        };

        BiFunction<Integer, Integer, String> biFunction2 =
            (a, b) -> String.format("NEW RESULT: %s + %s = %s", a, b, a + b);

        System.out.println(biFunction.apply(5, 7));
        System.out.println(biFunction2.apply(5, 7));
    }
}
