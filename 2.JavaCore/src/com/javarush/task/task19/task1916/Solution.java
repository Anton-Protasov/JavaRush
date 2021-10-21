package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(bufferedReader.readLine());
        FileReader file2 = new FileReader(bufferedReader.readLine());

        List<String> fileList1 = new ArrayList<>();
        BufferedReader buFile1 = new BufferedReader(file1);
        while (buFile1.ready()) {
            fileList1.add(buFile1.readLine());
        }

        List<String> fileList2 = new ArrayList<>();
        BufferedReader buFile2 = new BufferedReader(file2);
        while (buFile2.ready()) {
            fileList2.add(buFile2.readLine());
        }
/*
        int n1 = 0;
        int n2 = 0;
        while (n1 < fileList1.size() && n2 < fileList2.size()) {
            if (fileList1.get(n1).equals(fileList2.get(n2))) {
                lines.add(new LineItem(Type.SAME, fileList1.get(n1)));
                n1++;
                n2++;
            } else if (!fileList2.contains(fileList1.get(n1))) {
                lines.add(new LineItem(Type.REMOVED, fileList1.get(n1)));
                n1++;
            } else if (fileList1.contains(fileList2.get(n2))) {
                lines.add(new LineItem(Type.ADDED, fileList2.get(n2)));
                n2++;
            }
        }
        if (n1 < fileList1.size()) {
            lines.add(new LineItem(Type.REMOVED, fileList1.get(n1)));
        } else if (n2 < fileList2.size()) {
            lines.add(new LineItem(Type.ADDED, fileList2.get(n2)));
        }
 */

        while (fileList1.size() > 0 && fileList2.size() > 0) {
            if (fileList1.get(0).equals(fileList2.get(0))) {
                lines.add(new LineItem(Type.SAME, fileList1.get(0)));
                fileList1.remove(0);
                fileList2.remove(0);
            } else if (!fileList2.get(1).equals(fileList1.get(0))) {
                lines.add(new LineItem(Type.REMOVED, fileList1.get(0)));
                fileList1.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, fileList2.get(0)));
                fileList2.remove(0);
            }
        }
        if (fileList1.size() > 0) {
            lines.add(new LineItem(Type.REMOVED, fileList1.get(0)));
        } else if (fileList2.size() > 0) {
            lines.add(new LineItem(Type.ADDED, fileList2.get(0)));
        }

        bufferedReader.close();
        file1.close();
        file2.close();
        buFile1.close();
        buFile2.close();
/*
        for (LineItem el: lines) {
            System.out.println(el.type);
        }
 */
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
