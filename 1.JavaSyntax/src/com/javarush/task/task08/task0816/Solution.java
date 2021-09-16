package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

/* 
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("a", dateFormat.parse("MAY 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> newMap = new HashMap<>(map);
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        for (String key : newMap.keySet()) {
            if (
                    dateFormat.format(newMap.get(key)).contains("June")
                            || dateFormat.format(newMap.get(key)).contains("July")
                            || dateFormat.format(newMap.get(key)).contains("August")
            ) {
                map.remove(key);
            }
        }
    }

    public static void main(String[] args) {

    }
}
