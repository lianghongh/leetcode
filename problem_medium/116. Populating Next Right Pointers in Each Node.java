/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> q=new LinkedList<>();
        List<TreeLinkNode> temp=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            while(!q.isEmpty())
                temp.add(q.poll());
            for(int i=0;i<temp.size()-1;i++)
                temp.get(i).next=temp.get(i+1);
            temp.get(temp.size()-1).next=null;
            for(int i=0;i<temp.size();i++)
            {
                if(temp.get(i).left!=null)
                    q.offer(temp.get(i).left);
                if(temp.get(i).right!=null)
                    q.offer(temp.get(i).right);
            }
            temp.clear();
        }
    }
}