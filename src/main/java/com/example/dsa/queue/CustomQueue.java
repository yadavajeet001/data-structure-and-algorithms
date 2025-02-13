package com.example.dsa.queue;

//time complexity - O(n)
public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    int end = 0;

    public CustomQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public int insert(int item) throws CustomQueueException {
        if (end == data.length) {
            throw new CustomQueueException("Queue is full");
        }
        data[end++] = item;
        return item;
    }

    public int remove() throws CustomQueueException {
        if (end == 0) {
            throw new CustomQueueException("Queue is empty");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws CustomQueueException {
        if (end == 0) {
            throw new CustomQueueException("Queue is empty");
        }
        return data[0];
    }

     public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
         System.out.println();
     }
}
