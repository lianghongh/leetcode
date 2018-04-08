class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] matrix=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                matrix[i][j]='.';
        }
        List<List<String>> result = new ArrayList<>();
        dfs(matrix,0,result);
        return result;
    }
    
    //对棋盘做dfs搜索，把满足的结果填入到result中
    public void dfs(char[][] matrix,int cur,List<List<String>> result)
    {
        if(cur>=matrix.length)
        {
            List<String> l = new ArrayList<>();
            for(int i=0;i<matrix.length;i++)
                l.add(new String(matrix[i]));
            result.add(l);
            return;
        }

        for(int i=0;i<matrix.length;i++)
        {
            if(isSafe(matrix,i,cur))
            {
                matrix[i][cur]='Q';
                dfs(matrix,cur+1,result);
                matrix[i][cur]='.';
            }
        }
    }
    
    //判断选择第x行第y列的放置皇后是否与之前放置的皇后冲突
    public boolean isSafe(char[][] matrix,int x,int y)         
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(matrix[i][j]=='Q'&&(x+y==i+j||x-y==i-j||x==i))
                    return false;
            }
        }
        return true;
    }
}