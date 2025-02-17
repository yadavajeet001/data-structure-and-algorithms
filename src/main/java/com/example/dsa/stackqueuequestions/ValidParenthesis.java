package com.example.dsa.stackqueuequestions;

import java.util.Stack;

/**
 * Google- Easy
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Example 1:
 * Input: s = "()" Output: true
 * Example 2:
 * Input: s = "()[]{}" Output: true
 * Example 3:
 * Input: s = "(]" Output: false
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        String string = "()[]{}";
        boolean result = isValidParenthesis(string);
        System.out.println("Valid Parenthesis: " + result);
    }

    //Approach: We will use a stack to keep track of the opening brackets.
    //If we encounter a closing bracket, we will check if the top of the stack has the corresponding opening bracket.
    //If it does, we will pop the opening bracket from the stack.
    //If the stack is empty at the end, it means all brackets are valid.
    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
