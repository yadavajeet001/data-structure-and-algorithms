package com.example.dsa.linkedlist;

/**
 * LeetCode - Easy
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Time complexity - O(n)
 * Space Complexity - O(1)
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.addFirst(5);
        reverseLinkedList.addFirst(4);
        reverseLinkedList.addFirst(3);
        reverseLinkedList.addFirst(2);
        reverseLinkedList.addFirst(1);
        reverseLinkedList.display(head);
        ListNode result = reverseLinkedList.reverseList(head);
        reverseLinkedList.display(result);
        ListNode recursiveRes = reverseLinkedList.reverseListWithRecursion(result);
        reverseLinkedList.display(recursiveRes);
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

    //LeetCode solution without recursion
    private ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    //Reverse LinkedList with recursion
    private ListNode reverseListWithRecursion(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
