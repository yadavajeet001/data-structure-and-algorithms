package com.example.dsa.linkedlist;

import java.util.List;

/**
 * LeetCode - Medium
 * https://leetcode.com/problems/sort-list/
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)? Use merge sort
 */
public class SortLinkedList {
    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        sortLinkedList.addFirst(3);
        sortLinkedList.addFirst(1);
        sortLinkedList.addFirst(2);
        sortLinkedList.addFirst(4);
        sortLinkedList.display(head);

        ListNode result = sortLinkedList.sortList(head);
        sortLinkedList.display(result);
    }

    private static ListNode head;

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
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
    private ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    //find middle node
    private ListNode getMiddleNode(ListNode head) {
        ListNode midPrev = null;

        while (head != null && head.next != null) {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;

        return mid;
    }

    //merge array
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = list1 != null ? list1 : list2;
        return dummyHead.next;
    }
}

