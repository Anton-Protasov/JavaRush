package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String numS = bufferedReader.readLine();
        double num = Double.parseDouble(numS);
        if(num > 5) {
            double x = num / 5;
            num = num - 5 * (int) x;
        }
        System.out.println((num < 3 || num == 5) ? "зелёный" :
                (num >= 3 && num < 4) ? "жёлтый" : "красный");
    }
}