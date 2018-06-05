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
    private int min_depth=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        pre_order(root,1);
        return min_depth;
    }
    
    public void pre_order(TreeNode root,int depth)
    {
        if(root!=null)
        {
            if(root.left==null&&root.right==null)
            {
                min_depth=depth<min_depth?depth:min_depth;
                return;
            }
            pre_order(root.left,depth+1);
            pre_order(root.right,depth+1);
        }
    }
}