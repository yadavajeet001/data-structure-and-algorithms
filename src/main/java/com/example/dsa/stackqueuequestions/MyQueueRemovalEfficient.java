package com.example.dsa.stackqueuequestions;

import java.util.Stack;

//this is removal efficient queue means its deletion in O(1) and insertion in O(n)
//Google- Easy
public class MyQueueRemovalEfficient {

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public MyQueueRemovalEfficient() {
    }

    public void push(int x) {
        //removing all elements from stack1 and pushing them to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //pushing new element to stack1
        stack1.push(x);
        //pushing back all elements from stack2 to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public void display() {
        for (Integer integer : stack1) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
