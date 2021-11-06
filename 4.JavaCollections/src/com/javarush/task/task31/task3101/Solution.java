package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File source = new File(resultFileAbsolutePath);
        File destination = new File(source.getParentFile() + "/allFilesContent.txt");

        if (FileUtils.isExist(destination)) {
            FileUtils.deleteFile(destination);
        }
        FileUtils.renameFile(source, destination);

        /* My initial solution (not accepted by validator):

        Set<String> listFileNames = new TreeSet<>();

        File folder = new File(path);
        for (File file: folder.listFiles()) {
            if (file.length() < 50) {
                listFileNames.add(file.getName());
            }
        }

        FileWriter writer = new FileWriter(destination);
        for (String fileName: listFileNames) {
            File file = new File(path + "/" + fileName);
            List<String> fileContent = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            for (String str: fileContent) {
                writer.write(str);
            }
            writer.write("\n");
        }
        writer.close();
         */

        // Option 2:
        Map<String, File> listFileNames = new TreeMap<>();
        File folder = new File(path);
        for (File file : folder.listFiles()) {
            if (file.length() < 50) {
                listFileNames.put(file.getName(), file);
            }
        }

        FileWriter writer = new FileWriter(destination);
        for (String fileName : listFileNames.keySet()) {
            File value = listFileNames.get(fileName);
            List<String> fileContent = Files.readAllLines(value.toPath(), Charset.defaultCharset());
            for (String str : fileContent) {
                writer.write(str);
            }
            writer.write("\n");
        }
        writer.close();
    }
}

    /* Solution is proposed by JR:

    Map<String, byte[]> fileTree = getFileTree(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
        for (byte[] bytes : fileTree.values()) {
            fileOutputStream.write(bytes);
            fileOutputStream.write("\n".getBytes());
        }
    }
} catch (IOException ignored) {
        }
        }

public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
        }

private static class GetFiles extends SimpleFileVisitor<Path> {
    private Map<String, byte[]> result;

    public GetFiles(Map<String, byte[]> result) {
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        File file = path.toFile();
        if (file.isFile()) {
            if (file.length() <= 50) {
                result.put(path.getFileName().toString(), Files.readAllBytes(path));
            }
        }
        return super.visitFile(path, basicFileAttributes);
    }
}
     */


