/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        int m=0;
        head.next=null;
        ListNode q=head;
        for(;l1!=null&&l2!=null;l1=l1.next,l2=l2.next) {
            ListNode p = new ListNode((l1.val + l2.val + m) % 10);
            p.next=null;
            m=(l1.val+l2.val+m)/10;
            q.next=p;
            q=q.next;
        }
        for(;l1!=null;l1=l1.next)
        {
            ListNode p = new ListNode((l1.val + m) % 10);
            p.next=null;
            m=(l1.val+m)/10;
            q.next=p;
            q=q.next;
        }
        for(;l2!=null;l2=l2.next) {
            ListNode p = new ListNode((l2.val + m) % 10);
            p.next=null;
            m = (l2.val + m) / 10;
            q.next=p;
            q=q.next;
        }
        if (m != 0) {
            q.next = new ListNode(m);
        }
        return head.next;
    }
}