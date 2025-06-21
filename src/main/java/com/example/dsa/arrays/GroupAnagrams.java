package com.example.dsa.arrays;

import java.util.*;

/**
 * LeetCode - Medium
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * Example 1:
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 * Input: strs = ["x"]
 * Output: [["x"]]
 * Example 3:
 * Input: strs = [""]
 * Output: [[""]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> result = groupAnagrams1(str);
        System.out.println(result);
    }

    //Time Complexity - O(m * n log n)
    //Space Complexity - O(m * n)
    //Using Sorting
    //Where m  is the number of strings an n is the length of the longest string
    public static List<List<String>> groupAnagrams1(String[] str) {
        Map<String, List<String>> listMap = new HashMap<>();

        for (String s : str) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            listMap.putIfAbsent(sortedString, new ArrayList<>());
            listMap.get(sortedString).add(s);
        }
        return new ArrayList<>(listMap.values());
    }

    //Using HashTable
    //Time Complexity - O(m * n)
    //Space Complexity - O(m * n)
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
