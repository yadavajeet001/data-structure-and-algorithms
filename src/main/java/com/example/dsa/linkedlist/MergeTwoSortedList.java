package com.example.dsa.linkedlist;

/**
 * LeetCode - Easy
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedList {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        MergeTwoSortedList firstList = new MergeTwoSortedList();
        firstList.addLast(1);
        firstList.addLast(2);
        firstList.addLast(4);
        firstList.display();
        MergeTwoSortedList secondList = new MergeTwoSortedList();
        secondList.addLast(1);
        secondList.addLast(3);
        secondList.addLast(4);
        secondList.display();
        MergeTwoSortedList result = mergeTwoLists(firstList, secondList);
        result.display();
    }

    //inner class Node
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

//  LeetCode Solution
//    class Solution {
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            ListNode dummyHead = new ListNode();
//            ListNode tail = dummyHead;
//
//            while( list1 != null && list2 != null){
//                if(list1.val < list2.val){
//                    tail.next = list1;
//                    list1 = list1.next;
//                    tail = tail.next;
//                } else {
//                    tail.next = list2;
//                    list2 = list2.next;
//                    tail = tail.next;
//                }
//            }
//            tail.next = list1 != null ? list1 : list2;
//            return dummyHead.next;
//        }
//    }

    //merge two sorted list
    private static MergeTwoSortedList mergeTwoLists(MergeTwoSortedList list1, MergeTwoSortedList list2) {
        Node first = list1.head;
        Node second = list2.head;
        MergeTwoSortedList ans = new MergeTwoSortedList();

        while (first != null && second != null) {
            if (first.data < second.data) {
                ans.addLast(first.data);
                first = first.next;
            } else {
                ans.addLast(second.data);
                second = second.next;
            }
        }

        while (first != null) {
            ans.addLast(first.data);
            first = first.next;
        }

        while (second != null) {
            ans.addLast(second.data);
            second = second.next;
        }
        return ans;
    }

    //add at first
    private void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    //add at last
    private void addLast(int data) {
        if (tail == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
    }

    //display data
    private void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
