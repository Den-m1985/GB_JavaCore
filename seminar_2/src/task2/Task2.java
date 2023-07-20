package task2;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
Задача:  Написать метод, осуществляющий сортировку одномерного массива подсчётом.
Важное ограничение состоит в том, что для этой сортировки диапазон значений
исходного массива должен находиться в разумных пределах, например, не более 1000.
x[2, 1, 0, 4, 3, 0, 0, 1, 2] → t[3(x0 ), 2(x1 ), 2(x2 ), 1(x3 ), 1(x4 )] → x[0, 0, 0, 1, 1, 2, 2, 3, 4]
 */
public class Task2 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 9, 1, 4, 5};

        TreeMap<Integer, Integer> sortArray = sort(arr);
        System.out.println(sortArray);

        int length = makeSumValue(sortArray);
        System.out.println(length);

        int[] newArr = newArray(sortArray, length);
        System.out.println(Arrays.toString(newArr));
    }

    public static TreeMap<Integer, Integer> sort(int[] array) {
        TreeMap<Integer, Integer> sortArray = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = sortArray.getOrDefault(array[i], 0) + 1;
            sortArray.put(array[i], count);
        }
        return sortArray;
    }


    public static int makeSumValue(TreeMap<Integer, Integer> array) {
        int result = 0;
        for (Map.Entry<Integer, Integer> digit : array.entrySet()) {
            int key = digit.getKey();
            int value = digit.getValue();
            result = value + result;
        }
        return result;
    }

    public static int[] newArray(TreeMap<Integer, Integer> array, int arrLength) {
        int[] arrInt = new int[arrLength];
        int j = 0;
        for (Map.Entry<Integer, Integer> digit : array.entrySet()) {
            int key = digit.getKey();
            int value = digit.getValue();
            for (int i = 0; i < value; i++) {
                arrInt[j++] = key;
            }
        }
        return arrInt;
    }

}
