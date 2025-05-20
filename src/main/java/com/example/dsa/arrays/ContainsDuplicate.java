package com.example.dsa.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode - Easy
 * https://leetcode.com/problems/contains-duplicate/
 * Given an integer array nums, return true
 * if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * All elements are distinct
 */
public class ContainsDuplicate {

    //brute force approach, time-complexity - O(n^2)
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //time-complexity - O(n)
    public static boolean containsDuplicateValue(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 1)
                return true;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        // System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicateValue(nums));
    }
}
