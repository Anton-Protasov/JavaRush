package com.javarush.task.task04.task0417;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Существует ли пара?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String num1S = bufferedReader.readLine();
        int num1 = Integer.parseInt(num1S);
        String num2S = bufferedReader.readLine();
        int num2 = Integer.parseInt(num2S);
        String num3S = bufferedReader.readLine();
        int num3 = Integer.parseInt(num3S);

        if(num1 == num2 && num1 == num3) {
            System.out.println(num1 + " " + num2 + " " + num3);
        } else if (num1 == num2 && num1 != num3) {
                System.out.println(num1 + " " + num2);
        } else if (num2 == num3 && num2 != num1) {
            System.out.println(num2 + " " + num3);
        } else if (num1 == num3 && num3 != num2) {
            System.out.println(num1 + " " + num3);
        }
    }
}