package com.rimonmostafiz.javacollections.exercises.iterator;

/*
Write code that calls the getFruits method and then iterates over the collection, printing each element to console
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorExercise {
    public static void main(String[] args) {
        FruitSupplier fruitSupplier = new FruitSupplier();
        Collection<String> fruits = fruitSupplier.getFruits();
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruitStr = iterator.next();
            System.out.println("fruitStr = " + fruitStr);
        }

        // this works because Collection implements iterable interface
        // this is better mordern way to iterate a colleciton
        for (String fruitStr: fruits) {
            System.out.println("fruitStr = " + fruitStr);
        }
    }

}


class FruitSupplier {
    public Collection<String> getFruits() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        return list;
    }

}
