package com.example.dsa.binarysearch;


public class BinarySearchSortedArray {

    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 6, 7, 8};
        int target = 7;
        int result = binarySearchSortedArray(arr, target);
        System.out.println(result);
    }

    private static int binarySearchSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {

                //target element found
                return mid;
            }
        }
        //target element not found in array

               return mid;
            }
        }

        return -1;
    }
}
