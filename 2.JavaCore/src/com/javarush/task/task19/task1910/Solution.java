package com.javarush.task.task19.task1910;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        BufferedReader file1 = new BufferedReader(fileReader);
        BufferedWriter file2 = new BufferedWriter(fileWriter);

                /*
        while (file1.ready()) {
            int el = file1.read();
            if (el != 11 && el != 33 && el != 44 && el != 46 && el != 58 && el != 59 && el != 63) {
                file2.write(el);
            }
        }
                 */

        // Solution through the regex
        Pattern pattern = Pattern.compile("\\p{Punct}");
        while (file1.ready()) {
            String line = file1.readLine();
            Matcher matcher = pattern.matcher(line);
            String newString = matcher.replaceAll("");
            file2.write(newString);
            }
        file1.close();
        file2.close();
        bufferedReader.close();
    }
}
