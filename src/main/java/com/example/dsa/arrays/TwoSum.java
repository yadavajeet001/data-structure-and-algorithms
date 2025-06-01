package com.example.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode - Medium
 * https://leetcode.com/problems/two-sum/description/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Time Complexity - O(n^2)
 * Follow up : can you solve this in less than O(n^2) time complexity
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 11};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Result of two sum : " + Arrays.toString(result));
        int[] result2 = twoSum2(nums, target);
        System.out.println("Result of two sum 2: " + Arrays.toString(result2));
    }

    //Brute force - Time complexity - O(n^2)
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //Time complexity - O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
