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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        int count = 0;

        while( count < k && curr != null){
            curr = curr.next;
            count++;
        }

        if(count < k) return head;

        //reverse linkedlist

        ListNode nextKGrpHead = curr;


        ListNode tail = null;
        ListNode prev = null;
        curr = head;

        count = k;
        while(count  >0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;

            if(tail == null) tail = prev;
        }

        tail.next = reverseKGroup( nextKGrpHead,  k);


        return prev;
        
    }
}