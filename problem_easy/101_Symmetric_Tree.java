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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return eq(root.left,convert(root.right));
    }
    
    public TreeNode convert(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        convert(root.left);
        convert(root.right);
        return root;
    }
    
    public boolean eq(TreeNode node1,TreeNode node2)
    {
        if(node1==null&&node2==null)
            return true;
        if(node1==null||node2==null)
            return false;
        return node1.val==node2.val&&eq(node1.left,node2.left)&&eq(node1.right,node2.right);
    }
}