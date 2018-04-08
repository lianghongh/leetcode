/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0||head==null)
            return head;
        int length=0;
        ListNode h=new ListNode(0);
        h.next=head;
        for(ListNode p=head;p!=null;p=p.next,length++);
        int i=1;
        if(k>=length&&k%length==0)
            k=length;
        else
            k=k%length;
        ListNode p=head,q,r=h;
        for(;i<=length-k;i++,p=p.next)
            r=p;
        for(q=p;q.next!=null;q=q.next);
        r.next=q.next;
        q.next=h.next;
        h.next=p;
        return h.next;
    }
}