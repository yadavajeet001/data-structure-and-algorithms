package com.example.dsa.queue;

public class CustomDynamicCircularQueueMain {
    public static void main(String[] args) throws CustomQueueException {
        CustomDynamicCircularQueue queue = new CustomDynamicCircularQueue(5);
        CustomDynamicCircularQueue queue2 = new CustomDynamicCircularQueue(); // uses default capacity of 10
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.display();
    }
}
