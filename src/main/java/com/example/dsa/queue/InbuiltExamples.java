package com.example.dsa.queue;

import java.util.Queue;

public class InbuiltExamples {
    public static void main(String[] args) {
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue);

        System.out.println("remove " + queue.remove());
        System.out.println(queue);
        System.out.println("remove " + queue.remove());
        System.out.println(queue);

        System.out.println("element " + queue.element());
        System.out.println("peek " + queue.peek());

        System.out.println("add " + queue.add(4));
        System.out.println(queue);

        System.out.println("offer " + queue.offer(5));
        System.out.println(queue);

        System.out.println("poll " + queue.poll());
        System.out.println(queue);

        System.out.println("remove " + queue.remove());
    }
}
