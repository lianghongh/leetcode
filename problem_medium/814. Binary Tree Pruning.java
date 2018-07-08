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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null&&root.val==0)
            return null;
        delete(root.left,root);
        if(root.left!=null&&root.left.left==null&&root.left.right==null&&root.left.val==0)
            root.left=null;
        delete(root.right,root);
        if(root.right!=null&&root.right.left==null&&root.right.right==null&&root.right.val==0)
            root.right=null;
        return root;
    }
    
    public void delete(TreeNode root,TreeNode pre)
    {
        if(root==null)
            return;
        delete(root.left,root);
        if(root.left!=null&&root.left.left==null&&root.left.right==null&&root.left.val==0)
            root.left=null;
        delete(root.right,root);
        if(root.right!=null&&root.right.left==null&&root.right.right==null&&root.right.val==0)
            root.right=null;
    }
}