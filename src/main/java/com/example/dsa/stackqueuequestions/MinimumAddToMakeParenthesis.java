package com.example.dsa.stackqueuequestions;

import java.util.Stack;

/**
 * Google- Medium
 * Facebook- Medium
 * Amazon- Medium
 * Microsoft- Medium
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
 * so that the resulting parentheses string is valid.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * Example 1:
 * Input: "())"
 * Output: 1
 * Example 2:
 * Input: "((("
 * Output: 3
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class MinimumAddToMakeParenthesis {
    public static void main(String[] args) {
        String string = "())"; //output: 1
        String string1 = "((("; //output: 3
        String string2 = "(()("; //output: 2

        int result = minAddToMakeValid(string2);
        System.out.println("Minimum Add to Make Parenthesis Valid: " + result);

        //Valid Parenthesis count-another approach
        int validParenthesisCount = minAddToMakeValidParenthesis(string2);
        System.out.println("Valid Parenthesis count: " + validParenthesisCount);
    }

    //Approach: We will use a stack to keep track of the opening brackets.
    //If we encounter a closing bracket, we will check if the top of the stack has the corresponding opening bracket.
    //If it does, we will pop the opening bracket from the stack.
    //If the stack is empty at the end, it means all brackets are valid.
    private static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        //returning the count of remaining brackets in the stack and the count of invalid brackets
        return count + stack.size();
    }

    //Valid Parenthesis count-another approach
    private static int minAddToMakeValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}
