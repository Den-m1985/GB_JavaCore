package ru.gb.jcore.sample;

import ru.gb.jcore.regular.DateNow;
import ru.gb.jcore.regular.WriteTxtFile;

public class Main {

    public static void main(String[] args) {

        DateNow date = new DateNow();
        String time = date.currentDate();

        String str = "Hello world";
        String downloadsPath = "file.txt";

        new WriteTxtFile(downloadsPath, time, str);
    }
}
