class Solution {
    public int integerBreak(int n) {
        int[] word=new int[n+1];
        word[0]=0;
        word[1]=1;
        for(int i=2;i<=n;i++)
        {
            int max=0;
            for(int j=1;j<=i/2;j++)
            {
                int p=word[j]>j?word[j]:j;
                int q=word[i-j]>i-j?word[i-j]:i-j;
                if(p*q>max)
                    max=p*q;
            }
            word[i]=max;
        }
        return word[n];
    }
}