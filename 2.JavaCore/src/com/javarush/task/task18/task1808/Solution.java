package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (file1.available() > 0) {
            list.add(file1.read());
        }
        if (list.size() % 2 == 0) {
            for (int i = 0; i < list.size() / 2; i++) {
                file2.write(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                file3.write(list.get(i));
            }
        } else {
            for (int i = 0; i < (list.size() / 2) + 1; i++) {
                file2.write(list.get(i));
            }
            for (int i = (list.size() / 2) + 1; i < list.size(); i++) {
                file3.write(list.get(i));
            }
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
