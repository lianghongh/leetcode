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
    private int pre=-1;
    private List<Integer> l;
    private int freq=0;
    private int max=0;
    public int[] findMode(TreeNode root) {
        l=new ArrayList<>();
        inorder(root);
        int[] r=new int[l.size()];
        for(int i=0;i<r.length;i++)
            r[i]=l.get(i);
        return r;
    }
    
    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        if(pre!=-1&&pre==root.val)
            freq++;
        else
            freq=1;
        if(freq==max)
            l.add(root.val);
        else if(freq>max)
        {
            max=freq;
            l=new ArrayList<>();
            l.add(root.val);
        }
        
        pre=root.val;
        inorder(root.right);
    }
}