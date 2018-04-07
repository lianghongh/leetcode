//方法一：DFS
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        int[] com = new int[k];
        dfs(n, com, 0, r);
        return r;
    }
    
    public void dfs(int n,int[] com,int cur,List<List<Integer>> result)
    {
        if(cur>=com.length)
        {
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<cur;i++)
                l.add(com[i]);
            result.add(l);
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(cur==0)
            {
                com[cur]=i;
                dfs(n,com,cur+1,result);
            }
            else if(i>com[cur-1])       //保证填充结果是按照递增的顺序排列的
            {
                com[cur]=i;
                dfs(n,com,cur+1,result);
            }
        }
    }
}


//方法二：回溯（也是DFS）
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        if(k<=0||n<=0)
            return r;
        List<Integer> current = new ArrayList<>();
        backtrack(k,1,n,current,r);
        return r;
    }
    
    //start和end表示组合中每个元素的取值范围
    public void backtrack(int k,int start,int end,List<Integer> current,List<List<Integer>> result)
    {
        if(k==0){
            result.add(new ArrayList<>(current));
            return;
        }
        //由于组合中的每个元素必须是按照从小到大的顺序排列的，因此组合中最后一个元素最大只能为n，倒数第二个为n-1，以此类推。
        //k表示剩余的待填入数字个数，由于数字必须按照从小到大的顺序排列，因此填充每个数的范围为[start,end-k+1]。比如当k=1时，最后一个数填充的范围为[start,end]即[start,n]
        //当k=2时由于最后一个数至多为n，因此填充范围为[start,n-1]才满足要求。
        for(int i=start;i<=end-k+1;i++)
        {
            current.add(i);
            backtrack(k-1,i+1,end,current,result);
            current.remove(current.size()-1);
        }
    }
}