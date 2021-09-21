package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    int getCountOfEggsPerMonth() {
        return 15;
    }

    String getDescription(){
        return (super.getDescription()
                + String.format(" Моя страна - Ukraine. Я несу %s яиц в месяц.", getCountOfEggsPerMonth()) );
    }
}
