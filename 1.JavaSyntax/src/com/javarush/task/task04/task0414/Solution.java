package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Количество дней в году
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String numS = bufferedReader.readLine();
        int num = Integer.parseInt(numS);

        System.out.println(num % 400 == 0 ? "количество дней в году: 366" :
                num % 100 == 0 ? "количество дней в году: 365":
                        num % 4 == 0 ? "количество дней в году: 366": "количество дней в году: 365");
    }
}