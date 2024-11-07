package com.example.dsa.bubblesort;

import java.util.Arrays;

/**
 * space complexity O(1) constant
 * time complexity
 * best case - O(n)
 * worst case - O(n^2)
 */
public class BubbleSortExample {

    static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 5, 4}; //unsorted array
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 2, 3, 4}; //sorted array
        // bubbleSort(arr1);
        // System.out.println(Arrays.toString(arr1));
    }
}
