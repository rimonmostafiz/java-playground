package com.rimonmostafiz.codinginterviewpatterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers sorted in ascending order and a target value,
return the indexes of any pair of numbers in the array that sum to the target.
The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

Example 1:
Input: nums = [-5, -2, 3, 4, 6], target = 7
Output: [2, 3]

Example 2:
Input: nums = [1, 1, 1], target = 2
Output: [0, 1]

Solution: Two Pointers - Inward Traversal
 */
public class PairSomeSorted {
    public static void main(String... args) {
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(-5, -2, 3, 4, 6)), 7));
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(-1, 1, 1)), 2));
        System.out.println(pair_sum_sorted(new ArrayList<>(), 0));
        System.out.println(pair_sum_sorted(new ArrayList<>(List.of(1)), 1));
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(2, 3)), 5));
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(2, 4)), 5));
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(2, 2, 3)), 5));
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(-1, 2, 3)), 2));
        System.out.println(pair_sum_sorted(new ArrayList<>(Arrays.asList(-3, -2, -1)), -5));
    }

    public static ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        ArrayList<Integer> results = new ArrayList<>();
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == target) {
                results.add(left);
                results.add(right);
                break;
            } else if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return results;
    }
}
