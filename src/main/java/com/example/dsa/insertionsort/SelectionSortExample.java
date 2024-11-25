package com.example.dsa.insertionsort;

import java.util.Arrays;

public class SelectionSortExample {

    static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            // find the max item in remaining array and swapped with correct index
            int start = 0;
            int end = array.length - i - 1;

            int maxIndex = findMaxElement(array, start, end);
            swap(array, maxIndex, end);
        }
    }

    private static int findMaxElement(int[] array, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (array[max] < array[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] array, int maxIndex, int end) {
        int temp = array[maxIndex];
        array[maxIndex] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 1, 2, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
