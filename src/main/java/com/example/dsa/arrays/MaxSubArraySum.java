package com.example.dsa.arrays;

/**
 * LeetCode - Easy
 * https://leetcode.com/problems/maximum-subarray/description/
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 * Kadane's Algorithm
 */
public class MaxSubArraySum {

    //approach-1 brute force
    //Time Complexity - O(n^3)
    public static int maxSubArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                    maxSum = Math.max(sum, maxSum);

                }
            }
        }
        return maxSum;
    }

    // approach-2
    //Time Complexity - O(n^2)
    public static int maxSubArraySum2(int[] nums) {
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum = currentSum + nums[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }

    //approach-3
    //Time Complexity - O(n)
    public static int maxSubArraySum3(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    //approach-4
    //Time Complexity - O(n)
    public static int maxSubArraySum4(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(nums));
        System.out.println(maxSubArraySum2(nums));
        System.out.println(maxSubArraySum3(nums));
        System.out.println(maxSubArraySum4(nums));
    }
}
