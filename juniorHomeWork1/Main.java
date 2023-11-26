import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        Напишите программу, которая использует Stream API для обработки списка чисел.
        Программа должна вывести на экран среднее значение всех четных чисел в списке.
         */

        List<Integer> list = Arrays.asList(2, 5, 6, 8, 9, 52, 12, 5, 5, 5, 0, -2);

        double average = list.stream()
                 .filter(n -> n % 2 == 0) // фильтрация четных чисел
                .mapToDouble(Integer::doubleValue) // преобразование в double
                .average() // вычисление среднего значения
                .orElse(0.0); // значение по умолчанию, если список пуст

        System.out.println("Среднее значение четных чисел: " + average);

    }
}
