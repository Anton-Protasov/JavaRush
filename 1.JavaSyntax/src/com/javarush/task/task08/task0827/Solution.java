package com.javarush.task.task08.task0827;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        boolean rsl = true;
        DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MMMM d yyyy")
                .toFormatter();
        dtf = dtf.withLocale(Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(date, dtf);
        if(date1.getDayOfYear() % 2 == 0) {
            rsl = false;
        }
        return rsl;
    }
}