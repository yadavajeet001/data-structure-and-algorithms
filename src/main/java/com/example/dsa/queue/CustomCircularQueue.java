package com.example.dsa.queue;

public class CustomCircularQueue {
    protected int[] data;
    static final int DEFAULT_CAPACITY = 10;
    protected int end = 0;
    protected int front = 0;
    protected int size = 0;

    public CustomCircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CustomCircularQueue(int size) {
        this.data = new int[size];
    }

    public void insert(int item) throws CustomQueueException {
        if (size == data.length) {
            throw new CustomQueueException("Queue is full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
    }

    public int remove() throws CustomQueueException {
        if (size == 0) {
            throw new CustomQueueException("Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws CustomQueueException {
        if (size == 0) {
            throw new CustomQueueException("Queue is empty");
        }
        return data[front];
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % data.length] + " ");
        }
        System.out.println();
    }
}
