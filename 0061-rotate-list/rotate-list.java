/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        ListNode kth = head;
        for (int i = 0; i < k; i++) {
            kth = kth.next;
        }

        ListNode tail = head;
        while (kth.next != null) {
            tail = tail.next;
            kth = kth.next;
        }

        ListNode newHead = tail.next;
        tail.next = null;
        kth.next = head;

        return newHead;
    }
}