package com.rimonmostafiz.java.collection.exercises.objectordering.comparator;

import java.util.ArrayList;

public class SortingComparator {
    public static void main(String[] args) {
        Student s1 = new Student("Foo", "Bar", 2, "Commerce");
        Student s2 = new Student("Bar", "Baz", 1, "Science");
        Student s3 = new Student("Blah", "Bar", 3, "Arts");

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s3);
        students.add(s2);

        students.sort(new StudentLastNameComparator());
        System.out.println(students);
        students.sort(new StudentIdComparator());
        System.out.println(students);
        students.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));
        System.out.println(students);
        students.sort((o1, o2) -> o1.getDepartment().compareTo(o2.getDepartment()));
        System.out.println(students);
    }
}
