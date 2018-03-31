class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] sum=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<=i;j++)
                sum[i][0]+=grid[j][0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=i;j++)
                sum[0][i]+=grid[0][j];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                sum[i][j]=grid[i][j]+(sum[i-1][j]<sum[i][j-1]?sum[i-1][j]:sum[i][j-1]);
            }
        }
        return sum[m-1][n-1];
    }
}