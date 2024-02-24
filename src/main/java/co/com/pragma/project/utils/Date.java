package co.com.pragma.project.utils;

import java.time.LocalDate;

public class Date {

    private Date() {
    }

    public static String dateYear(LocalDate currentDate) {
        return String.valueOf(currentDate.getYear());
    }

    public static String dateMonth(LocalDate currentDate) {
        return String.valueOf(currentDate.getMonth());
    }
}