package com.example.dsa.linkedlist;

public class CustomDoublyLinkedList {
    public static void main(String[] args) {
        CustomDoublyLinkedList customDoublyLinkedList = new CustomDoublyLinkedList();
        customDoublyLinkedList.addFirst(11);
        customDoublyLinkedList.addFirst(12);
        customDoublyLinkedList.addFirst(13);
        customDoublyLinkedList.addFirst(14);
        customDoublyLinkedList.display();
        customDoublyLinkedList.addLast(40);
        customDoublyLinkedList.display();
        customDoublyLinkedList.insert(25, 2);
        customDoublyLinkedList.display();
        customDoublyLinkedList.deleteFirst();
        customDoublyLinkedList.display();
        customDoublyLinkedList.deleteLast();
        customDoublyLinkedList.display();
        customDoublyLinkedList.delete(2);
        customDoublyLinkedList.display();
    }

    private Node head;

    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    private void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    private void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    private void insert(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    private void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        head.prev = null;
    }

    private void deleteLast() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
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
        temp.next.prev = temp;
    }

    private void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
