package ru.gb.jcore.sample;

import ru.gb.jcore.regular.Decorator;
import ru.gb.jcore.regular.OtherClass;

public class Main {
    /**
     * Точка входа в программу. С нее всегда начинается
     * @param args стандартные аргументы командной строки
     */
    public static void main(String[] args) {
        int result = OtherClass.add(2,2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.div(2,2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.mul(2,2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.sub(2,2);
        System.out.println(Decorator.decorator(result));
    }
}