/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private List<Integer> l;
    private int index=-1;
    public BSTIterator(TreeNode root) {
        l=new ArrayList<>();
        order(root,l);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index+1<l.size();
    }

    /** @return the next smallest number */
    public int next() {
        return l.get(++index);
    }
    
    private void order(TreeNode root,List<Integer> l)
    {
        if(root!=null)
        {
            order(root.left,l);
            l.add(root.val);
            order(root.right,l);
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */