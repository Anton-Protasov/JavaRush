package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        BufferedReader file1 = new BufferedReader(fileReader);
        BufferedWriter file2 = new BufferedWriter(fileWriter);

        while (file1.ready()) {
            String str = file1.readLine();
            String[] array = str.split(" ");
            for (String el : array) {
                try {
                    int number = Integer.parseInt(el);
                    file2.write(el);
                    file2.write(" ");
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        file1.close();
        file2.close();
        bufferedReader.close();
    }
}
