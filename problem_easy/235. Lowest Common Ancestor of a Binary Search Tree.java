/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//对bst查找p和q的最小公共祖先
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null)
        {
            if(p.val<root.val&&q.val<root.val)    //p和q都在root的左子树，则进入左子树查找
                root=root.left;
            else if(p.val>root.val&&q.val>root.val)   //进入右子树查找
                root=root.right;
            else
                break;    //找到第一个分叉入口，返回该节点
        }
        return root;
    }

}