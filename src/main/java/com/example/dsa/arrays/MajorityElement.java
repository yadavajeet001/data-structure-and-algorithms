package leetcode.arrays;

import java.util.Arrays;

//Time Complexity O(n log n and space complexity O(1)
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        System.out.println(nums[n/2]);
        return nums[n/2];
    }

    public static void main(String[] args) {
        majorityElement(new int[]{4, 4, 4, 3, 3, 3, 5, 5, 5, 5});
    }
}

