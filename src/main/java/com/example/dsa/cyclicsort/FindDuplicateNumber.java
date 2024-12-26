package com.example.dsa.cyclicsort;

// LeetCode
//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears at most twice,
// return an array of all the integers that appears twice.
//You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

// Amazon (medium)
public class FindDuplicateNumber {
    public static void main(String[] args) {

        int[] arr = {1, 4, 4, 3, 2};
        int res = findDuplicate(arr);
        System.out.println(res);
    }

    public static int findDuplicate(int[] arr) {

        int i = 0;
        while (i < arr.length) {

            //check if element in not equal to index+1
            if (arr[i] != i + 1) {

                int correctIndex = arr[i] - 1;

                if (arr[i] != arr[correctIndex])
                    swapNumber(arr, i, correctIndex);
                else {
                    return arr[i];
                }
            } else {
                i++;
            }

        }

        return -1;
    }

    static void swapNumber(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
