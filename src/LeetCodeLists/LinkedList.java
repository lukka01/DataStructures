package LeetCodeLists;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LinkedList {
    ListNode head;
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public ListNode rev(ListNode node, ListNode prev) {
        if (node == null) return prev;
        ListNode after = node.next;
        node.next = prev;
        return rev(after,node);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public ListNode removeNthNode(ListNode head, int N) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy.next;
        for (int i = 0; i < N-1; i++) {
            if (temp.next == null) return head;
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
        return dummy.next;
    }

    public ListNode removeFromTheEnd(ListNode head, int N) {
        ListNode dummy = new ListNode(0,head);
        ListNode temp = dummy;
        for (int i = 0; i < N; i++) {
            if (head.next == null) return head;
            head = head.next;
        }
        while (head != null) {
            temp =  temp.next;
            head = head.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }








    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0,head);
        ListNode res =  dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        return dummy.next;
    }

    public ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode removeDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        boolean hasDuplicate = false;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val){
                hasDuplicate = true;
                fast.next = fast.next.next;
            }
            if (hasDuplicate) {
                slow = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }



    public int getDecimalValue(ListNode head) {
        if ( head == null) return 0;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count = count*2 + temp.val;
            temp = temp.next;
        }
        return count;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!= null)  {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode sec = reverse(slow.next);
        slow.next = null;
        while (sec != null) {
            if (head.val != sec.val) return false;
            sec = sec.next;
            head = head.next;
        }
        return true;
    }



}




