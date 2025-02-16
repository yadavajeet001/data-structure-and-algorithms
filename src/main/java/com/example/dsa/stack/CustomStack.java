package com.example.dsa.stack;

public class CustomStack {

    int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    int ptr= -1;

    public CustomStack() {
        this(DEFAULT_CAPACITY);
    }

    public CustomStack(int size) {
        this.data = new int[ size ];
    }

    public void push(int item) throws CustomStackException {
        if (ptr == data.length-1) {
            throw new CustomStackException("Stack is full");
        }
        ptr++;
        data[ptr] = item;
    }

    public int pop() throws CustomStackException {
        if (ptr == -1) {
            throw new CustomStackException("Stack is empty");
        }
        return data[ptr--];
    }

    public int peek() throws CustomStackException {
        if (ptr == -1) {
            throw new CustomStackException("Stack is empty");
        }
        return data[ptr];
    }
}
