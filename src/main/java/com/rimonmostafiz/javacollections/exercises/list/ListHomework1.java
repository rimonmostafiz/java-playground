package com.rimonmostafiz.javacollections.exercises.list;

import java.util.ArrayList;
import java.util.Scanner;
/*
Create a Java program that allows a user to perform various operations on an ArrayList of integers.
The program should display a menu of options, and the user should be able to select one of the following operations:

1. Add an element to the list
2. Remove an element from the list
3. Find the minimum element in the list
4. Find the maximum element in the list
5. Print the contents of the list
6. Quit the program

The program should continue to display the menu and allow the user to perform operations until they choose to quit.
*/
public class ListHomework1 {

    public static ArrayList<Integer> integers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOptions = """
                    1. Add an element to the list
                    2. Remove an element from the list
                    3. Find the minimum element in the list
                    4. Find the maximum element in the list
                    5. Print the contents of the list
                    6. Quit the program
                    Enter Your Input: 
                    """;
        System.out.println(inputOptions);
        while (true) {
            int input = scanner.nextInt();
            if (input == 6) break;
            precessInput(input, scanner);
            System.out.println(inputOptions);
        }
    }

    public static void precessInput(int input, Scanner scanner) {
        int i;
        switch (input) {
            case 1:
                i = scanner.nextInt();
                integers.add(i);
                System.out.printf("%d added to list\n", i);
                break;
            case 2:
                i = scanner.nextInt();
                integers.remove(Integer.valueOf(i));
                System.out.printf("%d removed from the list\n", i);
                break;
            case 3:
                System.out.println("Minimum Number from list: " + integers.stream().min(Integer::compareTo).get());
                break;
            case 4:
                System.out.println("Maximum Number from list: " + integers.stream().max(Integer::compareTo).get());
                break;
            case 5:
                System.out.println("Current List Elements: " + integers);
                break;
            default:
                break;
        }
    }
}
