package com.example.dsa.stackqueuequestions;

import java.util.Arrays;

/**
 * Game of Two Stacks
 * https://www.hackerrank.com/challenges/game-of-two-stacks/problem
 * [MEDIUM]
 * You have two stacks of non-negative integers, stackA and stackB where index 0 denotes the top of the stack.
 * You have to pick the maximum number of integers from either stackA or stackB subject to the condition that the sum of the integers picked from stackA and stackB is less than or equal to an integer x.
 * In other words, you have to maximize the sum of the integers picked from both the stacks.
 * Return the maximum sum.
 * <p>
 * Example:
 * stackA = [4, 2, 4, 6, 1]
 * stackB = [2, 1, 8, 5]
 * x = 10
 * The maximum number of elements that can be picked is 3 from stackA and 1 from stackB.
 * The sum of the elements is 4 + 4 + 2 + 1 = 11.
 * So, the output is 11.
 * stackA = [4, 2, 4, 6, 1]
 * stackB = [2, 1, 8, 5]    x = 15
 * The maximum number of elements that can be picked is 4 from stackA and 1 from stackB.
 * The sum of the elements is 4 + 2 + 4 + 6 + 1 = 17.
 * So, the output is 17.
 */
public class GameOfTwoStacks {

    /**
     * Approach:
     * 1. We will use two pointers to keep track of the elements in stackA and stackB.
     * 2. We will keep adding elements from stackA to the sum until the sum exceeds x.
     * 3. If the sum exceeds x, we will remove elements from stackA and add elements from stackB until the sum is less than x.
     * 4. We will keep track of the maximum sum.
     * 5. Finally, we will return the maximum sum.
     */


    private static int twoStacks(int maxAllowedSum, int[] stackA, int[] stackB) {
        //We will use a helper function to calculate the maximum number of elements that can be picked from both the stacks
        return twoStacks(maxAllowedSum, stackA, stackB, 0, 0) - 1;
    }

    //Helper function to calculate the maximum number of elements that can be picked from both the stacks
    private static int twoStacks(int maxAllowedSum, int[] stackA, int[] stackB, int sum, int count) {

        //If the sum exceeds the maximum allowed sum, we will return the count
        if (sum > maxAllowedSum) {
            return count;
        }

        //If both the stacks are empty, we will return the count
        if (stackA.length == 0 || stackB.length == 0) {
            return count;
        }

        //We will calculate the maximum number of elements that can be picked from both the stacks
        int ans1 = twoStacks(maxAllowedSum, Arrays.copyOfRange(stackA, 1, stackA.length), stackB, sum + stackA[0], count + 1);
        int ans2 = twoStacks(maxAllowedSum, stackA, Arrays.copyOfRange(stackB, 1, stackB.length), sum + stackB[0], count + 1);

        //We will return the maximum of the two answers
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] stackA = {4, 2, 4, 6, 1};
        int[] stackB = {2, 1, 8, 5};
        int maxAllowedSum = 10;
        System.out.println(twoStacks(maxAllowedSum, stackA, stackB)); //11
    }
}
