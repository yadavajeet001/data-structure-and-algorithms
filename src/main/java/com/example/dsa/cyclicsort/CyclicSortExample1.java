package com.example.dsa.cyclicsort;

import java.util.Arrays;

/**
 * Method 1: This method is only applicable when given array values or elements are in
 * the range of 1 to N or 0 to N.
 * Time Complexity
 * Worst Case : O(n)
 * Average Case: O(n)
 * Best Case : O(n)
 * Space complexity: O(1)
 */
public class CyclicSortExample1 {
    public static void main(String[] args) {

        int[] arr = {5, 2, 3, 1, 4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swapNumber(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swapNumber(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
