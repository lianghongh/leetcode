/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> l=new ArrayList<>();
        for(ListNode p=head;p!=null;p=p.next)
            l.add(p.val);
        Integer[] nums=new Integer[l.size()];
        l.toArray(nums);
        return toBST(nums,0,nums.length-1);
    }
    
    public TreeNode toBST(Integer[] nums,int l,int r)
    {
        if(l>r)
            return null;
        int m=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[m]);
        root.left=toBST(nums,l,m-1);
        root.right=toBST(nums,m+1,r);
        return root;
    }
}