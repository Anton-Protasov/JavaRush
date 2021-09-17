package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> listVowels = new ArrayList<>();
        List<Character> listConsonant = new ArrayList<>();
        for (char el : bufferedReader.readLine().toCharArray()) {
            if (isVowel(el)) {
                listVowels.add(el);
            } else if (el != ' '){
                listConsonant.add(el);
            }
        }

        for (char el : listVowels) {
            System.out.print(el + " ");
        }
        System.out.println();
        for (char el : listConsonant) {
            System.out.print(el + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}