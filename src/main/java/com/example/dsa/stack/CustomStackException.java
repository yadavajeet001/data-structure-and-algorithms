package com.example.dsa.stack;

public class CustomStackException extends Exception {

    public CustomStackException(String message) {
        super(message);
    }


        @Override
        public String toString() {
            return "CustomException: " + getMessage();
        }
    }

