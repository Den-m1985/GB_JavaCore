package ru.gb.jcore.regular;

public class Decorator {
    /**
     * Функция декорирования числа для вывода в консоль
     * в виде строки с преамбулой "Вот Ваше число"
     * @param a число, трубующее декорации
     * @return Отформатированная строка
     */

    public static String decorator(int a){
        /*
        Метод декорирует число, добавляя к нему строку
        при помощи функции форматирования строк.
         */
        return String.format("Here is your number: %d.", a);
    }
}
