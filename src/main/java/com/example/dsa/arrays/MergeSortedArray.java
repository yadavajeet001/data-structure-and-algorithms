package com.example.dsa.arrays;

import java.util.Arrays;

//LeetCode easy
public class MergeSortedArray {

    public static void main(String[] args) {

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //time complexity - O(m+n)
    //space complexity - O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both nums1 and nums2
        int i = m - 1; // Last valid element in nums1
        int j = n - 1; // Last element in nums2
        int k = m + n - 1; // Last position in nums1

        // Compare and fill nums1 from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
