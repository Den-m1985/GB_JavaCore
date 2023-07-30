package task_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /*
    Задача: Создать массив из 9 цифр и записать его в файл,
    используя поток вывода.
     */
    public static void main(String[] args) throws IOException {
        int[] array = {3, 2, 6, 5, 9, 8, 7, 5, 6, 3, 2, 5};
        String fileName = "Task_1.txt";
        StringBuilder strBinder = change(array);
        //writeFile(fileName, strBinder);
        //System.out.println(strBinder);

        StringBuilder strRead = readFile(fileName);
        System.out.println(strRead);
    }

    public static void writeFile(String fileName, StringBuilder strBinder) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        //String str = Arrays.toString(array);
        String str = strBinder.toString();
        byte[] byt = str.getBytes();
        fos.write(byt);
        fos.flush();
        fos.close();
    }

    public static StringBuilder change(int[] array) {
        StringBuilder strBinder = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            strBinder.append(array[i]);
            strBinder.append(0);
        }
        strBinder.append(array[array.length - 1]);
        return strBinder;
    }

    public static StringBuilder readFile(String fileName) throws FileNotFoundException {
        //FileReader fileReader = new FileReader(fileName);
        ArrayList arr = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int a;
            while ((a = fis.read()) != -1) {
                if (a != 0) {

                    arr.add(a);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        StringBuilder strBinder = new StringBuilder();
        return strBinder;
    }


}
