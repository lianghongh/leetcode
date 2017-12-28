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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> r = new ArrayList<>();
        boolean flag=true;
        if (root == null)
            return r;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                temp.add(node);
            }
            for (int i = 0; i < temp.size(); i++) {
                TreeNode t = temp.get(i);
                l.add(t.val);
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }
            if (!flag)
                Collections.reverse(l);
            r.add(l);
            flag=!flag;
        }
        return r;
        
    }
}