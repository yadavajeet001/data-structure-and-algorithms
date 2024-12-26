package com.example.dsa.cyclicsort;

// Leetcode
// https://leetcode.com/problems/set-mismatch/description/
//
// You have a set of integers s, which originally contains all the numbers from 1 to n.
// Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
// which results in repetition of one number and loss of another number.
// You are given an integer array nums representing the data status of this set after the error.
// Find the number that occurs twice and the number that is missing and return them in the form of an array.
// Amazon

import java.util.Arrays;

public class SetMisMatch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 2};
        int[] res = findErrorNumbers(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findErrorNumbers(int[] arr) {

        //sort the array
        int i = 0;
        while (i < arr.length) {
            //if given input range from 0 to n then correct index will be
            int correctIndex = arr[i];

            //check element at index in array is not at it's correct index then swap
            if (arr[i] != arr[correctIndex]) {
                swapNumber(arr, i, correctIndex);
            } else {
                // if the given element in array is equal to arr.length
                //means it is the last element of array and element is it's correct index
                //then only increase the value of i and move forward
                i++;
            }
        }

        //search the missing index
        //return the missing index if found and repeating element
        //case 1
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return new int[]{index, arr[index]};
            }
        }

        //case 2 - return the -1, -1
        return new int[]{-1, -1};
    }

    static void swapNumber(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
