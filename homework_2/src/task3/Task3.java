package task3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = {-4, -5, -6, 9, -1, -4, -5, 0};

        shifter(arr, 2);
        System.out.println(Arrays.toString(arr));

    }

    private static void shifter(int[] a, int n) {
        n %= a.length;
        int shift = a.length + n;
        shift %= a.length;

        for (int i = 0; i < shift; i++) {
            int temp = a[a.length - 1];
            System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0] = temp;
        }
    }

}
