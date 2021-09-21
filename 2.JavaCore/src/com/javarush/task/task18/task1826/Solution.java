package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            while (fileInputStream.available() > 0) {
                int el = fileInputStream.read() + 7;
                fileOutputStream.write(el);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } else if (args[0].equals("-d")) {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            while (fileInputStream.available() > 0) {
                int el = fileInputStream.read() - 7;
                fileOutputStream.write(el);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
