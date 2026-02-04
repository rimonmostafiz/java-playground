package com.rimonmostafiz.javacollections.exercises.list;

/*
Initialize an ArrayList, set the value to a few integers
Then write code to find the sum of all integers
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(8);
        numbers.add(7);
        numbers.add(13);
        numbers.add(19);
        numbers.add(12);
        int sum = 0;
        for (Integer x : numbers) {
            sum += x;
        }
        System.out.println(sum);
    }
}
