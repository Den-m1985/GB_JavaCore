package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

public class Main {
    public static void main(String[] args) {
        DescriptiveStatistics statistics = new DescriptiveStatistics();
        statistics.addValue(1);
        statistics.addValue(2);
        statistics.addValue(3);

        System.out.println("Минимальное: " + statistics.getMin());
        System.out.println("Максимальное: " + statistics.getMax());
        System.out.println("Среднее арифметическое: " + statistics.getMean());

        int n = 5;
        System.out.println("Факториал числа " + n + " равен " + ArithmeticUtils.factorial(n));
        int a = 16;
        int b = 24;
        System.out.printf("Наименьшее общее частное чисел %s и %s равно %d\n", a, b,
                ArithmeticUtils.lcm(a, b));
        System.out.printf("Наибольший общий делитель чисел %s и %s равно %d\n", a, b,
                ArithmeticUtils.gcd(a, b));
        if (ArithmeticUtils.isPowerOfTwo(a)){
            System.out.printf("%d является степенью числа 2\n", a);
        } else {
            System.out.printf("%d не является степенью числа 2\n", a);
        }
    }

}