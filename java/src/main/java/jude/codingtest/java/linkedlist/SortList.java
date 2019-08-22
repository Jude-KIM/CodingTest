package jude.codingtest.java.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * Example 1:
     *
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     *
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(sortList(node1).val);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null)
            return head;


        List<Integer> list = new ArrayList<>();
        while(head != null) {
            sort(list, head.val);
            head = head.next;
        }

        head = new ListNode(list.get(list.size()-1));
        for(int i= list.size()-2; i>=0; i--) {
            ListNode tail = new ListNode(list.get(i));
            tail.next = head;
            head = tail;
        }

        return head;
    }

    private static void sort(List<Integer> list, int val) {
        if(list.size() == 0) {
            list.add(val);
        } else {
            int index = 0;
            for(int i=0; i< list.size(); i++) {
                index = i;
                int target = list.get(i);
                if(val >target) {
                    if(i == list.size()-1) {
                        list.add(val);
                        return;
                    } else {
                        continue;
                    }
                } else {
                    list.add(index, val);
                    return;
                }
            }

            if(index == list.size()-1)
                list.add(index, val);
            else
                list.add(index+1, val);
        }

    }
}
