/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode q=h.next;
        for(ListNode p=head.next;p!=null;)
        {
            q.next=p.next;
            p.next=h.next;
            h.next=p;
            p=q.next;
        }
        return h.next;
    }
}