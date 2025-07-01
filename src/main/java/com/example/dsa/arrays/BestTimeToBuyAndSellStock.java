package com.example.dsa.arrays;

/**
 * LeetCode - Easy
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * Time Complexity - O(n)
 * Space complexity - O(1)
 */

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int res = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
        int res2 = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res2);
    }

    //Brute Force Approach
    //Time Complexity - O(n^2)
    //Space Complexity - O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit, res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = prices[j] - prices[i];
                    res = Math.max(res, maxProfit);
                }
            }
        }
        return res;
    }

    //Optimal Approach - Two Pointer
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int maxProfit2(int[] prices) {

        int maxProfit = 0;
        int left = 0, right = 1;
        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return maxProfit;
    }
}

