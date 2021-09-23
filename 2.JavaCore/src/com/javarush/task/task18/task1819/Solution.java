package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        List<Integer> list = new ArrayList<>();
        FileReader fileReader1 = new FileReader(file1);
        while (fileReader1.ready()) {
            list.add(fileReader1.read());
        }
        FileWriter fileWriter1 = new FileWriter(file1);
        FileReader fileReader2 = new FileReader(file2);
        while (fileReader2.ready()) {
            int i = fileReader2.read();
            fileWriter1.write(i);
        }
        for (int el: list) {
            fileWriter1.write(el);
        }
        fileReader1.close();
        fileReader2.close();
        fileWriter1.close();
    }
}
