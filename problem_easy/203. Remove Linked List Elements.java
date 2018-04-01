/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode q=h;
        for(ListNode p=head;p!=null;p=p.next)
        {
            if(p.val==val)
                q.next=p.next;
            else
                q=p;
        }
        return h.next;
    }
}
