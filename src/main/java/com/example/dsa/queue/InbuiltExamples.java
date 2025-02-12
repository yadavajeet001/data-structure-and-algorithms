package com.example.dsa.queue;

import java.util.ArrayDeque;
import java.util.Deque;
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

        //Deque - Double Ended Queue
        // It is faster than stack and queue, It does not have capacity restrictions.
        // It is not thread safe.
        // It inserts and removes elements from both ends.
        // It does not contain any null elements.

        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);

        System.out.println("Deque after add : " + deque);

        deque.addFirst(4);
        deque.addLast(5);
        System.out.println("Deque after add first and last: " + deque);

        deque.pop();
        System.out.println("Deque after pop: " + deque);

        deque.removeFirst();
        System.out.println(
                "Deque after remove first: " + deque);

        deque.removeLast();
        System.out.println("Deque after remove last: " + deque);

        deque.push(6);
        System.out.println("Deque after push: " + deque);

        deque.offer(7);
        System.out.println("Deque after offer: " + deque);

        deque.poll();
        System.out.println("Deque after poll: " + deque);

        deque.pollFirst();
        System.out.println("Deque after poll first: " + deque);

        deque.pollLast();
        System.out.println("Deque after poll last: " + deque);

        deque.offerFirst(8);
        System.out.println("Deque after offer first: " + deque);

        deque.offerLast(9);
        System.out.println("Deque after offer last: " + deque);

    }
}
