package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            String[] array = bufferedReader.readLine().split(" ");
            int year = Integer.parseInt(array[array.length - 1]);
            int month = Integer.parseInt(array[array.length - 2]);
            int day = Integer.parseInt(array[array.length - 3]);
            String name = "";
            for (int i = 0; i < array.length - 3; i++) {
                name += array[i] + " ";
            }
            name = name.trim();
            PEOPLE.add(new Person(name, new Date(year - 1900, month - 1, day)));
        }
        fileReader.close();
        bufferedReader.close();
    }
}
