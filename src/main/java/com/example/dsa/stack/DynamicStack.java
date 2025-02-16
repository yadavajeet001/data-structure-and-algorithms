package com.example.dsa.stack;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public void push(int item) {
        if (ptr == data.length - 1) {
            int[] temp = new int[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            //or
//            for(int i = 0; i < data.length; i++) {
//                temp[i] = data[i];
//            }
            data = temp;
        }
        ptr++;
        data[ptr] = item;
        //or
        //return super.push(item);
    }

}
