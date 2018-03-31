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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> r=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null)
        {
            r.add(Arrays.asList(root.val));
            q.offer(root);
        }
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            List<TreeNode> temp=new ArrayList<>();
            while(!q.isEmpty())
            {
                TreeNode p=q.poll();
                if(p.left!=null)
                {
                    l.add(p.left.val);
                    temp.add(p.left);
                }
                if(p.right!=null)
                {
                    l.add(p.right.val);
                    temp.add(p.right);
                }
            }
            if(!l.isEmpty())
                r.add(l);
            q.addAll(temp);
        }
        Collections.reverse(r);
        return r;
    }
}