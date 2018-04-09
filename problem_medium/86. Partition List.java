/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        List<ListNode> l=new ArrayList<>();
        ListNode h1=new ListNode(0),q,r;
        ListNode h2=new ListNode(0);
        h1.next=head;
        q=h1;
        r=h2;
        for(ListNode p=head;p!=null;)
        {
            if(p.val<x)
            {
                q.next=p.next;
                r.next=p;
                p.next=null;
                r=r.next;
                p=q.next;
            }else{
                l.add(p);
                q=p;
                p=p.next;
            }
        }
        for(int i=0;i<l.size();i++)
        {
            r.next=l.get(i);
            r=r.next;
        }
        return h2.next;
    }
}