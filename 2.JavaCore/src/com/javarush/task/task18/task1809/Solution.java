package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();
        while (file1.available() > 0) {
            list.add(file1.read());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            file2.write(list.get(i));
        }
        file1.close();
        file2.close();
    }
}
