package com.example.dsa.arrays;

import java.util.Arrays;

/**
 * LeetCode - Medium
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] productSum = productArrayExceptSelf(nums);
        System.out.println(Arrays.toString(productSum));
        int[] productSum2 = productArrayExceptSelf2(nums);
        System.out.println(Arrays.toString(productSum2));
    }

    //Brute Force - Time complexity - O(n^2), Space complexityO(n)
    private static int[] productArrayExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            ans[i] = product;
        }
        return ans;
    }

    //Optimal Solution - Time complexity - O(n), Space complexityO(1)
    private static int[] productArrayExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
