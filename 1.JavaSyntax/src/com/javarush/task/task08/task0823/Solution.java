package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] str = string.split(" ");
        for (int i = 0; i < str.length; i++) {
            char ch = str[i].toUpperCase().charAt(0);
            StringBuilder stringBuilder = new StringBuilder(str[i]);
            str[i] = String.valueOf(stringBuilder.replace(0, 1, String.valueOf(ch)));
        }
        string = "";
        for (int i = 0; i < str.length; i++) {
            string = string + str[i] + " ";
        }
        System.out.print(string.trim());
    }
}