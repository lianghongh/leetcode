class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] row=new boolean[10];
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                    continue;
                if(row[board[i][j]-'0'])
                    return false;
                row[board[i][j]-'0']=true;
            }
            Arrays.fill(row,false);
        }
        
        for(int j=0;j<9;j++)
        {
            for(int i=0;i<9;i++)
            {
                if(board[i][j]=='.')
                    continue;
                if(row[board[i][j]-'0'])
                    return false;
                row[board[i][j]-'0']=true;
            }
            Arrays.fill(row,false);
        }
        
        for(int i=0;i<9;i++)
        {
            for(int j=i/3*3;j<3+i/3*3;j++)
            {
                for(int k=(i-i/3*3)*3;k<3+(i-i/3*3)*3;k++)
                {
                    if(board[j][k]=='.')
                        continue;
                    if(row[board[j][k]-'0'])
                        return false;
                    row[board[j][k]-'0']=true;
                }
            }
            Arrays.fill(row,false);
        }
        
        return true;
    }
}