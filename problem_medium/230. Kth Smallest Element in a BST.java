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
    public int kthSmallest(TreeNode root, int k) {
        int l=total(root.left);
        if(k<=l)
            return kthSmallest(root.left,k);
        else if(k>l+1)
            return kthSmallest(root.right,k-l-1);
        return root.val;
    }
    
    public int total(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+total(root.left)+total(root.right);
    }
}