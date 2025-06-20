package com.example.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode - Easy
 * https://leetcode.com/problems/valid-anagram/description/
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        System.out.println(isAnagram1(str1, str2));
        System.out.println(isAnagram2(str1, str2));
    }

    public static boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sCount.put(s.charAt(i), 1 + sCount.getOrDefault(s.charAt(i), 0));
            tCount.put(t.charAt(i), 1 + tCount.getOrDefault(t.charAt(i), 0));
        }

        return sCount.equals(tCount);
    }
}