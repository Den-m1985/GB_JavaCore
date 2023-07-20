package task1;
/*
Задача:  Написать функцию добавления элемента в конец
массива таким образом, чтобы она расширяла массив при необходимости.
 */

import java.util.Arrays;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        int[] arr = createArray(3);
        int[] newArray = addArrayToEnd(arr, 4);
        System.out.println(Arrays.toString(newArray));

        int[] array = insertIntoArray(arr, 69);
        System.out.println(Arrays.toString(array));
    }


    public static int[] addArrayToEnd(int[] arr, int number) {
        int[] newArray = new int[0];
        newArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[arr.length] = number;
        return newArray;
    }

    public static int[] createArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(0, 100);
        }
        return arr;
    }

// метод от преподавателя.
    public static int[] insertIntoArray(int[] arr, int value, int index) {
        if (index < 0 || index > arr.length) {
            throw new RuntimeException();
        }
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, index);
        result[index] = value;
        System.arraycopy(arr, index, result, index + 1, arr.length - index);
        return result;
    }
    public static int[] insertIntoArray(int[] arr, int value) {
        return insertIntoArray(arr, value, arr.length);
    }

}
