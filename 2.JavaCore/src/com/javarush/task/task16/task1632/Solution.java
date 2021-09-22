package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    // Нить 1 должна бесконечно выполняться;
    public static class Thread1 extends Thread {

        public void run() {
            while (true) {
            }
        }
    }

    // Нить 2 должна выводить "InterruptedException"
    // при возникновении исключения InterruptedException;
    public static class Thread2 extends Thread {

        public void run() {
            try {
                while (!isInterrupted()) {
                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    // Нить 3 должна каждые полсекунды выводить "Ура";
    public static class Thread3 extends Thread {

        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    // Нить 4 должна реализовать интерфейс Message,
    // при вызове метода showWarning нить должна останавливаться;
    public static class Thread4 extends Thread implements Message {
        public static boolean flag = false;

        public void showWarning() {
            flag = true;
        }

        public void run() {
            while (!flag) {
            }
        }
    }

    // Нить 5 должна читать с консоли числа пока не введено слово "N",
    // а потом вывести в консоль сумму введенных чисел.
    public static class Thread5 extends Thread {

        public void run() {
            int sum = 0;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (!isInterrupted()) {
                    String str = bufferedReader.readLine();
                    if (str.equals("N")) {
                        this.interrupt();
                    } else {
                        sum += Integer.parseInt(str);
                    }
                }
            } catch (IOException e) {
            }
            System.out.println(sum);
        }
    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }
}