package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

public class Solution {
    public static void main(String[] args) {
        Robot amigo = new Robot("Амиго");
        Robot enemy = new Robot("Сгибальщик-02");

        Robot.doMove(amigo, enemy);
        Robot.doMove(amigo, enemy);
        Robot.doMove(enemy, amigo);
        Robot.doMove(amigo, enemy);
        Robot.doMove(enemy, amigo);
        Robot.doMove(amigo, enemy);
        Robot.doMove(enemy, amigo);
        Robot.doMove(amigo, enemy);
    }
}
