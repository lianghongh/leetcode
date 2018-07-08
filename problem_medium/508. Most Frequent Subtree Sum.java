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
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        cal(root,l);
        Collections.sort(l);
        int freq=1,max=1;
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i).equals(l.get(i-1)))
                freq++;
            else
                freq=1;
            if(freq>max)
                max=freq;
        }
        if(l.size()==1)
            r.add(l.get(0));
        freq=1;
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i).equals(l.get(i-1)))
                freq++;
            else
                freq=1;
            if(freq==max)
                r.add(l.get(i-1));
        }
        if(max==1&&l.size()>1)
            r.add(l.get(l.size()-1));
        int[] result=new int[r.size()];
        for(int i=0;i<r.size();i++)
            result[i]=r.get(i);
        return result;
    }
    
    public void cal(TreeNode root,List<Integer> l)
    {
        if(root==null)
            return;
        if(root.left!=null)
        {
            cal(root.left,l);
            root.val+=root.left.val;
        }
        if(root.right!=null)
        {
            cal(root.right,l);
            root.val+=root.right.val;
        }
        l.add(root.val);
    }
}