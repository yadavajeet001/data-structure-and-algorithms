package com.example.dsa.stackqueuequestions;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
 * In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 * (Amortized - amortized analysis is a method for analyzing a given algorithm's complexity,
 * or how much of a resource, especially time or memory, it takes to execute
 * LeetCode: Google-Easy
 */
public class ImplementQueueUSingStacks {

    public static void main(String[] args) {
        MyQueueInsertionEfficient queue = new MyQueueInsertionEfficient();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.display();
        System.out.println("peek() : " + queue.peek());
        System.out.println("pop() : " + queue.pop());
        System.out.println("empty() : " + queue.empty());
        queue.push(5);
        queue.display();
        System.out.println("peek() : " + queue.peek());
        System.out.println("pop() : " + queue.pop());
        queue.display();
        //write a function to print the all element of queue in FIFO order
        System.out.println("Queue elements in FIFO order: " + queue);

        //removal efficient queue
        MyQueueRemovalEfficient queue1 = new MyQueueRemovalEfficient();
        queue1.push(10);
        queue1.push(20);
        queue1.push(30);
        queue1.push(40);
        queue1.display();
        System.out.println("peek() : " + queue1.peek());
        System.out.println("pop() : " + queue1.pop());
        System.out.println("empty() : " + queue1.empty());
        queue1.push(50);
        queue1.display();
        System.out.println("peek() : " + queue1.peek());
        System.out.println("pop() : " + queue1.pop());
        queue1.display();


    }
}
