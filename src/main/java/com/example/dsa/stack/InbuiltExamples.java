package com.example.dsa.stack;

import java.util.Stack;

public class InbuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);

        System.out.println("pop " + stack.pop());
        System.out.println(stack);
        System.out.println("pop " + stack.pop());
        System.out.println(stack);

        System.out.println("getFirst " + stack.getFirst());
        System.out.println("getLast " + stack.lastElement());

        System.out.println("add " + stack.add(4));
        System.out.println(stack);

        System.out.println("search 4 " + stack.search(4));
        System.out.println("search 5 " + stack.search(5));

        System.out.println("peek " + stack.peek());
    }
}
