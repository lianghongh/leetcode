/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA,pb=headB;   //定义两个指针pa和pb，每次把pa和pb往前移动一格
        boolean fa=true,fb=true;
        if(pa==null||pb==null)
            return null;
        do
        {
            if(pa==pb)                //当pa和pb指向同一节点时表明有交集，且该交集的首节点就是pa
                return pa;
            if(pa.next==null)         //当pa或pb到达链表尾时，分别指向另一条链表的首节点
            {
                if(fa)
                {
                    pa=headB;
                    fa=false;
                }
                else
                {
                    pa=headA;
                    fa=true;
                }
            }
            else
                pa=pa.next;
            if(pb.next==null)
            {
                if(fb)
                {
                    pb=headA;
                    fb=false;
                }
                else
                {
                    pb=headB;
                    fb=true;
                }
            }
            else
                pb=pb.next;
        }while(pa!=headA||pb!=headB);       //当pa和pb分别重新指向headA和headB时表明链表没有交集
        return null;
    }
}