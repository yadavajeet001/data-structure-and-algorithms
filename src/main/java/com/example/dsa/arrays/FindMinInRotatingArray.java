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
        int result3 = findMin3(nums);
        System.out.println(result3);
        int result4 = findMin4(nums);
        System.out.println(result4);
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

    /**
     * Time Complexity: O(logN), N = size of the given array.
     * Reason: We are basically using binary search to find the minimum.
     * Space Complexity: O(1)
     * Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
     *
     * @param nums array
     * @return int
     */
    public static int findMin2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (start < end) {
            int mid = (start + end) / 2;

            //if left part of array is sorted
            if (nums[start] <= nums[mid]) {

                //keep the minimum leftmost value
                ans = Math.min(ans, nums[start]);

                //eliminate left half
                start = mid + 1;

            } else {

                //if right part of array is sorted
                //keep the minimum leftmost value
                ans = Math.min(ans, nums[mid]);

                //eliminate right half
                end = mid - 1;
            }
        }
        return ans;
    }

    //Note: Though the time complexity of the following code is the same as the previous one,
    // this code will run slightly faster.
    public static int findMin3(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (start < end) {
            int mid = (start + end) / 2;

            //search space is already sorted
            //then nums[start] will always be
            //the minimum in that search space:
            if (nums[start] <= nums[end]) {
                ans = Math.min(ans, nums[start]);
                break;
            }

            //if left part of array is sorted
            if (nums[start] <= nums[mid]) {

                //keep the minimum leftmost value
                ans = Math.min(ans, nums[start]);

                //eliminate left half
                start = mid + 1;

            } else {

                //if right part of array is sorted
                //keep the minimum leftmost value
                ans = Math.min(ans, nums[mid]);

                //eliminate right half
                end = mid - 1;
            }
        }
        return ans;
    }

    //Binary search - Time complexity - O(log n), Space Complexity - O(1)
    public static int findMin4(int[] nums) {
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
