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
    public List<TreeNode> generateTrees(int n) {
        if(n<=0)
            return new ArrayList<>();
        return generate(1,n);
    }
    
    public List<TreeNode> generate(int l,int r)
    {
        List<TreeNode> result=new ArrayList<>();
        if(l>r)
        {
            result.add(null);
            return result;
        }
        if(l==r)
        {
            result.add(new TreeNode(l));
            return result;
        }
        
        for(int i=l;i<=r;i++)
        {
            List<TreeNode> l_list=generate(l,i-1);
            List<TreeNode> r_list=generate(i+1,r);
            for(int j=0;j<l_list.size();j++)
            {
                for(int k=0;k<r_list.size();k++)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=l_list.get(j);
                    root.right=r_list.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}