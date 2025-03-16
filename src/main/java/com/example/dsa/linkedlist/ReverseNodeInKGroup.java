package com.example.dsa.linkedlist;

/**
 * LeetCode - Hard
 * Google, Microsoft, Amazon, Facebook, LinkedIn
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * Space complexity - O(1)
 * Time complexity - O(n)
 */
public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ReverseNodeInKGroup reverseNodeInKGroup = new ReverseNodeInKGroup();
        reverseNodeInKGroup.addFirst(5);
        reverseNodeInKGroup.addFirst(4);
        reverseNodeInKGroup.addFirst(3);
        reverseNodeInKGroup.addFirst(2);
        reverseNodeInKGroup.addFirst(1);
        reverseNodeInKGroup.display(head);
        int k = 3;
        ListNode result = reverseNodeInKGroup.reverseNodeInKGroup(head, k);
        // ListNode result2 = reverseNodeInKGroup.reverseKGroup(head, k);
        reverseNodeInKGroup.display(result);
        // reverseNodeInKGroup.display(result2);
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
    private ListNode reverseNodeInKGroup(ListNode head, int k) {

        if (k < 1 || head == null) {
            return head;
        }

        int count = 0;
        ListNode prev = null;
        ListNode present = head;

        while (true) {
            //newEnd of the reversed list
            ListNode last = prev;
            //newEnd of the reversed list
            ListNode newEnd = present;
            ListNode next = present.next;

            //make change to not reverse if elements < k
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

            if (present == null) {
                break;
            }
            prev = newEnd;
        }

        return head;
    }


    //Another Leetcode solution
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        // Count the number of nodes in the list
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Reverse k nodes at a time
        while (count >= k) {
            curr = prev.next;
            ListNode next = curr.next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}




