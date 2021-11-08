package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/*
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        Path direct = Paths.get(path);
        String resultFileAbsolutePath = args[1];
        File source = new File(resultFileAbsolutePath);
        File destination = new File(source.getParentFile() + "/allFilesContent.txt");

        if (FileUtils.isExist(destination)) {
            FileUtils.deleteFile(destination);
        }
        FileUtils.renameFile(source, destination);

        Map<String, Path> filesMap = new TreeMap<>();
        Queue<Path> fileSource = new LinkedList<>();

        fileSource.add(direct);
        while (!fileSource.isEmpty()) {
            Path temp = fileSource.poll();
            if (Files.isRegularFile(temp) && Files.size(temp) <= 50) {
                filesMap.put(temp.getFileName().toString(), temp);
            } else if (Files.isRegularFile(temp) && Files.size(temp) > 50) {
                fileSource.remove(temp);
            } else if (Files.isDirectory(temp)) {
                DirectoryStream<Path> stream = Files.newDirectoryStream(temp);
                for (Path el : stream) {
                    fileSource.add(el);
                }
            }
        }

        try (FileWriter writer = new FileWriter(destination)) {
            for (String fileName : filesMap.keySet()) {
                Path value = filesMap.get(fileName);
                List<String> fileContent = Files.readAllLines(value, Charset.defaultCharset());
                for (String str : fileContent) {
                    writer.write(str);
                }
                writer.write("\n");
            }
        } catch (IOException e) {
        }
    }
}