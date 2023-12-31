package ru.gb.jcore.regular;

/**
 * Полезный класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 */
public class OtherClass {
    /**
     * Функция суммирования двух чисел
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма a и b, без проверки на переполнение переменной.
     */
    public static int add(int a, int b) {
        return a + b; // возвращает без проверки переполнения
    }

    /**
     * Функция деления двух чисел
     * @param a первое делитель
     * @param b второе делимое
     * @return частное a и b, без проверки на переполнение переменной.
     */
    public static int div(int a, int b) {
        return a / b; // возвращает без проверки переполнения
    }
    /**
     * Функция умножения двух чисел
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение a и b, без проверки на переполнение переменной.
     */
    public static int mul(int a, int b) {
        return a * b; // возвращает без проверки переполнения
    }
    /**
     * Функция вычмтания двух чисел
     * @param a первое уменьшаемое
     * @param b второе вычитаемое
     * @return разность a и b, без проверки на переполнение переменной.
     */
    public static int sub(int a, int b) {
        return a - b; // возвращает без проверки переполнения
    }

}
