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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }
    
    public TreeNode build(int[] pre, int[] in, int ps, int is, int len) {
        if (len == 0)
            return null;
        int i;
        for (i = is; i < len + is && pre[ps] != in[i]; i++) ;
        TreeNode root = new TreeNode(pre[ps]);
        root.left = build(pre, in, ps + 1, is, i - is);
        root.right = build(pre, in, i - is + ps + 1, i + 1, len - (i - is) - 1);
        return root;
    }
}