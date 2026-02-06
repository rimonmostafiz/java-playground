package com.rimonmostafiz.javacollections.exercises.list;

import java.util.ArrayList;
import java.util.ListIterator;
/*
Print the list in forward and reverse order using iterators only
*/
public class ListIteratorExercise {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");

        ListIterator<String> stringListIterator = list.listIterator();

       // NOTE: ListIterator is in between the two node not on the node thats why it can give hasNext and hasPrevious

        // Forward traversal
        while (stringListIterator.hasNext()) {
            System.out.printf("%s ", stringListIterator.next());
        }

        System.out.println();

        // Backward traversal
        while (stringListIterator.hasPrevious()) {
            System.out.printf("%s ", stringListIterator.previous());
        }
    }
}
