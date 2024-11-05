package com.example.dsa.linearsearch;

public class LinearSearchFindMax {

    public static void main(String[] args) {
        int[] arr = {19, 18, 3, 5, 6, 2, 34};
        System.out.println(findMax(arr));
    }

    private static int findMax(int[] arr) {

        //check empty array
        if (arr.length == 0) {
            return -1;
        }

        //return max value
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
