package com.rimonmostafiz.java.collection.exercises.objectordering.comparator;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getLastName());
    }
}
