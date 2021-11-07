package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    //public static void getFileTree(String root) throws IOException {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<Path> source = new LinkedList<>();
        source.add(Paths.get(root));
        while (!source.isEmpty()) {
            Path path = source.poll();
            if (Files.isDirectory(path)) {
                DirectoryStream<Path> stream = Files.newDirectoryStream(path);
                for (Path el: stream) {
                    source.add(el);
                }
            } else {
                result.add(path.toAbsolutePath().toString());
            }
        }
        return result;
        /*
        for (String el: result) {
            System.out.println(el);
        }
         */
    }

    public static void main(String[] args) {
    }

    /*
    public static void main(String[] args) throws IOException{
        getFileTree("C:\\Users\\...");
    }
     */
}
