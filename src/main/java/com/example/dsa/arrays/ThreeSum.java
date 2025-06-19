package com.example.dsa.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * LeetCode - Medium
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Brute Force Solution: " + result);
        List<List<Integer>> result2 = threeSum2(nums);
        System.out.println("Better Solution: " + result2);
        List<List<Integer>> result3 = threeSum3(nums);
        System.out.println("Optimal Solution " + result3);
    }

    //Brute Force Approach
    //Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array, O(n^3)
    //Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
    private static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> setList = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                        tempList.sort(null); // sort element in natural order
                        setList.add(tempList);
                    }
                }
            }
        }
        return new ArrayList<>(setList);
    }

    //Better Approach
    //Time Complexity: O(N^2 * log(no. of unique triplets)), O(n^2)
    //Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
    private static List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> setList = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);

                if (set.contains(third)) {
                    int sum = nums[i] + nums[j] + third;
                    if (sum == 0) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], third);
                        tempList.sort(null); // sort element in natural order
                        setList.add(tempList);
                    }
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(setList);
    }

    //Optimal Solution
    //Time Complexity: O(NlogN)+O(N^2) = O(N^2) where N = size of the array.
    //Space Complexity: O(1)
    private static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            //remove duplicates
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //moving two pointers
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                    lists.add(tempList);
                    j++;
                    k--;

                    //skip the duplicates
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return lists;
    }

}
