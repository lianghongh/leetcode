/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l=new ListNode(0);
        ListNode p=l,i,j;
        for(i=l1,j=l2;i!=null&&j!=null;p=p.next) {
            if (i.val<j.val) {
                ListNode t=i.next;
                i.next=null;
                p.next=i;
                i=t;
            }
            else
            {
                ListNode t=j.next;
                j.next=null;
                p.next=j;
                j=t;
            }
        }
        if (i!=null)
            p.next=i;
        if (j!=null)
            p.next=j;
        return l.next;
    }
}