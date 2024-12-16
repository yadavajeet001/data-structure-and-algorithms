package com.example.dsa.cyclicsort;

//Leetcode
//https://leetcode.com/problems/missing-number/description/
// Asked in Amazon

/**
 * Given an array containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1};
        int res = findMissingNumber(arr);
        System.out.println(res);
    }

    private static int findMissingNumber(int[] arr) {

        //sort the array
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];

            //check if given number in array is less than the index
            //and element at index in array is not at it's correct index then swap
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                swapNumber(arr, i, correctIndex);
            } else {
                // if the given element in array is equal to arr.length
                //means it is the last element of array and element is it's correct index
                //then only increase the value of i and move forward
                i++;
            }
        }

        //search the missing index
        //return the missing index if found otherwise return the last index
        //case 1
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        //case 2 - return the last index
        return arr.length;
    }

    static void swapNumber(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
