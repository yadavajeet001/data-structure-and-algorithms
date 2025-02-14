package com.example.dsa.queue;

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

        //custom dynamic queue
        CustomDynamicCircularQueue dynamicQueue = new CustomDynamicCircularQueue(5);
        dynamicQueue.insert(1);
        dynamicQueue.insert(2);
        dynamicQueue.insert(3);
        dynamicQueue.insert(4);
        dynamicQueue.insert(5);
        dynamicQueue.insert(6);
        dynamicQueue.insert(7);
        dynamicQueue.display();
    }
}
