package com.example.dsa.stackqueuequestions;

import java.util.Stack;

//this is insertion in O(1) and deletion in O(n) means its insertion efficient
class MyQueueInsertionEfficient {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueueInsertionEfficient() {
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        //removing all elements from stack1 and pushing them to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        //popping the top element from stack2
        int popped = stack2.pop();

        //pushing back all elements from stack2 to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return popped;
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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */