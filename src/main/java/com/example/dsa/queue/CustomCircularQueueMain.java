package com.example.dsa.queue;

public class CustomCircularQueueMain {
    public static void main(String[] args) throws CustomQueueException {
        CustomCircularQueue queue = new CustomCircularQueue(5);
        CustomCircularQueue queue2 = new CustomCircularQueue(); // uses default capacity of 10
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        // queue.insert(6); // throws CustomQueueException: Queue is full

        queue.display();
        System.out.println("front " + queue.front());
        System.out.println("remove " + queue.remove());
        queue.display();
        queue.insert(60);
        queue.display();
        System.out.println("remove " + queue.remove());
        queue.display();
        queue.insert(70);
        queue.display();
    }

}
