/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//方法一：遍历链表求得链表长度，然后删除第length-n+1个节点
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        for(ListNode p=head;p!=null;p=p.next)
            length++;
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode p=head,q=h;
        for(int i=0;p!=null&&i<length-n;i++)
        {
            q=p;
            p=p.next;
        }
        if(p!=null)
            q.next=p.next;
        else
            q.next=p;
        return h.next;
    }
}

//方法二：建立两个指针fast和slow，slow仅仅在n<=0时才向后移动一格。最终fast到达尾节点时slow.next就是要删除的节点
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h=new ListNode(666);
        h.next=head;
        ListNode fast=h,slow=h;
        for(int i=n;fast.next!=null;i--)
        {
            if(i<=0)
                slow=slow.next;
            fast=fast.next;
        }
        if(slow.next!=null)
            slow.next=slow.next.next;
        return h.next;
    }
}