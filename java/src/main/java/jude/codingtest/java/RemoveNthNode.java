package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNode {

    public static void main(String[] args) throws IOException {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;


        removeNthFromEnd(head, 2);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null) {
            return head.next;
        }

        ListNode currentNode = head;
        int count = 1;
        while (currentNode.next != null) {
            count++;
            currentNode = currentNode.next;
        }
        int removeIndex = count - n;
        if(removeIndex == 0)
            return head.next;

        ListNode node = head;
        for(int i = 1; i <= count; i++) {
            if(node != null) {
                System.out.println(node.val);
                if (i == removeIndex) {
                    node.next = node.next.next;
                }
                node = node.next;
            }
        }

        return head;
    }

    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

}
