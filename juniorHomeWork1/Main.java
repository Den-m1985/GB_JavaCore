import java.util.Arrays;

public class Main {
    /*
    Напишите программу которая использует Stream API для обработки списка чисел.
    Програма долна вывести на экран среднее значение всех чтетных чисел в списке
     */
    public static void main(String[] args) {

        Arrays.asList(1, 2, 5, 6, 9, 5).stream().
                sorted().
                distinct().
                forEach(System.out::print);

    }
}
