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
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums,0,nums.length-1);
    }
    
    public TreeNode toBST(int[] nums,int l,int r)
    {
        if(l>r)
            return null;
        int m=(l+r)>>1;
        TreeNode root=new TreeNode(nums[m]);
        root.left=toBST(nums,l,m-1);
        root.right=toBST(nums,m+1,r);
        return root;
    }
}