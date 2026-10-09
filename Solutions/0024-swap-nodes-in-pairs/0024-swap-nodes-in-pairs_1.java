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
        ListNode prev = null;
        ListNode cur = head;
        ListNode start = head;
        while(cur != null){
            System.out.println("cur "+cur.val);
            ListNode next = cur.next;
            if(next != null){
                System.out.println("next "+next.val);
                if(next.next != null) System.out.println("next.next "+next.next.val);
                if(cur == head){
                    start = cur.next;
                }
                cur.next = next.next;
                next.next = cur;
                // join swapped pairs
                if(prev != null){
                    prev.next = next;
                }
            }
            
            prev = cur;
            cur = cur.next;
        }
        return start;
    }
}