class Solution {
    public int totalNQueens(int n) {
        int[] queues = new int[n];
        Counter c = new Counter();
        dfs(queues,0,0,c);
        return c.count;
    }
    
    //计数器，用于统计找到的解的个数
    class Counter{
        public int count=0;
    }
    
    //使用dfs对可能的解进行搜索
    public void dfs(int[] queens,int size,int cur,Counter c)
    {
        if(cur==queens.length)
        {
            c.count++;
            return;
        }
        for(int i=0;i<queens.length;i++)
        {
            if(isSafe(queens,cur,i,size))
            {
                //找到解后进行回溯
                queens[cur]=i;
                dfs(queens,size+1,cur+1,c);
                queens[cur]=-1;
            }
        }
    }
    
    //判断新的解是否和之前的皇后冲突
    public boolean isSafe(int[] queens,int col_index,int x,int size)
    {
        for(int i=0;i<queens.length;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(queens[j]==i&&(col_index+x==i+j||x-queens[j]==col_index-j||x==queens[j]))
                    return false;
            }
        }
        return true;
    }
}