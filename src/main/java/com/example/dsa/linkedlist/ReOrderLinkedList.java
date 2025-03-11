package com.example.dsa.linkedlist;

/**
 * LeetCode - Medium
 * Google, Microsoft, Amazon, Facebook
 * https://leetcode.com/problems/reorder-list/description/
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 */
public class ReOrderLinkedList {
    public static void main(String[] args) {
        ReOrderLinkedList reorderLinkedList = new ReOrderLinkedList();
        reorderLinkedList.addFirst(5);
        reorderLinkedList.addFirst(4);
        reorderLinkedList.addFirst(3);
        reorderLinkedList.addFirst(2);
        reorderLinkedList.addFirst(1);
        reorderLinkedList.display(head);
        reorderLinkedList.reorderList(head);
        reorderLinkedList.display(head);
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
        System.out.println("END");
    }

    //Leetcode solution
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        //find the middle of the list
        ListNode mid = middleNode(head);

        //reverse the second half of the list
        ListNode secondHead = reverseList(mid);
        ListNode firstHead = head;

        //merge the two lists
        while (firstHead != null && secondHead != null) {
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        //set the last node next to null
        if (firstHead != null) {
            firstHead.next = null;
        }
    }

    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

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
}
