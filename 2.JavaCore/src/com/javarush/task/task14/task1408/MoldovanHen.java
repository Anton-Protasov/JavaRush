package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    int getCountOfEggsPerMonth() {
        return 20;
    }

    String getDescription(){
        return (super.getDescription()
                + String.format(" Моя страна - Moldova. Я несу %s яиц в месяц.", getCountOfEggsPerMonth()) );
    }
}
