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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        if (root!=null)
        {
            r.add(root.val);
            q.offer(root);
        }
        while (!q.isEmpty())
        {
            List<TreeNode> t = new ArrayList<>();
            while (!q.isEmpty())                      //层次遍历，把每一层的元素放到t中
            {
                TreeNode p=q.poll();
                if(p.left!=null)
                    t.add(p.left);
                if(p.right!=null)
                    t.add(p.right);
            }
            if(!t.isEmpty())
            {
                r.add(t.get(t.size()-1).val);         //把每一层的最右边元素添加到结果列表r中
                q.addAll(t);
            }
        }
        return r;
    }
}