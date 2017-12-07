/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
         ListNode current=new ListNode(0);
        current.next=head;
        ListNode cur=current;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1=cur.next;
            ListNode node2=cur.next.next;
            cur.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            cur=cur.next.next;
        }
        return current.next;
    }
}


