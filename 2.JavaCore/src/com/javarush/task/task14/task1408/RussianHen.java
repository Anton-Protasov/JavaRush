package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    int getCountOfEggsPerMonth() {
        return 10;
    }

    String getDescription(){
        return (super.getDescription()
                + String.format(" Моя страна - Russia. Я несу %s яиц в месяц.", getCountOfEggsPerMonth()) );
    }
}
