package com.javarush.task.task19.task1903;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

        /*

        int code = 99;
        int tel = 1234567;
        String telS = String.valueOf(tel);
        int telLength = telS.length();
        char[] telC = new char[10];
        Arrays.fill(telC, '0');
        for (int i = 9; i <= 0; i--) {
            telC[i] = telS.charAt(--telLength);
        }
        telS = new String(telC);
        String rsl = "+" + code + "(" + telS.substring(0, 3) + ")"
                + telS.substring(3, 6) + "-" + telS.substring(6, 8) + "-" + telS.substring(8);
        System.out.println(telS);
        System.out.println(rsl);

         */
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
           return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String key = data.getCountryCode();
            String value = Solution.countries.get(key);
            return value;
        }

        @Override
        public String getName() {
            String name = data.getContactLastName() + ", " + data.getContactFirstName();
            return name;
        }

        @Override
        public String getPhoneNumber() {
            int code = data.getCountryPhoneCode();
            int tel = data.getPhoneNumber();
            String telS = String.valueOf(tel);
            int telLength = telS.length();
            char[] telC = new char[10];
            Arrays.fill(telC, '0');
            for (int i = 9; i <= 0; i--) {
                telC[i] = telS.charAt(--telLength);
            }
            telS = new String(telC);
            return "+" + code + "(" + telS.substring(0, 3) + ")"
                    + telS.substring(3, 6) + "-" + telS.substring(6, 8) + "-" + telS.substring(8);
        }
    }

    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}