package task1;

import java.util.Arrays;

public class Task1 {
    private static int minDigit;

    public static void main(String[] args) {
        int[] arr = {-4, -5, -6, 9, -1, -4, -5, 0};

        int[] tempArray = makeTempArray(arr);
        System.out.println("массив заполненый повторяющимися цифрами:");
        System.out.println(Arrays.toString(tempArray));

        int[] sortArray = sort(arr, tempArray);
        System.out.println("сортированный массив: ");
        System.out.println(Arrays.toString(sortArray));

    }


    private static int[] makeTempArray(int[] array) {
        int maxDigit = Arrays.stream(array).max().getAsInt();
        minDigit = Arrays.stream(array).min().getAsInt();

        // находим длину массива
        int result = findIndex(maxDigit);
        int[] newArray = new int[result + 1];
        System.out.println("минимальное число: " + minDigit + "   максимальное число: " + maxDigit);

        // заполняем массив колличеством повторяющихся цифр
        for (int i : array) {
            if (i == minDigit)
                newArray[0] = newArray[0] + 1;
            else {
                int position = findIndex(i);
                newArray[position] = newArray[position] + 1;
            }
        }
        return newArray;
    }

    // работаем с числами в зависимости от знака.
    private static int findIndex(int maxDigit) {
        int result;
        if (maxDigit < 0)
            result = Math.abs(minDigit) - Math.abs(maxDigit);
        else if (maxDigit >= 0 && minDigit < 0) {
            result = maxDigit + Math.abs(minDigit);
        } else {
            result = maxDigit + minDigit;
        }
        return result;
    }


    private static int[] sort(int[] array, int[] tempArray) {
        int[] sortArray = new int[array.length];

        int indexNewArray = 0;
        for (int i = 0; i < tempArray.length; i++) {
            int number = minDigit + i;
            if (tempArray[i] != 0) {
                for (int j = 0; j < tempArray[i]; j++) {
                    sortArray[indexNewArray] = number;
                    indexNewArray++;
                }
            }
        }
        return sortArray;
    }

}
