package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    int getCountOfEggsPerMonth() {
        return 25;
    }

    String getDescription(){
        return (super.getDescription()
                + String.format(" Моя страна - Belarus. Я несу %s яиц в месяц.", getCountOfEggsPerMonth()) );
    }
}