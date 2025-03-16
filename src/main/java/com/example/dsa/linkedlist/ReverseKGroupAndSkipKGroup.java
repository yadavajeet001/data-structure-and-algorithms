package com.example.dsa.linkedlist;

/**
 * LeetCode - Hard
 * Google, Microsoft, Amazon, Facebook, LinkedIn
 * Given the head of a linked list, reverse the nodes of the list k at a time and skip the k node,
 * and return the modified list.
 * Input: head = [1,2,3,4,5,6], k = 2
 * Output: [2,1,3,4,6,5]
 * Space complexity - O(1)
 * Time complexity - O(n)
 */
public class ReverseKGroupAndSkipKGroup {
    public static void main(String[] args) {
        ReverseKGroupAndSkipKGroup reverseKGroupAndSkipKGroup = new ReverseKGroupAndSkipKGroup();
        reverseKGroupAndSkipKGroup.addFirst(6);
        reverseKGroupAndSkipKGroup.addFirst(5);
        reverseKGroupAndSkipKGroup.addFirst(4);
        reverseKGroupAndSkipKGroup.addFirst(3);
        reverseKGroupAndSkipKGroup.addFirst(2);
        reverseKGroupAndSkipKGroup.addFirst(1);
        reverseKGroupAndSkipKGroup.display(head);
        int k = 2;
        ListNode result = reverseKGroupAndSkipKGroup.reverseKGroupAndSkipKGroup(head, k);
        reverseKGroupAndSkipKGroup.display(result);
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
    private ListNode reverseKGroupAndSkipKGroup(ListNode head, int k) {

        if (k < 1 || head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;

        while (present != null) {

            ListNode last = prev;
            //newEnd of the reversed list
            ListNode newEnd = present;

            ListNode next = present.next;

            for (int i = 0; present != null && i < k; i++) {
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

            //skip the k nodes
            for (int i = 0; present != null && i < k; i++) {
                prev = present;
                present = present.next;
            }
        }
        return head;
    }
}
