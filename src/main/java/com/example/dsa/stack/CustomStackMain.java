package com.example.dsa.stack;

//time complexity: O(n)
public class CustomStackMain {
    public static void main(String[] args) throws CustomStackException {
        CustomStack stack = new CustomStack(5);
        CustomStack stack2 = new CustomStack(); // uses default capacity of 10

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //   stack.push(6);     // throws CustomStackException: Stack is full

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        //   System.out.println("Peek: " + stack.peek()); // throws CustomStackException: Stack is empty
        //   System.out.println("Pop: " + stack.pop()); // throws CustomStackException: Stack is empty

        //Dynamic stack
        DynamicStack dynamicStack = new DynamicStack(5);
        dynamicStack.push(1);
        dynamicStack.push(2);
        dynamicStack.push(3);
        dynamicStack.push(4);
        dynamicStack.push(5);
        dynamicStack.push(6);
        dynamicStack.push(7);
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Pop: " + dynamicStack.pop());
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Pop: " + dynamicStack.pop());
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Pop: " + dynamicStack.pop());
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Pop: " + dynamicStack.pop());
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Pop: " + dynamicStack.pop());
        System.out.println("Peek: " + dynamicStack.peek());
        System.out.println("Pop: " + dynamicStack.pop());

    }
}
