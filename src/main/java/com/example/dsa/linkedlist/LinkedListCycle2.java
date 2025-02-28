package com.example.dsa.linkedlist;

/**
 * LeetCode - Medium
 * Amazon, Microsoft
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list
 * that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * time complexity: O(n) for both cases if cycle exist or not
 * space complexity: O(1)
 */
public class LinkedListCycle2 {
    public static void main(String[] args) {

        LinkedListCycle2 linkedListCycle = new LinkedListCycle2();
        LinkedListCycle2.addFirst(0);
        LinkedListCycle2.addFirst(2);
        LinkedListCycle2.addFirst(3);
        LinkedListCycle2.addLast(-4);
        LinkedListCycle2.display();
        System.out.println(linkedListCycle
                .detectCycle(head));
        int cycleLength = LinkedListCycle2.findLength(head);
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
    private ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //first step - find the length of the cycle
                length = findLength(slow);
                break;
            }
        }

        //second step - move the second pointer till the length of the array
        ListNode first = head;
        ListNode second = head;

        //return null of no cycle present
        if (length == 0) {
            return null;
        }

        while (length > 0) {
            second = second.next;
            length--;
        }

        //keep moving both forward first and second pointer at some time they will meet at the start point of the node
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    //find the length of the cycle
    private static int findLength(ListNode head) {
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
    private static void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    //add at last
    private static void addLast(int data) {
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
    private static void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

}
