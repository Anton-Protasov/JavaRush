package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream file = new FileInputStream(scanner.nextLine());
        byte[] array = new byte[255];
        for (byte el: array) {
            el = 0;
        }
        while (file.available() > 0) {
            int index = file.read();
            array[index]++;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 2) {
                System.out.print(i + " ");
            }
        }
        file.close();
    }
}