package com.example.dsa.linkedlist;

public class CustomCircularLinkedList {

    public static void main(String[] args) {
        CustomCircularLinkedList customCircularLinkedList = new CustomCircularLinkedList();
        customCircularLinkedList.addFirst(10);
        customCircularLinkedList.addFirst(20);
        customCircularLinkedList.addFirst(30);
        customCircularLinkedList.addFirst(40);
        customCircularLinkedList.display();
        customCircularLinkedList.addLast(50);
        customCircularLinkedList.display();
        customCircularLinkedList.insert(60, 2);
        customCircularLinkedList.display();
        customCircularLinkedList.deleteFirst();
        customCircularLinkedList.display();
        customCircularLinkedList.deleteLast();
        customCircularLinkedList.display();
        customCircularLinkedList.delete(2);
        customCircularLinkedList.display();
    }

    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }


    private void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            addFirst(data);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    private void insert(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    private void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        tail.next = head;
    }

    private void deleteLast() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    private void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    private void display() {
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }
}
