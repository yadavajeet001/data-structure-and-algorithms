package com.example.dsa.linkedlist;

public class CustomLinkedList {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addFirst(10);
        customLinkedList.addFirst(20);
        customLinkedList.addFirst(30);
        customLinkedList.display();
        customLinkedList.addLast(40);
        customLinkedList.display();
        customLinkedList.insert(25, 2);
        customLinkedList.display();
        customLinkedList.deleteFirst();
        customLinkedList.display();
        customLinkedList.deleteLast();
        customLinkedList.display();
        customLinkedList.delete(1);
        customLinkedList.display();
        System.out.println(customLinkedList.find(25));
        customLinkedList.display();
    }

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //inner class Node
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //add at first
    private void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    //add at last
    private void addLast(int data) {
        if (tail == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //insert at given index
    private void insert(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        //or
        //Node newNode = new Node(data, temp.next);
        //temp.next = newNode;
        size++;
    }

    //delete first
    private void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }
    }

    //delete last
    private void deleteLast() {
        if (head == null) {
            return;
        }

        if (size <= 1) {
            deleteFirst();
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    //delete at given index
    private void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    //find data
    private int find(int data) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    //display data
    private void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

}
