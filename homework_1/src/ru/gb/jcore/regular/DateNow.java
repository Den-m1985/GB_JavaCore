package ru.gb.jcore.regular;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateNow {

    public String currentDate() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");

        return currentDate.format(formatter);
    }
}
