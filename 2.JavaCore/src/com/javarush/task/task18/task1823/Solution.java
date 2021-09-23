package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = bufferedReader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            synchronized (resultMap) {
                new ReadThread(fileName);
            }
        }
        bufferedReader.close();

        for (String key : resultMap.keySet()) {
            int value = resultMap.get(key);
            System.out.println(key + " " + value);
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
            start();
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileReader fileReader = new FileReader(getName());
                int[] arrayMax = new int[255];
                Arrays.fill(arrayMax, 0);
                while (fileReader.ready()) {
                    int index = fileReader.read();
                    arrayMax[index]++;
                }
                fileReader.close();
                int max = arrayMax[0];
                int indexMax = 0;
                for (int i = 1; i < arrayMax.length; i++) {
                    if (arrayMax[i] > max) {
                        max = arrayMax[i];
                        indexMax = i;
                    }
                }

                resultMap.put(getName(), indexMax);

            } catch (IOException e) {
            }
        }
    }
}
