package com.example.dsa.linkedlist;

/**
 * LeetCode - Medium
 * Google, Microsoft, Amazon, Facebook
 * https://leetcode.com/problems/rotate-list/description/
 * Given the head of a linked list, rotate the list to the right by k places.
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * Space complexity - O(1)
 * Time complexity - O(n)
 */
public class RotateLinkedListKTimes {
    public static void main(String[] args) {
        RotateLinkedListKTimes rotateLinkedListKTimes = new RotateLinkedListKTimes();
//        rotateLinkedListKTimes.addFirst(6);
//        rotateLinkedListKTimes.addFirst(5);
//        rotateLinkedListKTimes.addFirst(4);
//        rotateLinkedListKTimes.addFirst(3);
//        rotateLinkedListKTimes.addFirst(2);
//        rotateLinkedListKTimes.addFirst(1);
//        rotateLinkedListKTimes.display(head);
//        int k = 2;


        rotateLinkedListKTimes.addFirst(2);
        rotateLinkedListKTimes.addFirst(1);
        rotateLinkedListKTimes.addFirst(0);
        rotateLinkedListKTimes.display(head);
        int k = 4;

        ListNode result = rotateLinkedListKTimes.rotateRight(head, k);
        rotateLinkedListKTimes.display(result);
    }

    private static ListNode head;

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //add at first
    private void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    //display data
    private void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (k < 1 || head == null || head.next == null) {
            return head;
        }

        ListNode lastNode = head;

        int length = 1;

        //find the last node
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }

        lastNode.next = head;

        //find the number of rotations to do
        int rotations = k % length;

        //find the elements to skip
        int skip = length - rotations;

        //New end for rotation
        ListNode newEnd = head;

        //skip the elements
        for (int i = 0; i < skip - 1; i++) {
            newEnd = newEnd.next;
        }

        //change the head
        head = newEnd.next;
        newEnd.next = null;
        return head;
    }
}
