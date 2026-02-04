package com.rimonmostafiz.java.collection.exercises.objectordering.comparable;

import java.util.ArrayList;

public class SortingComparable {
    public static void main(String[] args) {
        Person p1 = new Person("Jack", 35);
        Person p2 = new Person("Mac", 33);
        Person p3 = new Person("Bob", 26);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        persons.sort(null);
        System.out.println(persons);
    }
}
