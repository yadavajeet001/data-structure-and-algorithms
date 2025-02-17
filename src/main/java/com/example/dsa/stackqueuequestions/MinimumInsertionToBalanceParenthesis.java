package com.example.dsa.stackqueuequestions;

import java.util.Stack;

/**
 * Google-Medium
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * Example 1:
 * Input: s = "(()))" Output: 1
 * Explanation: The second '(' has two consecutive '))', which makes the string balanced.
 * Example 2:
 * Input: s = "())" Output: 0
 * Explanation: The string is already balanced.
 * time complexity: O(n)
 * space complexity: O(n)
 */

public class MinimumInsertionToBalanceParenthesis {
    public static void main(String[] args) {
        String string = "(()))"; //output: 1
        String string1 = "())"; //output: 0
        String string2 = "))())("; //output: 3

        int result = minInsertions(string2);
        System.out.println("Minimum Insertions to Balance Parenthesis: " + result);
    }
    //Approach: We will use a stack to keep track of the opening brackets.
    //If we encounter a closing bracket, we will check if the top of the stack has the corresponding opening bracket.
    //If it does, we will pop the opening bracket from the stack.
    //If the stack is empty at the end, it means all brackets are valid.

    private static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                i++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (stack.isEmpty()) {
                        count++;
                    } else {
                        stack.pop();
                    }
                    i += 2;
                } else {
                    if (stack.isEmpty()) {
                        count += 2;
                    } else {
                        stack.pop();
                        count++;
                    }
                    i++;
                }
            }
        }
        return count + stack.size() * 2;
    }
}
