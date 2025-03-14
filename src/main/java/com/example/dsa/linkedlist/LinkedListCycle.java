package com.example.dsa.linkedlist;

/**
 * Leetcode - Easy
 * Amazon, Microsoft
 * https://leetcode.com/problems/linked-list-cycle/
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list,
 * where the tail connects to the 1st node (0-indexed).
 * time complexity: O(n) for both cases if cycle exist or not
 * space complexity: O(1)
 */
public class LinkedListCycle {
    public static void main(String[] args) {

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.addFirst(0);
        linkedListCycle.addFirst(2);
        linkedListCycle.addFirst(3);
        linkedListCycle.addLast(-4);
        linkedListCycle.display();
        System.out.println(linkedListCycle
                .hasCycle(head));
        int cycleLength = linkedListCycle.findLength(head);
        System.out.println("length of the cycle : " + cycleLength);
    }

    private static ListNode head;

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //LeetCode Solution
    private boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //find the length of the cycle
    private int findLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;

            }
        }
        return 0;
    }


    //add at first
    private void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    //add at last
    private void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            addFirst(data);
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
    }

    //display data
    private void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

}


