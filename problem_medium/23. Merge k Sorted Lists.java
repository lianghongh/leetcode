/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        return mergeSort(lists,0,lists.length-1);
    }
    
    public ListNode mergeSort(ListNode[] list,int l,int r)
    {
        if(l==r)
            return list[l];
        int m=(l+r)>>1;
        ListNode l1=mergeSort(list,l,m);
        ListNode l2=mergeSort(list,m+1,r);
        return merge(l1,l2);
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