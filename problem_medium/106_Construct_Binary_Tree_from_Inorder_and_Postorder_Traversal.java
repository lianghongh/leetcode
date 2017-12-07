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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, postorder.length - 1, inorder.length);
    }
    
     public TreeNode build(int[] inorder, int[] postorder, int is, int plast, int len) {
        if(len==0)
            return null;
        int i;
        for(i=is;i<is+len && postorder[plast]!=inorder[i];i++);
        TreeNode root=new TreeNode(postorder[plast]);
        root.left = build(inorder, postorder, is, plast-len+i-is, i-is);
        root.right = build(inorder, postorder, i + 1, plast - 1, len - (i-is+1) );
        return root;
    }
}