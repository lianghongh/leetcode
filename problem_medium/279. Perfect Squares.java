class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<n+1;i++)
            dp[i]=Integer.MAX_VALUE;
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            int s=(int)Math.sqrt(i);
            for(int j=s;i-j*j>=0;j--)
                dp[i]=dp[i-j*j]+1<dp[i]?dp[i-j*j]+1:dp[i];
        }
        return dp[n];
    }
}