package com.example.dsa.queue;

public class CustomDynamicCircularQueue extends CustomCircularQueue {

    public CustomDynamicCircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CustomDynamicCircularQueue(int size) {
        super(size);
    }

    @Override
    public void insert(int item) {
        if (size == data.length) {
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            data = temp;
            front = 0;
            end = size;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
    }
}
