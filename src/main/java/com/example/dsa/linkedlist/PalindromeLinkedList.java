package com.example.dsa.linkedlist;

/**
 * LeetCode - Easy
 * Google, Amazon, Microsoft, Facebook
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * Given the head of a singly linked list, return true if it is a palindrome.
 * Input: head = [1,2,2,1]
 * Output: true
 * Input: head = [1,2]
 * Output: false
 * Time complexity - O(n)
 * Space Complexity - O(1)
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        palindromeLinkedList.addFirst(1);
        palindromeLinkedList.addFirst(2);
        palindromeLinkedList.addFirst(2);
        palindromeLinkedList.addFirst(1);
        palindromeLinkedList.display(head);
        boolean result = palindromeLinkedList.isPalindrome(head);
        System.out.println("Is Palindrome : " + result);
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

    private boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode secondHead = reverseList(mid);
        ListNode reReverseHead = secondHead;

        //travel both the list and compare the values
        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        //re-reverse the second half of the list
        reverseList(reReverseHead);

        //if both the list are equal then return true else false
        return head == null || secondHead == null;
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
