package com.example.dsa.linkedlist;

/**
 * Easy
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Delete duplicates from a sorted linked list
 * Input: 1->1->2
 * Output: 1->2
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class DeleteDuplicate {

    public static void main(String[] args) {
        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
        deleteDuplicate.addFirst(5);
        deleteDuplicate.addFirst(10);
        deleteDuplicate.addFirst(10);
        deleteDuplicate.addFirst(10);
        deleteDuplicate.addFirst(15);
        deleteDuplicate.addFirst(20);
        deleteDuplicate.addFirst(20);
        deleteDuplicate.display();
        deleteDuplicate.deleteDuplicates();
        deleteDuplicate.display();
    }

    private ListNode head;
    private ListNode tail;

    // Definition for singly-linked list.
    class ListNode {
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

    //leetCode solution
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    //self implemented method with tail
    public void deleteDuplicates() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;

    }

    //self implemented for adding node at the beginning
    private void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    //self implemented to display data
    private void display() {
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
