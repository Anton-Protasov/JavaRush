package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        BufferedReader file = new BufferedReader(fileReader);

        while (file.ready()) {

            Map<String, Integer> map = new HashMap<>();
            for (String el: words) {
                map.put(el, 0);
            }

            String str = file.readLine();
            String[] strArray = str.split(" ");
            List<String> newStrArray = Arrays.asList(strArray);

            for (String el: words) {
                if (newStrArray.contains(el)) {
                    map.put(el, map.get(el) + 1);
                }
            }

            int count = 0;
            for (String key: map.keySet()) {
                int value = map.get(key);
                count = count + value;
                }

            if (count == 2) {
                System.out.println(str);
            }
        }

        fileReader.close();
        bufferedReader.close();
    }
}
