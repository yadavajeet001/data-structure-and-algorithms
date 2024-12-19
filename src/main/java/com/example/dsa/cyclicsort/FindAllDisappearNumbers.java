package com.example.dsa.cyclicsort;

// Leetcode
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Asked in Google(Easy), Microsoft(Medium)

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class FindAllDisappearNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 5};

        List<Integer> res = findMissingNumbers(arr);
        System.out.println(res);
    }

    private static List<Integer> findMissingNumbers(int[] arr) {

        //sort the array
        int i = 0;
        while (i < arr.length) {
            //if given input range from 1 to n then correct index will be
            int correctIndex = arr[i] - 1;

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

        //search the missing indexes
        //if element is not equals to it's correct index means index+1
        // add that element in list( index +1)
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                list.add(index + 1);
            }
        }
        return list;

    }

    static void swapNumber(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
