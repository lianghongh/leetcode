class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while(n>m)
        {
            n=n&(n-1);
            if(n==0)
                return 0;
        }
        return n;
    }
}