package com.example.dsa.cyclicsort;

// https://leetcode.com/problems/first-missing-positive/description/
//Amazon (Hard)
public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1};
        int res = findMissingNumber(nums);
        System.out.println(res);
    }

    private static int findMissingNumber(int[] nums) {

        //sort the array
        int i = 0;
        while (i < nums.length) {
            //if given input range from 1 to n then correct index will be
            int correctIndex = nums[i] - 1;

            //check if given number in array is greater than zero and less than the index
            //and element at index in array is not at it's correct index then swap
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                swapNumber(nums, i, correctIndex);
            } else {
                // if the given element in array is equal to nums.length
                //means it is the last element of array and element is it's correct index
                //then only increase the value of i and move forward
                i++;
            }
        }

        //search the missing positive index
        //return the missing index if found otherwise return the last index+1
        //case 1
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        //case 2 - return the last index+1
        return nums.length + 1;
    }

    static void swapNumber(int[] nums, int i, int correctIndex) {
        int temp = nums[i];
        nums[i] = nums[correctIndex];
        nums[correctIndex] = temp;
    }
}
