/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode r=new ListNode(0);
        ListNode h=new ListNode(0);
        h.next=head;
        for(ListNode p=h.next;p!=null;)
        {
            ListNode q=r.next,m=r;
            for(;q!=null&&q.val<p.val;m=q,q=q.next);
            h.next=p.next;
            p.next=q;
            m.next=p;
            p=h.next;
        }
        return r.next;
    }
}