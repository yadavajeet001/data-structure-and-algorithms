package linearsearch;

import java.util.Arrays;

public class SearchIn2DArray {

    public static void main(String[] args) {

        int[][] arr = {
                {5, 8, 9},
                {5, 10, 23, 4},
                {3, 1, 33, 2, 88}
        };
        int target = 1;
        int[] result = search(arr, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] search(int[][] arr, int target) {

        for (int row=0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++) {
               if (arr[row][col]==target){
                  return new int[]{row, col};
               }
            }
        }
        return new int[]{-1, -1};
    }
}
