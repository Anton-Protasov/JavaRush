package com.javarush.task.task10.task1007;

/* 
Задача №7 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        long l = 1234_564_890L; //27 / 1234564891
        int x = 0b1000_1100_1010; // -53 / 2251
        double m = (byte) 110_987_654_6299.123_34; // -1.0 / 1.1098765462991233E12
        float f = l++ + 10 + ++x - (float) m; // -16 / 1234564891 + 1 + 10 = 1234564902 + 2251 + 1 = 1234567154
        l = (long) f / 1000; //0
        System.out.println(l);
    }
}