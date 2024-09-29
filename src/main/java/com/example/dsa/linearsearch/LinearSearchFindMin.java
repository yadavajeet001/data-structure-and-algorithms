package com.example.dsa.linearsearch;

public class LinearSearchFindMin {
    public static void main(String[] args) {
        int[] arr ={19, 18, 3, 5, 6, 2};
        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {

        if (arr.length==0){
            return -1;
        }
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
