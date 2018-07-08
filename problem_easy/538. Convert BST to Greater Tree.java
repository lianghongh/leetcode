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
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        trans(root);
        return root;
    }
    
    public void trans(TreeNode root)
    {
        if(root==null)
            return;
        if(root.right!=null)
            trans(root.right);
        root.val+=sum;
        sum=root.val;
        if(root.left!=null)
            trans(root.left);
    }
}