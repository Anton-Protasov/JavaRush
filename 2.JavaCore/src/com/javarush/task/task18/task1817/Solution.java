package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        int space = 0;
        int total = 0;
        while (fileReader.ready()) {
            int ch = fileReader.read();
            total++;
            if (ch == 32) {
                space++;
            }
        }
        float rsl = (float) space / total * 100;
        System.out.printf("%.2f", rsl);
        fileReader.close();
    }
}
