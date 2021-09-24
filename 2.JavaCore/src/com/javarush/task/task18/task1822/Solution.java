package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName.readLine()));
        int id = Integer.parseInt(args[0]);
        //int id = Integer.parseInt(fileName.readLine());
        String line = fileReader.readLine();
        while (line != null) {
           int idLine = Integer.parseInt(line.split(" ")[0]);
           if (idLine == id) {
               System.out.println(line);
               fileName.close();
               fileReader.close();
               break;
           }
           line = fileReader.readLine();
        }
    }
}