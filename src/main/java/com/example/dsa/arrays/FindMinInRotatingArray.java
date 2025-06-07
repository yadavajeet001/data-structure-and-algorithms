package com.example.dsa.arrays;

/**
 * LeetCode - Medium
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 */
public class FindMinInRotatingArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMin1(nums);
        System.out.println(result);
        int result2 = findMin2(nums);
        System.out.println(result2);
    }

    //Linear Search - Brute Force Approach, Time complexity - O(n), Space Complexity - O(1)
    public static int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    //Binary search - Optimal solution, Time complexity - O(log n), Space Complexity - O(1)
    public static int findMin2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
