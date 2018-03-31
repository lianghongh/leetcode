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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> r=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        tran(root,s,r,sum);
        return r;
    }
    
    public void tran(TreeNode root,Stack<Integer> s,List<List<Integer>> r,int sum)
    {
        if(root==null)
            return;
        s.push(root.val);
        if(sum==root.val&&root.left==null&&root.right==null)
        {
            r.add(new ArrayList<>(s));
            s.pop();
            return;
        }
        else
        {
            tran(root.left,s,r,sum-root.val);
            tran(root.right,s,r,sum-root.val);
        }
        s.pop();
    }
}