package com.example.dsa.linearsearch;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr ={19, 18, 3, 5, 6, 2};
        int target = 2;
        int result = linearSearch(arr, target);
        System.out.println("index:" +result);
        int result2 = linearSearch2(arr, target);
        System.out.println("element:" +result2);
        boolean result3 = linearSearch3(arr, target);
        System.out.println("boolean:" +result3);

    }

    //return index
    public static int linearSearch(int[] arr, int target){

        //check empty array
        if (arr.length==0) {
            return -1;
        }

        //return index of array if target element is found
        for(int index=0; index< arr.length; index++){

            int element = arr[index];
            if (element==target)
                return index;

        }
        //if target is not found in array return -1
        return -1;
    }

    //return element
    public static int linearSearch2(int[] arr, int target){

        //return index of array if target element is found
        for (int element : arr) {
            if (element == target)
                return element;
        }
        //if target is not found in array return -1
        return -1;
    }

    //return true or false
    public static boolean linearSearch3(int[] arr, int target){

        //return index of array if target element is found
        for (int element : arr) {
            if (element == target)
                return true;

        }
        //if target is not found in array return -1
        return false;
    }
}
