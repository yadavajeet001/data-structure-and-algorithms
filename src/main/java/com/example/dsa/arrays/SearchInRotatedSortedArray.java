package com.example.dsa.arrays;

/**
 * LeetCode - Medium
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);
        System.out.println(result);
        int result2 = search2(nums, target);
        System.out.println(result2);
    }

    //Brute Force approach - Linear search, Time complexity - O(n), Space complexity - O(1)
    private static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    //Optimal approach - binary search, Time complexity - O(log n), Space complexity - O(1)
    public static int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            //if mid is equal to target element
            if (target == nums[mid]) {
                return mid;
            }

            //if first half is sorted
            if (nums[start] <= nums[mid]) {

                if (nums[start] <= target && target <= nums[mid]) {
                    // element exists
                    end = mid - 1;
                } else {
                    // element does not exist
                    start = mid + 1;
                }
            } else {
                //if second half is sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    // element exists
                    start = mid + 1;
                } else {
                    // element does not exist
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
