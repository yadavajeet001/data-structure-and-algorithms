package com.example.dsa.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
        // int[] nums = {1, 5, 5, 2, 2, 3, 3};
        int[] nums = {-1, -1};
        int k = 1;
        int[] ans = topKFrequentElement(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    //Brute Force
    //Time complexity - O(n log n)
    //Space Complexity - O(n)
    private static int[] topKFrequentElement(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }
}

