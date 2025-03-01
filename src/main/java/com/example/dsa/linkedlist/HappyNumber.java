package com.example.dsa.linkedlist;

/**
 * LeetCode -Easy
 * Google
 * https://leetcode.com/problems/happy-number/description/
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * Input: n = 2
 * Output: false
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class HappyNumber {
    public static void main(String[] args) {

        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }

    //Leetcode solution
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;

        //or
//        if (slow ==1){
//            return true;
//        } else {
//            return  false;
//        }
    }

    public int findSquare(int n) {
        int res = 0;
        while (n > 0) {
            int remainder = n % 10;
            res = res + remainder * remainder;
            n = n / 10;
        }
        return res;
    }
}
