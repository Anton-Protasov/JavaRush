package com.javarush.task.task17.task1706;

/*
И снова Singleton паттерн - синхронизация в статическом блоке.
 */

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
