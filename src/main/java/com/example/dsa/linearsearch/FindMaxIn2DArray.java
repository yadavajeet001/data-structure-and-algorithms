package com.example.dsa.linearsearch;

public class FindMaxIn2DArray {
    public static void main(String[] args) {

        int[][] arr = {
                {5, 8, 9},
                {5, 10, 23, 4},
                {3, 1, 33, 2, 88}
        };
        int result = findMax(arr);
        System.out.println(result);
    }

    private static int findMax(int[][] arr) {

        int max = arr[0][0];

        for (int[] array : arr) {
            for (int element : array) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

}
