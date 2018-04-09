/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode p=head;
        if(p==null)
            return null;
        int count=0;
        for(;p!=null;p=p.next)
            count++;
        return sort(head,count);
    }
    
    public ListNode sort(ListNode head,int n)
    {
        if(n==1)
            return head;
        int m=n/2;
        ListNode h=new ListNode(0),p=head,q=h;
        h.next=head;
        for(int i=0;i<m;i++)
        {
            q=p;
            p=p.next;
        }
        q.next=null;
        ListNode h1=sort(head,m);
        ListNode h2=sort(p,n-m);
        return merge(h1,h2);
    }
    
    public ListNode merge(ListNode h1,ListNode h2)
    {
        ListNode r=new ListNode(0),head1=new ListNode(0),head2=new ListNode(0);
        head1.next=h1;
        head2.next=h2;
        ListNode p=r;
        for(;h1!=null&&h2!=null;p=p.next)
        {
            if(h1.val<h2.val)
            {
                head1.next=h1.next;
                p.next=h1;
                h1.next=null;
                h1=head1.next;
            }
            else
            {
                head2.next=h2.next;
                p.next=h2;
                h2.next=null;
                h2=head2.next;
            }
        }
        while(h1!=null)
        {
            head1.next=h1.next;
            p.next=h1;
            h1.next=null;
            h1=head1.next;
            p=p.next;
        }
        while(h2!=null)
        {
            head2.next=h2.next;
            p.next=h2;
            h2.next=null;
            h2=head2.next;
            p=p.next;
        }
        return r.next;
    }
    
}