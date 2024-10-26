package leetcode.arrays;

import java.util.Arrays;

//LeetCode easy
public class MergeSortedArray {
   //time complexity O(m+n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];

            } else {
                nums1[k--] = nums2[j--];

            }
           // System.out.println(nums1[k]);
        }


        // time complexity O(n)
        //or
        for (int a = 0; a< n ; a++){
            nums1[a+m] = nums2[a];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {

     merge(new int[]{1,2,3,0, 0,0}, 3, new int[]{2, 5, 6}, 3);
    }
}
