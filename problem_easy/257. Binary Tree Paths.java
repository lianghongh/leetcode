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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l=new ArrayList<>();
        if(root==null)
            return l;
        if(root.left==null&&root.right==null)
        {
            l.add(""+root.val);
            return l;
        }
        Stack<String> s=new Stack<>();
        s.push(""+root.val);
        get_path(root.left,s,l);
        get_path(root.right,s,l);
        return l;
    }
    
    public void get_path(TreeNode root,Stack<String> s,List<String> l)
    {
        if(root==null)
            return;
        if (root!=null&&root.left == null&&root.right==null) {
            s.push("->"+root.val);
            List<String> t = new ArrayList<>(s);
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < t.size(); i++)
                b.append(t.get(i));
            l.add(b.toString());
            s.pop();
            return;
        }
        s.push("->"+root.val);
        get_path(root.left,s,l);
        get_path(root.right,s,l);
        s.pop();
    }
}