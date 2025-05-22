package com.example.dsa.arrays;

/**
 * Kadane's Algorithm
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class MaxSubArray {
    public static int[] maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        return new int[]{maxSum, start, end};
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArray(nums);
        System.out.println("MaxSum of subArray :" + result[0]);
        System.out.println("MaxSum subArray start index:" + result[1]);
        System.out.println("MaxSum subArray end index :" + result[2]);

        System.out.println("Max SubArray : ");
        for (int i = result[1]; i <= result[2]; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
