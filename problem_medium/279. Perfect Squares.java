//解法一：动态规划
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

//解法二：拉格朗日四平方和定理
class Solution{

    public boolean isSqrt(int n)
    {
        int s=(int)Math.sqrt(n);
        if(s*s==n)
            return true;
        return false;
    }

    public int numSquares(int n)
    {
        if(n<=0)
            return 0;
        while((n&3)==0)
            n>>=2;
        if((n&7)==7)      //拉格朗日三平方和定理，判断n是否满足4^a*(8m+7)的形式，如果不是则表明n可以表示为3个完全平方数的和
            return 4;

        int s=(int)Math.sqrt(n);
        for(int i=1;i<=s;i++)
        {
            if(isSqrt(n-i*i))
                return 2;
        }
        return 3;
    }
}