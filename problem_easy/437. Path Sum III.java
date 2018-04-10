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
    public int pathSum(TreeNode root, int sum) {
        Counter c=new Counter();
        pre(root,sum,c);
        return c.counter;
    }
    public void pre(TreeNode root,int sum,Counter c)
    {
        if(root!=null)
        {
            rootDFS(root,0,sum,c);
            pre(root.left,sum,c);
            pre(root.right,sum,c);
        }
    }
    class Counter
    {
        public int counter=0;
    }
    public void rootDFS(TreeNode root,int sum,int target,Counter c)
    {
        if(root==null)
            return;
        if(sum+root.val==target)
            c.counter++;
        rootDFS(root.left,sum+root.val,target,c);
        rootDFS(root.right,sum+root.val,target,c);
    }
}