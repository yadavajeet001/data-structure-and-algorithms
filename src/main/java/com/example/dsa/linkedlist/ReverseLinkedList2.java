package com.example.dsa.linkedlist;

/**
 * LeetCode - Medium
 * Google, Microsoft, Amazon, Facebook
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to position right,
 * and return the reversed list.
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ReverseLinkedList2 reverseLinkedList = new ReverseLinkedList2();
        reverseLinkedList.addFirst(5);
        reverseLinkedList.addFirst(4);
        reverseLinkedList.addFirst(3);
        reverseLinkedList.addFirst(2);
        reverseLinkedList.addFirst(1);
        reverseLinkedList.display(head);
        int left = 2;
        int right = 4;
        ListNode result = reverseLinkedList.reverseListBetween(head, left, right);
        reverseLinkedList.display(result);
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

    //LeetCode Solution
    private ListNode reverseListBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;

        //skip the nodes before left
        for (int i = 0; present != null && i < left - 1; i++) {
            prev = present;
            present = present.next;
        }

        //reverse between left and right
        ListNode last = prev;
        ListNode newEnd = present;
        assert present != null;
        ListNode next = present.next;

        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        //join the reversed part with the remaining list
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        //join the reversed part with the remaining list
        newEnd.next = present;
        return head;
    }
}
