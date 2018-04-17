/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode l1,l2,q;
        int i=1;
        ListNode h=new ListNode(0);
        h.next=head;
        q=h;
        for(l1=head;i<m&&l1!=null;l1=l1.next,i++)
            q=l1;
        for(l2=l1;i<n&&l2!=null;l2=l2.next,i++);
        for(ListNode p=l1;p!=l2;)
        {
            q.next=p.next;
            p.next=l2.next;
            l2.next=p;
            p=q.next;
        }
        return h.next;
    }
}