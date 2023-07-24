package study;

import java.lang.reflect.Method;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Class<?> b = random.getClass();

        for (Method declaradMethod : b.getDeclaredMethods()) {
            System.out.println(declaradMethod);
        }

    }
}
