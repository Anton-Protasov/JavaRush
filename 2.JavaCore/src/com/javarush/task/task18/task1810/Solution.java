package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int size = 0;
            FileInputStream file = new FileInputStream(reader.readLine());
            if(file.available() < 1000) {
                file.close();
                throw new DownloadException("The stream is less than 1000 byte");
            }
        }
    }

    public static class DownloadException extends Exception {
        public DownloadException(String message) {
            super(message);
        }
    }
}
