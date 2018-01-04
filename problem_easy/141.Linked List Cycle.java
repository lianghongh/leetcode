/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        Set<ListNode> l=new HashSet<>();
        ListNode p=head;
        boolean hasCycle=false;
        l.add(p);
        p=p.next;
        for(;p!=null;p=p.next)
        {
            if(l.contains(p))
            {
                hasCycle=true;
                break;
            }
            l.add(p);
        }
        return hasCycle;
    }
}