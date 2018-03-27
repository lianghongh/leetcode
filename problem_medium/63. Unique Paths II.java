class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][];
        for(int i=0;i<m;i++)
            dp[i]=new int[n];
        int i=0;
        for(;i<m&&obstacleGrid[i][0]==0;i++)
            dp[i][0]=1;
        if(i<m)
        {
            for(int j=i;j<m;j++)
                dp[j][0]=0;
        }
        for(i=0;i<n&&obstacleGrid[0][i]==0;i++)
            dp[0][i]=1;
        if(i<n)
        {
            for(int j=i;j<n;j++)
                dp[0][j]=0;
        }
        for(i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}