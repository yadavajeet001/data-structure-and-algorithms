package com.example.dsa.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * Time Complexity - O(n)
 * Space Complexity -  O(1)
 */
public class MaxProductSubArraySum {

    //Kadane's Algorithm
    public static int maxProductSum1(int[] nums) {

        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // Swap max and min when negative number is encountered
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    //Optimal solution, two pointers method
    public static int maxProductSum2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            maxSum = Math.max(maxSum, Math.max(prefix, suffix));
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
        }
        return maxSum;
    }

    //find the maxProduct SubArray
    public static int[] maxProductSubArray(int[] nums) {

        if (nums == null || nums.length == 0) return new int[0];

        int max = nums[0]; // max product ending at current index
        int min = nums[0]; // min product ending at current index
        int maxProduct = nums[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                // Swap max and min when current is negative
                int temp = max;
                max = min;
                min = temp;
            }

            // Either take current or extend the previous product subarray
            if (current > current * max) {
                max = current;
                tempStart = i; // start a new subarray
            } else {
                max = current * max;
            }

            min = Math.min(current, current * min);

            if (max > maxProduct) {
                maxProduct = max;
                start = tempStart;
                end = i + 1;
            }
        }

        int[] resultSubArray = Arrays.copyOfRange(nums, start, end);
        System.out.println("Max Product: " + maxProduct);
        System.out.println("Subarray: " + Arrays.toString(resultSubArray));

        return resultSubArray;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProductSum1(nums));
        System.out.println(maxProductSum2(nums));
        maxProductSubArray(nums);

    }
}
