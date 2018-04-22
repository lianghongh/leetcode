class Solution {
    
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board,i,j,word,0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board,int i,int j,String word,int cur)
    {
        if(cur==word.length())
            return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        if(word.charAt(cur)!=board[i][j])
            return false;
        
        board[i][j]^=256;        //节省visited数组空间，屏蔽掉board[i][j]元素
        boolean result=dfs(board,i+1,j,word,cur+1)||dfs(board,i-1,j,word,cur+1)||dfs(board,i,j+1,word,cur+1)||dfs(board,i,j-1,word,cur+1);
        board[i][j]^=256;        //恢复board[i][j]元素
        return result;
    }
}