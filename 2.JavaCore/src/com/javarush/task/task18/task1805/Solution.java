package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Byte> set = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        FileInputStream file = new FileInputStream(scanner.nextLine());
        byte[] array = file.readAllBytes();
        for (byte el : array) {
            set.add(el);
        }
        for (byte el : set) {
            System.out.print(el + " ");
        }
        file.close();
    }
}
