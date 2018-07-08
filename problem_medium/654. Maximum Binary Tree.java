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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        return construct(nums,0,nums.length-1);
    }
    
    public TreeNode construct(int[] nums,int l,int r)
    {
        if(l>r)
            return null;
        int max=nums[l],max_index=l;
        for(int i=l+1;i<=r;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                max_index=i;
            }
        }
        TreeNode root=new TreeNode(nums[max_index]);
        root.left=construct(nums,l,max_index-1);
        root.right=construct(nums,max_index+1,r);
        return root;
    }
}