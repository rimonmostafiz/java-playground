package com.rimonmostafiz.codinginterviewpatterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0 .
The solution must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicates). If no such triplets are found, return an empty array.

Each triplet can be arranged in any order, and the output can be returned in any order.

Example:
Input: nums = [0, -1, 2, -3, 1]
Output: [[-3, 1, 2], [-1, 0, 1]]

Solution: Two Pointers - Inward Traversal (With Mathematical Intonations)
 */
public class TripletSum {
    public static void main(String[] args) {
        System.out.println(triplet_sum(new ArrayList<>(Arrays.asList(0, -1, 2, -3, 1))));
    }

    public static ArrayList<ArrayList<Integer>> tripletSumBruteForce(ArrayList<Integer> nums) {
        int len = nums.size();
        HashSet<ArrayList<Integer>> sets = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums.get(i) + nums.get(j) + nums.get(k) == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums.get(i), nums.get(j), nums.get(k)));
                        triplet.sort(null);
                        sets.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(sets);
    }

    public static ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        nums.sort(null);
        int len = nums.size();
        for (int i = 0; i < len; ) {
            if (nums.get(i) > 0) {
                break;
            }
            int left = i + 1;
            int right = len - 1;
            int target = nums.get(i) * -1;
            while (left < right) {
                int sum = nums.get(left) + nums.get(right);
                if (sum == target) {
                    results.add(new ArrayList<>(Arrays.asList(nums.get(i), nums.get(left), nums.get(right))));
                    left++;
                    while (left < right && nums.get(left) == nums.get(left - 1)) {
                        left++;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;
            while (i < len && nums.get(i) == nums.get(i - 1)) {
                i++;
            }
        }
        return results;
    }
}
