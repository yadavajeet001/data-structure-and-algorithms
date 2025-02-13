package com.example.dsa.queue;

//time complexity - O(n
public class CustomQueueMain {
    public static void main(String[] args) throws CustomQueueException {
        CustomQueue queue = new CustomQueue(5);
        CustomQueue queue2 = new CustomQueue(); // uses default capacity of 10
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        // queue.insert(6); // throws CustomQueueException: Queue is full

        queue.display();
        System.out.println("front " + queue.front());
        System.out.println("remove " + queue.remove());
        queue.display();
    }
}
