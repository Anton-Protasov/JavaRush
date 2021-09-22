package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        int count = 0;
        while (fileReader.ready()) {
            int symbol = fileReader.read();
            if ((symbol >= 65 && symbol <= 90) || (symbol >= 97 && symbol <= 122)) {
                count++;
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
