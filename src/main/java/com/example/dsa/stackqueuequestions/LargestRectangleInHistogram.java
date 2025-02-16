package com.example.dsa.stackqueuequestions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The largest rectangle is shown in the above picture, which has an area = 10.
 * LeetCode: Hard
 * Amazon: Onsite
 * Google: Onsite
 * Facebook: Onsite
 * Microsoft: Onsite
 * Apple: Onsite
 * Bloomberg: Onsite
 * Uber: Onsite
 * Adobe: Onsite
 * Oracle: Onsite
 * LinkedIn: Onsite
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //        int[] heights = {2, 4};
        System.out.println("Largest Rectangle in Histogram: " + largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
