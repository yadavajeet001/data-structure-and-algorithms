package com.example.dsa.arrays;

//LeetCode easy
// time complexity O(n) and space complexity 0(1)
public class removeDuplicate {
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int result = removeDuplicates(new int[]{1, 1, 2, 2, 2});
        System.out.println(result);
    }
}
