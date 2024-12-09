package com.example.dsa.insertionsort;

import java.util.Arrays;

/**
 * Space complexity - O(1)
 * Time complexity
 * Best case - O(n)
 * Worst case - O(n^2)
 */
public class InsertionSortExample {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapNumber(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swapNumber(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
