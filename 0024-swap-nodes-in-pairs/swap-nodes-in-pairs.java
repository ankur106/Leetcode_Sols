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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;


        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;

        ListNode fNext = curr.next;

        ListNode sNext = fNext.next;

        dummyHead.next = sNext;

        while(fNext != null && sNext != null){
            
            fNext.next = sNext.next;
            sNext.next = fNext;
            curr.next = sNext;

            curr = fNext;
            fNext = curr.next;
            if( fNext != null) sNext = fNext.next;
        }

        return dummyHead.next;
        
    }
}