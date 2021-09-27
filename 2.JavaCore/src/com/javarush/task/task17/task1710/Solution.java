package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CRUD - Create, Read, Update, Delete.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код
        if ("-c".equals(args[0])) {
            Person person;
            Sex sex;
            String name = args[1];
            if ("м".equals(args[2])) {
                sex = Sex.MALE;
            } else {
                sex = Sex.FEMALE;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = dateFormat.parse(args[3]);
            if (sex == Sex.MALE) {
                person = Person.createMale(name, bd);
            } else {
                person = Person.createFemale(name, bd);
            }
            allPeople.add(person);
            System.out.println(allPeople.size() - 1);

        } else if ("-r".equals(args[0])) {
            // Миронов м 15-Apr-1990
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            Sex sex = person.getSex();
            String s = null;
            if (sex == Sex.MALE) {
                s = "м";
            } else {
                s = "ж";
            }
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String bd = dateFormat.format(person.getBirthDate());
            System.out.println(person.getName() + " " + s + " " + bd);

        } else if ("-u".equals(args[0])) {
            int id = Integer.parseInt(args[1]);
            String name = args[2];
            Sex sex;
            if ("м".equals(args[2])) {
                sex = Sex.MALE;
            } else {
                sex = Sex.FEMALE;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = dateFormat.parse(args[4]);
            Person person = allPeople.get(id);
            person.setName(name);
            person.setSex(sex);
            person.setBirthDate(bd);

        } else if ("-d".equals(args[0])) {
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
}
