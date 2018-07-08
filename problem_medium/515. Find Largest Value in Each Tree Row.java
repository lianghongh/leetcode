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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        Queue<TreeNode> row=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            while(!q.isEmpty())
                row.offer(q.poll());
            int max=0x80000000;
            while(!row.isEmpty())
            {
                TreeNode t=row.poll();
                if(t.val>max)
                    max=t.val;
                if(t.left!=null)
                    q.offer(t.left);
                if(t.right!=null)
                    q.offer(t.right);
            }
            result.add(max);
        }
        return result;
    }
}